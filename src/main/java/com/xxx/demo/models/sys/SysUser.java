package com.xxx.demo.models.sys;

import java.util.Date;

public class SysUser implements java.io.Serializable {
    private String userId;
    private String userName;
    private String realName;
    private String userPassword;
    private String email;
    private String cellphone;
    private boolean isFirstLogin;
    private boolean isDeleted;
    private Date createdTime;
    private String description;
    private boolean isShowStartPage;
    private boolean isEnable;
    private Integer isPassed;

    /**
     * default constructor
     */
    public SysUser() {
    }

    public SysUser(String userId, String userName, String realName, String userPassword, String email, String cellphone, boolean isFirstLogin, boolean isDeleted, Date createdTime, String description, boolean isShowStartPage, boolean isEnable, Integer isPassed) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.userPassword = userPassword;
        this.email = email;
        this.cellphone = cellphone;
        this.isFirstLogin = isFirstLogin;
        this.isDeleted = isDeleted;
        this.createdTime = createdTime;
        this.description = description;
        this.isShowStartPage = isShowStartPage;
        this.isEnable = isEnable;
        this.isPassed = isPassed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public boolean isFirstLogin() {
        return isFirstLogin;
    }

    public void setFirstLogin(boolean firstLogin) {
        isFirstLogin = firstLogin;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isShowStartPage() {
        return isShowStartPage;
    }

    public void setShowStartPage(boolean showStartPage) {
        isShowStartPage = showStartPage;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public Integer getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Integer isPassed) {
        this.isPassed = isPassed;
    }
}
