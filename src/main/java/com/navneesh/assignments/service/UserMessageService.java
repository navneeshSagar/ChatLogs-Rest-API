package com.navneesh.assignments.service;

import com.navneesh.assignments.model.Message;
import java.util.List;

public interface UserMessageService {

    List<Message> getMessages(String username, int startIndex, int limit);

    void removeUser(String username);

    void deleteMessage(String username, String msgid);

    void addMessage(String username, Message message);
}
