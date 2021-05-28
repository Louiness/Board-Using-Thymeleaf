package com.kks.example.user.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "USER_INFO")
public class UserEntity {

    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "user_name", length = 15, nullable = false)
    private String userName;

    @Builder
    public UserEntity(String id, String password, String email, LocalDate birthDate, String userName) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.userName = userName;
    }
}
