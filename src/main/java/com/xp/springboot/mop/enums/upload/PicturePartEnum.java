package com.xp.springboot.mop.enums.upload;
/**
 * 
* @ClassName: ShowPicExceptionEnum 
* @Description: 室内局部
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*
*/
public enum PicturePartEnum {

	BACKGROUND_WALL(1, "室内背景墙"),
	SUSPENDED_CEILING(2, "吊顶"),
	PARTITION(3,"隔断"),
	WINDOW_CURTAINS(4,"窗帘"),
	BAY_WINDOW(5,"飘窗"),
	TATAMI(6,"榻榻米"),
	CUPBOARD(7,"橱柜"),
    SHELF(8,"博古架"),
    ATTIC(9,"阁楼"),
    HIDDEN_DOOR(10,"隐形门"),
    BAR_COUNTER(11,"吧台"),
    DRINKS_CABINET(12,"酒柜"),
    SHOE_CABINET(13,"鞋柜"),
    WARDROBE(14,"衣柜"),
    WINDOW(15,"窗户"),
    PHOTO_WALL(16,"相片墙"),
    STAIRS(17,"楼梯"),
    WINDOWSILL(18,"窗台");
    
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

	private PicturePartEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (PicturePartEnum item : PicturePartEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
