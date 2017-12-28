package com.xp.springboot.mop.config.monitor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.xp.springboot.mop.annotation.AopLog;
import com.xp.springboot.mop.common.Result;
import com.xp.springboot.mop.common.ResultCode;
import com.xp.springboot.mop.exception.BusinessException;


/**
 * facade层统一监控及拦截异常，不适用于web请求
 *
 */
public class MonitorInterceptor implements MethodInterceptor {
    private static Logger logger = LoggerFactory.getLogger(MonitorInterceptor.class);

    private boolean alarmed = false;

    public void setAlarmed(boolean alarmed) {               
        this.alarmed = alarmed;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        String clazz = invocation.getMethod().getDeclaringClass().getSimpleName();
        Object[] args = invocation.getArguments();

        AopLog aopLog = invocation.getMethod().getAnnotation(AopLog.class);
        aopLog = aopLog == null ? invocation.getMethod().getDeclaringClass().getAnnotation(AopLog.class) : aopLog;
        boolean isPrint = aopLog != null ? aopLog.isPrint() : true;
        boolean isAlarm = aopLog != null ? aopLog.isAlarm() : alarmed;
        String desc = aopLog != null ? aopLog.value() : "";
        long begin = System.currentTimeMillis();
        if (isPrint && logger.isInfoEnabled()) {
            logger.info("[monitor]-[{}.{}-{}]--begin, args={}", clazz, methodName, desc, JSONObject.toJSON(args));
        }
        try {
            Object result = invocation.proceed();
            if (isPrint && logger.isInfoEnabled()) {
                long cost = System.currentTimeMillis() - begin;
                logger.info("[monitor]-[{}.{}-{}]--end, cost={}ms, args={}, result={}", clazz, methodName, desc, cost, JSONObject.toJSON(args), JSONObject.toJSON(result));
            }
            return result;
        } catch (BusinessException e) {
            long cost = System.currentTimeMillis() - begin;
            if (isPrint) {
                logger.error("[monitor]-[{}.{}-{}]--business exception, cost={}ms, args={}", clazz, methodName, desc, cost, JSONObject.toJSON(args), e);
            }
            if (isAlarm && e.isAlarmed()) {
                Alarmer.defaultAlarmer().send("[monitor]-[{}.{}-{}]--business exception, cost={}ms, args={}", clazz, methodName, desc, cost, JSONObject.toJSON(args), e);
            }
            return Result.fail(e);
        } catch (Throwable e) {
            long cost = System.currentTimeMillis() - begin;
            logger.error("[monitor]-[{}.{}-{}]--application exception, cost={}ms, args={}", clazz, methodName, desc, cost, JSONObject.toJSON(args), e);
            if (isAlarm) {
                Alarmer.defaultAlarmer().send("[monitor]-[{}.{}-{}]--business exception, cost={}ms, args={}", clazz, methodName, desc, cost, JSONObject.toJSON(args), e);
            }
        }
        return ResultCode.ExceptionOccured.result("服务端异常");
    }
}
