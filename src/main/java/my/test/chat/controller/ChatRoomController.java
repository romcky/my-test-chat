package my.test.chat.controller;

import my.test.chat.dto.ChatsAddResponse;
import my.test.chat.dto.ChatsAddRequest;
import my.test.chat.service.ChatRoomService;
import my.test.chat.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private ChatUserService chatUserService;

    @PostMapping("chats/add")
    public ChatsAddResponse addRoom(@RequestBody ChatsAddRequest requestDTO) {
        var roomName = requestDTO.getName();
        var roomUsers = chatUserService.getUsers(requestDTO.getUsers());
        var room = chatRoomService.addRoom(roomName, roomUsers);
        return new ChatsAddResponse(room);
    }
}
