package com.kks.example.user.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "USER_INFO")
public class UserEntity {

    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate birthdate;

    @Column(length = 12, nullable = false)
    private String nickname;

    @Builder
    public UserEntity(String id, String password, String email, LocalDate birthdate, String nickname) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.birthdate = birthdate;
        this.nickname = nickname;
    }
}
