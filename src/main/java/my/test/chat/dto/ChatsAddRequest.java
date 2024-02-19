package my.test.chat.dto;

import lombok.Data;

import java.util.List;

@Data
public class ChatsAddRequest {
    private String name;
    private List<Long> users;
}
