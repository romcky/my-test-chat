package my.test.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import my.test.chat.entity.ChatUser;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ChatUserDTO {
    private Long user;
    private String username;
    private LocalDateTime created_at;

    public ChatUserDTO(ChatUser user) {
        this.user = user.getId();
        this.username = user.getName();
        this.created_at = user.getCreated();
    }
}
