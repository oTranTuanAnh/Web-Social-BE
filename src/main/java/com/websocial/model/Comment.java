package com.websocial.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Data
public class Comment{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Date createDate;
    private String content;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
