package com.xp.springboot.mop.enums.upload;
/**
 * 
* @ClassName: ShowPicExceptionEnum 
* @Description: 用于上传图片选择对应的户型
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*
*/
public enum PictureApartmentLayoutEnum {

	 ONE_BEDROOM(1, "一居室"),
	 TWO_BEDROOM(2, "二居室"),
	 THREE_BEDROOM(3, "三居室"),
	 FOUR_BEDROOM(4, "四居室"),
	 COMPOUND(5,"复式"),
	 VILLA(6, "别墅"),
	 APARTMENT(7, "公寓"),
	 LOFT(8, "loft"),
	 SMALLROOM(9, "小户型");

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

	private PictureApartmentLayoutEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (PictureApartmentLayoutEnum item : PictureApartmentLayoutEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
