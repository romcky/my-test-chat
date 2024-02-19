package my.test.chat.dto;

import lombok.Data;
import my.test.chat.entity.ChatMessage;

@Data
public class MessagesAddResponse {
    private String id;

    public MessagesAddResponse(ChatMessage message) {
        this.id = message.getId().toString();
    }
}
