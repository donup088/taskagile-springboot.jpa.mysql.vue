package com.taskagile.controller.api;

import com.taskagile.annotation.CurrentUser;
import com.taskagile.apiutils.ApiResult;
import com.taskagile.apiutils.MyDataResult;
import com.taskagile.domain.Board;
import com.taskagile.domain.Team;
import com.taskagile.security.domain.CustomUser;
import com.taskagile.service.MeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MeApiController {

    private final MeService meService;


    @GetMapping("/me")
    public ResponseEntity<ApiResult> getMyData(@CurrentUser CustomUser customUser) {
        List<Board> boards = meService.getBoard(customUser);
        List<Team> teams = new ArrayList<>();
        return MyDataResult.build(customUser, teams, boards);
    }
}
