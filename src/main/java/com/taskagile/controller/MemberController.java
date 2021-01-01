package com.taskagile.controller;

import com.taskagile.apiutils.ApiResult;
import com.taskagile.apiutils.Result;
import com.taskagile.dto.MemberDto;
import com.taskagile.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/register")
    public ResponseEntity<ApiResult> register(@Valid @RequestBody MemberDto memberDto) {
        log.info("memberDto: " + memberDto);
        memberService.register(memberDto.toEntity(memberDto.getUsername(), memberDto.getEmailAddress(), memberDto.getPassword()));

        return Result.created();
    }
}
