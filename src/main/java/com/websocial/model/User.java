package com.websocial.model;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class User{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDate createDate;
    private String email;
    private String password;
    private String  firstName;
    private String lastName;
    private String phoneNumber;
    private Date dateOfBirth;
    private String gender;
}
