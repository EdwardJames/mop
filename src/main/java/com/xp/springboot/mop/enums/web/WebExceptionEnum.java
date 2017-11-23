package com.xp.springboot.mop.enums.web;
/**
 * 
* @ClassName: ShowPicExceptionEnum 
* @Description: TODO
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*
 */
public enum WebExceptionEnum {

	SUCCESS(0, "success"), DEFAULT_FAIL(-1, "fail");

	private int code;

	private String name;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private WebExceptionEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (WebExceptionEnum item : WebExceptionEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
