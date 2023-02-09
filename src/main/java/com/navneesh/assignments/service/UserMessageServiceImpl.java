package com.navneesh.assignments.service;

import com.navneesh.assignments.dao.UserMessageDAO;
import com.navneesh.assignments.dao.UserMessageDaoImp;
import com.navneesh.assignments.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMessageServiceImpl implements UserMessageService{
    @Autowired
    UserMessageDAO dao;
    @Override
    public List<Message> getMessages(String username, int startIndex, int limit) {
        return dao.getMessages(username, startIndex, limit);
    }

    @Override
    public void removeUser(String username) {

        dao.removeUser(username);
    }

    @Override
    public void deleteMessage(String username, String msgid) {
        dao.deleteMessage(username, msgid);
    }

    @Override
    public void addMessage(String username, Message message) {
        dao.addMessage(username, message);
    }
}
