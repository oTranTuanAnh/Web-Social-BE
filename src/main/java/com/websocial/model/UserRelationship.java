package com.websocial.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@Table (name = "user_relationship")
public class UserRelationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createDate;
    @ManyToOne
    @JoinColumn(name = "user_id_1", insertable = false, updatable = false)
    private User user1;
    @ManyToOne
    @JoinColumn(name = "user_id_2", insertable = false, updatable = false)
    private User user2;
    private String status;
}
