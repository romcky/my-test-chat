package my.test.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import my.test.chat.entity.ChatMessage;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ChatMessageDTO {
    private Long id;
    private Long chat;
    private Long author;
    private String text;
    private LocalDateTime created_at;

    public ChatMessageDTO(ChatMessage message) {
        this.id = message.getId();
        this.chat = message.getRoom().getId();
        this.author = message.getUser().getId();
        this.text = message.getText();
        this.created_at = message.getCreated();
    }

}
