package com.xp.springboot.mop.dto.user;

public class UserDto {

    public UserDto() {
        
    }
    private Long userId;
    private String userName;
    private String mobile;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    

}
