package my.test.chat.controller;

import my.test.chat.dto.MessagesAddRequest;
import my.test.chat.dto.MessagesAddResponse;
import my.test.chat.service.ChatMessageService;
import my.test.chat.service.ChatRoomService;
import my.test.chat.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;
    @Autowired
    private ChatUserService chatUserService;
    @Autowired
    private ChatRoomService chatRoomService;

    @PostMapping("/messages/add")
    public MessagesAddResponse addMessage(@RequestBody MessagesAddRequest requestDTO) {
        var text = requestDTO.getText();
        var user = chatUserService.findUserById(requestDTO.getAuthor()).orElseThrow(
                //no such user
        );
        var room = chatRoomService.findRoomById(requestDTO.getChat()).orElseThrow(
                //no such room
        );
        return new MessagesAddResponse(chatMessageService.addMessage(text, room, user));
    }
}