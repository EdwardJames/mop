package com.xp.springboot.mop.enums.upload;
/**
* 
* @ClassName: ShowPicExceptionEnum 
* @Description:用于图片的风格
* @author peng.xu
* @date 2017年7月24日 下午6:25:22 
*风格 1.简约 2.现代 3.中式 4.欧式 5.美式 6.田园 7.新古典  8.地中海 9.东南亚 10日式 11宜家 12北欧 13简欧 14巴洛克 15.复古 16.混搭'
 */
public enum PictureStyleEnum {

	SIMPLE(1, "简约"),
	MODERN(2, "现代"),
	CHINESE_STYLE(3, "中式"),
	EUROPEAN(4, "欧式"),
    AMERICAN(5, "美式"),
    COUNTRYSIDE(6, "田园"),
    NEO_CLASSICAL(7, "新古典"),
    MEDITERRANEAN_SEA(8, "地中海"),
    SOUTHEAST_ASIA(9, "东南亚"),
    JAPANESE(10, "日本"),
    IKEA(11, "宜家"),
    NORTHERN_EUROPE(12, "北欧"),
    SIMPLE_EUROPEAN(13, "简欧"),
    BAROQUE(14, "巴洛克"),
    RETRO(15, "复古"),
    MIX(16, "混搭");
    
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

	private PictureStyleEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getNameByCode(int code) {
		for (PictureStyleEnum item : PictureStyleEnum.values()) {
			if (item.getCode() == code) {
				return item.getName();
			}
		}
		return null;
	}
}
