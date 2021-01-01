package com.taskagile.security;

import com.taskagile.domain.Member;
import com.taskagile.repository.MemberRepository;
import com.taskagile.security.domain.CustomUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("loadUserByUsername");
        Member member = memberRepository.findByUsername(userName)
                .orElseThrow(() -> new NullPointerException("member를 찾지 못했습니다."));

        return new CustomUser(member);
    }
}