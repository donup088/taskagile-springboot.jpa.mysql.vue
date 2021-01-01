package com.taskagile.dto;

import com.sun.istack.NotNull;
import com.taskagile.domain.Member;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberDto {
    @NotNull
    private String username;

    @NotNull
    private String emailAddress;

    @NotNull
    private String password;

    public Member toEntity(String username,String emailAddress, String password){
        return Member.builder()
                .username(username)
                .password(password)
                .email(emailAddress)
                .createdDate(LocalDate.now())
                .build();
    }
}
