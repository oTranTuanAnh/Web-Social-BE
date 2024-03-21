package com.websocial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


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
//    @OneToMany
//    private List<UserRelationShip> userRelationShips;
}
