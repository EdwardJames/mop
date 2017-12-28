package com.xp.springboot.mop.exception;

@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

    private int code;
    private String msg;
    private boolean alarmed = false;

    public BusinessException() {
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(int code, String msg, boolean alarmed) {
        this.code = code;
        this.msg = msg;
        this.alarmed = alarmed;
    }

    /**
     * 构建异常
     *
     * @param code
     * @param msg
     * @return
     */
    public static BusinessException of(int code, String msg) {
        return new BusinessException(code, msg);
    }

    /**
     * 构建异常
     *
     * @param code
     * @param msg
     * @return
     */
    public static BusinessException of(int code, String msg, boolean alarmed) {
        return new BusinessException(code, msg, alarmed);
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isAlarmed() {
        return alarmed;
    }

    public void setAlarmed(boolean alarmed) {
        this.alarmed = alarmed;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String getMessage() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "BusinessException{" + "code=" + code + ", msg='" + msg + '\'' + '}';
    }
}
