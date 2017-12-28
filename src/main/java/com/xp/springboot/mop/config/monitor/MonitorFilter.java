package com.xp.springboot.mop.config.monitor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.PatternMatchUtils;

import com.alibaba.fastjson.JSONObject;
import com.xp.springboot.mop.util.web.ServletUtils;

/**
 * http接口的监控日志
 *
 */
@WebFilter
public class MonitorFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(MonitorFilter.class);

    private boolean alarmed = false;
    private String[] pattern;

    public MonitorFilter setAlarmed(boolean alarmed) {
        this.alarmed = alarmed;
        return this;
    }

    public MonitorFilter setPattern(String pattern) {
        this.pattern = pattern.split(",");
        return this;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest resq = (HttpServletRequest) servletRequest;
        if (pattern != null && PatternMatchUtils.simpleMatch(pattern, resq.getRequestURI())) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        long start = System.currentTimeMillis();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            long cost = System.currentTimeMillis() - start;
            logger.info("[monitor]-request end, uri={}, cost={}ms, args={}, remoteIP={}", resq.getRequestURI(), cost, JSONObject.toJSON(resq.getParameterMap()), ServletUtils.IP(resq));
        } catch (Throwable e) {
            long cost = System.currentTimeMillis() - start;
            logger.error("[monitor]-occur exception, uri={}, cost={}ms, args={}, remoteIP={}", resq.getRequestURI(), cost, JSONObject.toJSON(resq.getParameterMap()), ServletUtils.IP(resq), e);
            if (alarmed) {
                Alarmer.defaultAlarmer().send("[monitor]-occur exception, uri={}, cost={}ms, args={}, remoteIP={}", resq.getRequestURI(), cost, JSONObject.toJSON(resq.getParameterMap()), ServletUtils.IP(resq), e);
            }
        }
        return;
    }

    @Override
    public void destroy() {

    }

}
