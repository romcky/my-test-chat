package my.test.chat.controller;

import my.test.chat.dto.ChatRoomDTO;
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
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;
    @Autowired
    private ChatUserService chatUserService;

    @PostMapping("chats/add")
    public Map<String, Long> addRoom(@RequestBody ChatRoomDTO roomDTO) {
        var roomName = roomDTO.getName();
        var roomUsers = chatUserService.getUsers(roomDTO.getUsers());
        var room = chatRoomService.addRoom(roomName, roomUsers);
        return Map.of("id", room.getId());
    }

    @GetMapping("chats")
    public List<ChatRoomDTO> fetchRooms() {
        return chatRoomService.getRooms()
                .stream()
                .map(ChatRoomDTO::new)
                .collect(Collectors.toList());
    }
}
