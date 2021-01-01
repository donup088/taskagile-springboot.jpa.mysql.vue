package com.taskagile.security.domain;

import com.taskagile.domain.Member;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

@Getter
public class CustomUser extends User {

    private static final long serialVersionUID = 1L;

    private Member member;

    public CustomUser(Member member) {
        super(member.getUsername(), member.getPassword(), Collections.singleton(new SimpleGrantedAuthority(member.getRole().toString())));

        this.member = member;
    }
}
