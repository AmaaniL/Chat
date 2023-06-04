package com.amaanil.chat.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MessageModel {
    private String senderName;
    private String receiverName;
    private String messageContent;
    private String date;
    private Status status;

}
