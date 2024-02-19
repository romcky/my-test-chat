package my.test.chat.controller;

import my.test.chat.dto.UsersAddResponse;
import my.test.chat.dto.UsersAddRequest;
import my.test.chat.service.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatUserController {
    @Autowired
    private ChatUserService chatUserService;

    @PostMapping("/users/add")
    public UsersAddResponse addUser(@RequestBody UsersAddRequest requestDTO) {
        var user = chatUserService.addUser(requestDTO.getUsername());
        return new UsersAddResponse(user);
    }
}