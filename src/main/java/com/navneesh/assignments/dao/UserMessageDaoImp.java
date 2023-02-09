package com.navneesh.assignments.dao;

import com.navneesh.assignments.model.Message;
import com.navneesh.assignments.model.User;
import com.navneesh.assignments.rest.UserNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class UserMessageDaoImp implements UserMessageDAO{

    private Map<String, User> users = new HashMap<>();
    @Override
    public List<Message> getMessages(String username, int startIndex, int limit) {
        if(users.containsKey(username)){
            User user = users.get(username);

            List<Message> messages = user.getMessages();

            if(startIndex+limit > messages.size()){
                return messages.subList(startIndex, messages.size());
            }

            return messages.subList(startIndex, startIndex+limit);

        }
        else{
            throw new UserNotFoundException("User with username " + username + " not found.");
        }
    }


    @Override
    public void removeUser(String username) {
        if(users.containsKey(username)){
            users.remove(username);

        }
        else{
            throw new UserNotFoundException("User with Username " + username + "  not found.");
        }

    }

    @Override
    public void deleteMessage(String username, String msgid) {
        if(this.users.containsKey(username)) {
            users.get(username).deleteMessage(msgid);
        }
        else{
            throw new UserNotFoundException("User with username " + username + " not found");
        }

    }

    @Override
    public void addMessage(String username, Message message) {
        if(users.containsKey(username)){
            User user = users.get(username);
            user.addMessage(message);
        }
        else{
            User user = new User(username);
            user.addMessage(message);
            this.users.put(username, user);
        }
    }
}
