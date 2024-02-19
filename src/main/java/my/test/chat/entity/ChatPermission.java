package my.test.chat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CHAT_PERMISSION")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatPermission {
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
}