package com.amaanil.chat.controller;

import com.amaanil.chat.model.MessageModel;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate; //for dynamic topics


    @MessageMapping("/message")
    @SendTo ("chatroom/public")
    public MessageModel receivePublicMessage(@Payload MessageModel message)
    {return message;
    }
    @MessageMapping ("/private-message")
    public MessageModel receivePrivateMessage (@Payload MessageModel message) {
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message;

    }
}
