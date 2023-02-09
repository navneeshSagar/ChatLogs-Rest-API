package com.navneesh.assignments.rest;

public class ChatLogErrorResponse {
    private int status;
    private String message;

    public ChatLogErrorResponse(){

    }

    public ChatLogErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
