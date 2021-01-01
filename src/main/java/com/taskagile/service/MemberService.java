package com.taskagile.service;

import com.taskagile.domain.Member;
import com.taskagile.exception.EmailAddressExistsException;
import com.taskagile.exception.UsernameExistsException;
import com.taskagile.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member register(Member member) {
        Member findMember = memberRepository.findByUsername(member.getUsername()).orElse(null);
        if (findMember != null) {
            throw new UsernameExistsException();
        }
        findMember = memberRepository.findByEmail(member.getEmail()).orElse(null);

        if (findMember != null) {
            throw new EmailAddressExistsException();
        }

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.save(member);

        return member;
    }
}
