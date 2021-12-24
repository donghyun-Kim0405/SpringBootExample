package com.example.SpringSecurityExample.domain.dto;


import com.example.SpringSecurityExample.domain.Role;
import com.example.SpringSecurityExample.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinDto {

    @Size(min = 3, max = 50)
    private String username;

    @Size(min = 3, max = 50)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 50)
    private String nickname;

    private String role;

    public User toUserEntity(){

        return User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(Role.USER)
                .activated(true)
                .build();
    }

}
