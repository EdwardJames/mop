package com.xp.springboot.mop.dto;

import java.io.Serializable;


public class ShowPicResponseDto<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4277033640124120640L;

	/**
	 * 返回信息码
	 */
	private int responseCode;

	/**
	 * 返回信息
	 */
    private String responseMsg;

	/**
	 * 结果dto
	 */
    private T responseDto;
    
    public static final int SUCCESS = 0;
    
    public static final int FAILURE = -1;

	public int getResponseCode() {
		return responseCode;
	}

    public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

    public String getResponseMsg() {
		return responseMsg;
	}

    public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

    public T getResponseDto() {
		return responseDto;
	}

    public void setResponseDto(T responseDto) {
		this.responseDto = responseDto;
	}

    public boolean isSuccessful() {
		return responseCode == SUCCESS && responseDto != null;
	}

	public ShowPicResponseDto(int responseCode, String responseMsg, T responseDto) {
		super();
		this.responseCode = responseCode;
		this.responseMsg = responseMsg;
		this.responseDto = responseDto;
	}

	public ShowPicResponseDto() {
		super();
	}

    
	
}
