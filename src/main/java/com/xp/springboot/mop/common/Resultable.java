package com.xp.springboot.mop.common;

import java.io.Serializable;

/**
 * @author iwang
 */
public interface Resultable extends Serializable {

    int BASIC = 1000;
    /**
     * admin系统
     */
    int ADMIN = BASIC;
    /**
     * product系统
     */
    int PRODUCT = ADMIN + BASIC;

    /**
     * order系统
     */
    int ORDER = PRODUCT + BASIC;

    /**
     * 车型库系统
     */
    int CARPORT = ORDER + BASIC;

    /**
     * 返回响应代码
     *
     * @return
     */
    int getCode();

    /**
     * 返回响应消息
     *
     * @return
     */
    String getMsg();

    /**
     * 返回默认的结果，code=0
     *
     * @param <T>
     * @return
     */
    default <T> Result<T> result() {
        return Result.fail(getCode(), getMsg());
    }

    /**
     * 返回包括指定消息的结果，code=0
     *
     * @param msg
     * @param <T>
     * @return
     */
    default <T> Result<T> result(String msg) {
        return Result.fail(getCode(), msg);
    }
}
