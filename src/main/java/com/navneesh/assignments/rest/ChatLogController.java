package com.navneesh.assignments.rest;

import com.navneesh.assignments.model.Message;
import com.navneesh.assignments.service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chatlogs")
public class ChatLogController {
    @Autowired
    UserMessageService service;


    @GetMapping("/{user}")
    public List<Message> getMessageforUser(@PathVariable String user,
                                           @RequestParam(name="start", required = false) Integer start,
                                           @RequestParam(name="limit", required=false) Integer limit)
    {
        if(start == null ){
            if(limit == null){
                return service.getMessages(user, 0, 10);
            }
            else{
                return service.getMessages(user, 0, limit);
            }
        }
        else{
            if (limit == null){
                return service.getMessages(user, start, 10);
            }
            else{
                return service.getMessages(user, start, limit);
            }
        }
    }

    @PostMapping("/{user}")
    public String addChatLog(@PathVariable String user, @RequestBody Message message){
        service.addMessage(user, message);
        return message.getMsgid();
    }

    @DeleteMapping("/{user}")
    public void deleteUser(@PathVariable String user){

        service.removeUser(user);
    }

    @DeleteMapping("/{user}/{msgid}")
    public void deleteMessage(@PathVariable String user, @PathVariable String msgid){
            service.deleteMessage(user, msgid);
    }
}
