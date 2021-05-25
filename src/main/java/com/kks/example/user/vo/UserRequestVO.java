package com.kks.example.user.vo;

import com.kks.example.user.entity.UserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class UserRequestVO {

    private String id;

    private String password;

    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    private String userName;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .id(id)
                .password(password)
                .email(email)
                .birthDate(birthDate)
                .userName(userName)
                .build();
    }
}
