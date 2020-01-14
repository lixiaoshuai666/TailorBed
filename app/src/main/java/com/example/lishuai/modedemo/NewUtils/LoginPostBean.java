package com.example.lishuai.modedemo.NewUtils;

import java.io.Serializable;

public class LoginPostBean implements Serializable {
    private String password;
    private String usernameOrEmailOrPhone;
    private boolean rememberMe=true;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernameOrEmailOrPhone() {
        return usernameOrEmailOrPhone;
    }

    public void setUsernameOrEmailOrPhone(String usernameOrEmailOrPhone) {
        this.usernameOrEmailOrPhone = usernameOrEmailOrPhone;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}
