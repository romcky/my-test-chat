package my.test.chat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatUserDTO {
    private Long id;
    private String username;
    private LocalDateTime created_at;
}
