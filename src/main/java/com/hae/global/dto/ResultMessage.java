package com.hae.global.dto;

import java.io.Serializable;

public class ResultMessage extends BaseObject implements Serializable {

    private String success;
    private String status;
    private String message;

    public ResultMessage() {
    }

    public ResultMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public ResultMessage setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultMessage setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
