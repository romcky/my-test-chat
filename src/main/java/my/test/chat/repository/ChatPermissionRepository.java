package my.test.chat.repository;

import my.test.chat.entity.ChatPermission;
import my.test.chat.entity.ChatRoom;
import my.test.chat.entity.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.security.Permission;
import java.util.Optional;

@Repository
public interface ChatPermissionRepository extends CrudRepository<ChatPermission, Long> {
}
