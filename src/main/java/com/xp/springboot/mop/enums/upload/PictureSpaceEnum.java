package com.xp.springboot.mop.enums.upload;
/**
* 
* @ClassName: ShowPicExceptionEnum 
* @Description: 图片上传 空间枚举
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*空间：1.客厅 2.卧室 3.书房 4.卫生间 5.厨房 6.阳台 7.餐厅 8.玄关 9.过道 10.儿童房 11.衣帽间
*/
public enum PictureSpaceEnum {

	LIVING_ROOM(1, "客厅"),
	BEDROOM(2, "卧室"),
	STUDY_ROOM(3, "书房"),
	TOILET(4, "卫生间"),
	KITCHEN(5, "厨房"),
	BALCONY(6, "阳台"),
	RESTAURANT(7, "餐厅"),
	ENTRANCE(8, "玄关"),
	AISLE(9, "过道"),
	CHILDREN_ROOM(10, "儿童房"),
	CLOAKROOM(11, "衣帽间");

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

	private PictureSpaceEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (PictureSpaceEnum item : PictureSpaceEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
