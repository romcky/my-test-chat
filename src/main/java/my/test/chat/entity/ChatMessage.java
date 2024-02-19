package my.test.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "CHAT_MESSAGE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private ChatRoom room;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private ChatUser user;
    @Column(name = "TEXT")
    private String text;
    @CreationTimestamp
    @Column(name = "CREATED")
    private LocalDateTime created;
}