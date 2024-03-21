package com.websocial.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
public class UserRelationShip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user2;
    private String status;
}
