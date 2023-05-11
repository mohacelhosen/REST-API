package com.mohacel.education.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_TAB")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID_COL")
    private Integer id;
    @Column(name = "USER_NAME_COL")
    private String name;
    @Column(name = "USER_EMAIL_COL")
    private String email;
    @Column(name = "USER_GENDER_COL")
    private String gender;
    @Column(name = "USER_AGE_COL")
    private Integer age;
}
