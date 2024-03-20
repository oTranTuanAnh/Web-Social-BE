package com.websocial.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;

@Entity
@Data
public class ImagePost {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createDate;
    private String linkImage;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
