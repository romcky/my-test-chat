package my.test.chat.dto;

import lombok.Data;
import my.test.chat.entity.ChatRoom;

@Data
public class ChatsAddResponse {
    private String id;

    public ChatsAddResponse(ChatRoom room) {
        this.id = room.getId().toString();
    }
}
