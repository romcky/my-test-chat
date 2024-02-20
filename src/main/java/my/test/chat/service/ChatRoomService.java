package my.test.chat.service;

import lombok.NonNull;
import my.test.chat.entity.ChatMessage;
import my.test.chat.entity.ChatPermission;
import my.test.chat.entity.ChatRoom;
import my.test.chat.entity.ChatUser;
import my.test.chat.repository.ChatPermissionRepository;
import my.test.chat.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;
    @Autowired
    private ChatPermissionRepository chatPermissionRepository;

    public ChatRoom addRoom(@NonNull String roomName, @NonNull List<ChatUser> users) {
        var room = chatRoomRepository.save(ChatRoom.builder().name(roomName).build());
        users.stream()
                .map(user -> ChatPermission.builder().room(room).user(user).build())
                .forEach(chatPermissionRepository::save);
        return room;
    }

    public List<ChatRoom> getRooms() {
        return (List<ChatRoom>) chatRoomRepository.findAll();
    }

    public Optional<ChatRoom> findRoomById(Long id) {
        return chatRoomRepository.findById(id);
    }

    public LocalDateTime getLastUpdate(ChatRoom room) {
        return room.getMessages()
                .stream()
                .map(ChatMessage::getCreated)
                .max(Comparator.naturalOrder()).orElse(room.getCreated());
    }
}