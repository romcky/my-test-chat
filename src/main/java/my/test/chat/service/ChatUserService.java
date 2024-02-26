package my.test.chat.service;

import lombok.NonNull;
import my.test.chat.entity.ChatUser;
import my.test.chat.exception.ChatException;
import my.test.chat.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatUserService {
    @Autowired
    private ChatUserRepository chatUserRepository;

    public ChatUser addUser(@NonNull String userName) {
        var user = ChatUser.builder().name(userName).build();
        try {
            return chatUserRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new ChatException("No unique username, such username already exists");
        }
    }

    public List<ChatUser> getUsers() {
        return (List<ChatUser>) chatUserRepository.findAll();
    }

    public List<ChatUser> getUsers(Iterable<Long> ids) {
        return (List<ChatUser>) chatUserRepository.findAllById(ids);
    }

    public Optional<ChatUser> findUserById(Long id) {
        return chatUserRepository.findById(id);
    }
}