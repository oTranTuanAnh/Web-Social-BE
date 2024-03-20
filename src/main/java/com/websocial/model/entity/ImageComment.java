package com.websocial.model.entity;

import com.websocial.model.entity.Comment;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
public class ImageComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createDate;
    private String linkImage;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}
