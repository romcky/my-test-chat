package my.test.chat.controller;

import my.test.chat.dto.ChatRoomDTO;
import my.test.chat.dto.ChatUserDTO;
import my.test.chat.entity.ChatPermission;
import my.test.chat.service.ChatRoomService;
import my.test.chat.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private ChatUserService chatUserService;

    @PostMapping("chats/add")
    public Map<String, Long> addRoom(@RequestBody ChatRoomDTO roomDTO) {
        var roomName = roomDTO.getChatname();
        var roomUsers = chatUserService.getUsers(roomDTO.getUsers());
        var room = chatRoomService.addRoom(roomName, roomUsers);
        return Map.of("id", room.getId());
    }

    @PostMapping("chats/get")
    public List<ChatRoomDTO> getChatsByUser(@RequestBody ChatUserDTO userDTO) {
        var user = chatUserService.findUserById(userDTO.getUser()).orElseThrow(
                //no such user exception
        );
        return user.getPermissions()
                .stream()
                .map(ChatPermission::getRoom)
                .sorted(Comparator.comparing(chatRoomService::getLastUpdate).reversed())
                .map(ChatRoomDTO::new)
                .collect(Collectors.toList());
    }
}
