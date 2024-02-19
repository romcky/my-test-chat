package my.test.chat.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatRoomDTO {
    private Long id;
    private String name;
    private LocalDateTime created_at;
    private List<Long> users;
}
