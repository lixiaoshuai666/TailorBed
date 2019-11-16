package com.example.lishuai.modedemo;

import java.io.Serializable;

public class BeasBean implements Serializable {

    /**
     * code : 200
     * message : 成功
     */

    public int code;
    public String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
