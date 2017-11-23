package com.xp.springboot.mop.domain.upload;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: UploadPictureRecord 
* @Description: 用于持久层数据上传图片数据落地
* @author peng.xu
* @date 2017年8月30日 下午3:35:50 
*
 */
public class UploadPictureRecord implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;

    private String picName;

    private String title;

    private Short apartmentLayout;

    private Short style;

    private Short area;

    private Short label;

    private Date createTime;

    private Date updateTime;

    private String uploadUser;

    private Long userId;

    private Short groupId;

    private Short space;

    private Short part;

    private Short source;

    private String description;

    private String location;
    
    private String imagePath;
    
    private Short topStatus;

    public Short getTopStatus() {
        return topStatus;
    }

    public void setTopStatus(Short topStatus) {
        this.topStatus = topStatus;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Short getApartmentLayout() {
        return apartmentLayout;
    }

    public void setApartmentLayout(Short apartmentLayout) {
        this.apartmentLayout = apartmentLayout;
    }

    public Short getStyle() {
        return style;
    }

    public void setStyle(Short style) {
        this.style = style;
    }

    public Short getArea() {
        return area;
    }

    public void setArea(Short area) {
        this.area = area;
    }

    public Short getLabel() {
        return label;
    }

    public void setLabel(Short label) {
        this.label = label;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUploadUser() {
        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {
        this.uploadUser = uploadUser == null ? null : uploadUser.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Short getGroupId() {
        return groupId;
    }

    public void setGroupId(Short groupId) {
        this.groupId = groupId;
    }

    public Short getSpace() {
        return space;
    }

    public void setSpace(Short space) {
        this.space = space;
    }

    public Short getPart() {
        return part;
    }

    public void setPart(Short part) {
        this.part = part;
    }

    public Short getSource() {
        return source;
    }

    public void setSource(Short source) {
        this.source = source;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

}