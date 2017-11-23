package com.xp.springboot.mop.enums.upload;
/**
 * 
* @ClassName: ShowPicExceptionEnum 
* @Description: TODO
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*
 */
public enum ShowPicExceptionEnum {

	SUCCESS(0, "success"), TYPE_SHIPPING(1, "运费优惠券");

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

	private ShowPicExceptionEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (ShowPicExceptionEnum item : ShowPicExceptionEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
