package com.xp.springboot.mop.common;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * RPC调用的结果封装
 *
 * @param <T> 具体返回的结构
 * @author iwang
 */
public final class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7196738187866457409L;

    /**
     * 错误码
     */
    private int code = 0;

    /**
     * 错误消息
     */
    private String msg;

    /**
     * 符合条件的记录
     */
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static <T> Result<T> succeed() {
        return new Result<>();
    }

    /**
     * 返回成功结果
     *
     * @param data 返回的数据
     * @param <T>
     * @return
     */
    public static <T> Result<T> succeed(T data) {
        return new Result<>(data);
    }

    /**
     * 返回成功消息
     *
     * @param msg 指定成功消息
     * @param <T>
     * @return
     */
    public static <T> Result<T> succeed(String msg) {
        return new Result<>(0, msg);
    }

    /**
     * 返回成功结果
     *
     * @param field 指定节点名称
     * @param data  返回的数据
     * @param <T>
     * @return
     */
    public static <T> Result<Map<String, T>> succeed(String field, T data) {
        Map<String, T> map = new HashMap<>();
        map.put(field, data);
        return new Result<>(map);
    }

    /**
     * 返回成功结果
     *
     * @param field 指定节点名称
     * @param data  返回的数据
     * @return
     */
    public static Result<Map<String, Object>> succeed(String field, Object data, String field1, Object data1) {
        Map<String, Object> map = new TreeMap<>();
        map.put(field, data);
        map.put(field1, data1);
        return new Result<>(map);
    }

    /**
     * 返回成功结果
     *
     * @param field 指定节点名称
     * @param data  返回的数据
     * @return
     */

    /**
     * 返回成功结果
     *
     * @param field  节点名称
     * @param data   节点数据
     * @param field1 节点名称
     * @param data1  节点数据
     * @param args   成对返回的数据
     * @return
     */
    public static Result<Map<String, Object>> succeed(String field, Object data, String field1, Object data1, Object... args) {
        Map<String, Object> map = new TreeMap<>();
        map.put(field, data);
        map.put(field1, data1);
        if (args != null) {
            if (args.length % 2 != 0) {
                throw new IllegalArgumentException("参数个数不对");
            }
            for (int i = 0; i < args.length; i++) {
                if (args[i] == null) {
                    continue;
                }
                map.put(args[i].toString(), args[++i]);
            }
        }
        return new Result<>(map);
    }



    /**
     * 返回失败结果
     *
     * @param code 失败场景的代码
     * @param msg  失败场景的消息
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(int code, String msg) {
        return new Result<>(code, msg);
    }

    /**
     * 返回失败结果
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> fail(int code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }


    /**
     * 是否成功，条件code == 0 && data != null
     *
     * @return
     */
    @JsonIgnore
    public boolean isSucceed() {
        return code == 0 && data != null;
    }

    /**
     * 是否失败，条件code != 0 || data == null
     *
     * @return
     */
    @JsonIgnore
    public boolean isFailed() {
        return code != 0 || data == null;
    }


    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Result{code=");
        builder.append(code);
        if (msg != null) {
            builder.append(", msg='").append(msg).append("'");
        }
        if (data != null) {
            builder.append(", data=").append(data);
        }
        builder.append("}");
        return builder.toString();
    }
}