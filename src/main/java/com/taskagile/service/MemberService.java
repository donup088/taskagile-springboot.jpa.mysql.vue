package com.taskagile.service;

import com.taskagile.domain.Member;
import com.taskagile.exception.EmailAddressExistsException;
import com.taskagile.exception.UsernameExistsException;
import com.taskagile.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member register(Member member) {
        Member findMember = memberRepository.findByUsername(member.getUsername());
        if (findMember != null) {
            throw new UsernameExistsException();
        }
        findMember = memberRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new EmailAddressExistsException();
        }
        //TODO 비밀번호 암호화
        memberRepository.save(member);
        return member;
    }
}
