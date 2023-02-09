package com.navneesh.assignments.model;

import java.util.UUID;

public class Message {
    private final String msgid;
    private final String message;
    private final Long timestamp;
    private final Boolean isSent;

    public Message(String message, Long timestamp, Boolean isSent) {
        this.msgid = this.getuuid();
        this.message = message;
        this.timestamp = timestamp;
        this.isSent = isSent;
    }

    public String getMessage() {
        return message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public Boolean getSent() {
        return isSent;
    }

    public String getMsgid(){
        return this.msgid;
    }

    private String getuuid(){
        return UUID.randomUUID().toString();
    }
}
