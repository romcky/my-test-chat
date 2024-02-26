package my.test.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import my.test.chat.entity.ChatPermission;
import my.test.chat.entity.ChatRoom;
import my.test.chat.entity.ChatUser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class ChatRoomDTO {
    private Long chat;
    private String name;
    private LocalDateTime created_at;
    private List<Long> users;

    public ChatRoomDTO(ChatRoom room) {
        this.chat = room.getId();
        this.name = room.getName();
        this.created_at = room.getCreated();
        this.users = room.getPermissions()
                .stream()
                .map(ChatPermission::getUser)
                .map(ChatUser::getId)
                .collect(Collectors.toList());
    }
}
