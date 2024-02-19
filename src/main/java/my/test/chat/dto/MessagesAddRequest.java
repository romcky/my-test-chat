package my.test.chat.dto;

import lombok.Data;

@Data
public class MessagesAddRequest {
    private Long chat;
    private Long author;
    private String text;
}
