package com.navneesh.assignments.model;

import com.navneesh.assignments.rest.MessageNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {
    private List<Message> messages = new ArrayList<>();
    private final String username;


    public User(String username) {
        this.username = username;
    }

    public void addMessage(Message message){
        this.messages.add(0, message);
    }

    public void deleteMessage(String msgid){
        Iterator<Message> itr = messages.iterator();
        boolean deleted = false;
        while(itr.hasNext()){
            Message msg = itr.next();

            if (msgid.equals(msg.getMsgid())){
                itr.remove();
                deleted = true;
                break;
            }
        }
        if(!deleted){
          throw new MessageNotFoundException("Message with id " + msgid +" not found.");
        }

    }

    public String getUsername(){
        return this.username;
    }

    public List<Message> getMessages(){
        return this.messages;
    }
}
