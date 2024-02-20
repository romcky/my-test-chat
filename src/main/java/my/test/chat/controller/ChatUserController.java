package my.test.chat.controller;

import my.test.chat.dto.ChatUserDTO;
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
public class ChatUserController {
    @Autowired
    private ChatUserService chatUserService;

    @PostMapping("/users/add")
    public Map<String, Long> addUser(@RequestBody ChatUserDTO userDTO) {
        var user = chatUserService.addUser(userDTO.getUsername());
        return Map.of("id", user.getId());
    }

    @GetMapping("/users")
    public List<ChatUserDTO> fetchUsers() {
        return chatUserService.getUsers()
                .stream()
                .map(ChatUserDTO::new)
                .collect(Collectors.toList());
    }
}