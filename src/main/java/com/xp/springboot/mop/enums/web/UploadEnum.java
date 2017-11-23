package com.xp.springboot.mop.enums.web;
/**
 * 
* @ClassName: ShowPicExceptionEnum 
* @Description: TODO
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*
 */
public enum UploadEnum {

	SUCCESS(0, "success"), EMPTY_FILE(-1, "上传文件为空");

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

	private UploadEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (UploadEnum item : UploadEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
