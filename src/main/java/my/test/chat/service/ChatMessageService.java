package my.test.chat.service;

import my.test.chat.entity.ChatMessage;
import my.test.chat.entity.ChatPermission;
import my.test.chat.entity.ChatRoom;
import my.test.chat.entity.ChatUser;
import my.test.chat.repository.ChatMessageRepository;
import my.test.chat.repository.ChatPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;
    @Autowired
    private ChatPermissionRepository chatPermissionRepository;

    public ChatMessage addMessage(String text, ChatRoom room, ChatUser user) {
        if (room.getPermissions().stream().allMatch(p -> p.getUser().getId() != user.getId())) {
            //no permission for user to this room
            throw new RuntimeException();
        }
        var message = ChatMessage.builder().room(room).user(user).text(text).build();
        return chatMessageRepository.save(message);
    }
    
    public List<ChatMessage> getMessages() {
        return (List<ChatMessage>) chatMessageRepository.findAll();
    }
}
