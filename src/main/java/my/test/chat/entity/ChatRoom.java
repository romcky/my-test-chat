package my.test.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "CHAT_ROOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME", unique = true)
    private String name;
    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime created;
    @OneToMany(mappedBy = "room")
    private List<ChatPermission> permissions;
    @OneToMany(mappedBy = "room")
    private List<ChatMessage> messages;
}

