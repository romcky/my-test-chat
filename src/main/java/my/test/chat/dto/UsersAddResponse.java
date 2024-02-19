package my.test.chat.dto;

import lombok.Data;
import my.test.chat.entity.ChatUser;

@Data
public class UsersAddResponse {
    private String id;

    public UsersAddResponse(ChatUser user) {
        this.id = user.getId().toString();
    }
}
