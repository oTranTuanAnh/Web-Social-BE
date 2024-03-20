package com.websocial.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class ImagePost {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private Date createDate;
    private String linkImage;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
