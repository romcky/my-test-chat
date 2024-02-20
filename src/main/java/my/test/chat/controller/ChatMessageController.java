package my.test.chat.controller;

import my.test.chat.dto.ChatMessageDTO;
import my.test.chat.service.ChatMessageService;
import my.test.chat.service.ChatRoomService;
import my.test.chat.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;
    @Autowired
    private ChatUserService chatUserService;
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/messages/add")
    public Map<String, Long> addMessage(@RequestBody ChatMessageDTO messageDTO) {
        var text = messageDTO.getText();
        var user = chatUserService.findUserById(messageDTO.getAuthor()).orElseThrow(
                //no such user
        );
        var room = chatRoomService.findRoomById(messageDTO.getChat()).orElseThrow(
                //no such room
        );
        var message = chatMessageService.addMessage(text, room, user);
        return Map.of("id", message.getId());
    }

    @GetMapping("/messages")
    public List<ChatMessageDTO> fetchMessages() {
        return chatMessageService.getMessages()
                .stream()
                .map(ChatMessageDTO::new)
                .collect(Collectors.toList());
    }
}