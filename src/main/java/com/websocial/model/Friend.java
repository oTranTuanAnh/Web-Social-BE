package com.websocial.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Friend{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Date createDate;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
}
