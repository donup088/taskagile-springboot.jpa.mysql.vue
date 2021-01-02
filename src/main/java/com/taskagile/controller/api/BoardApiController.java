package com.taskagile.controller.api;

import com.taskagile.annotation.CurrentUser;
import com.taskagile.apiutils.ApiResult;
import com.taskagile.apiutils.CreateBoardResult;
import com.taskagile.domain.Board;
import com.taskagile.dto.BoardDto;
import com.taskagile.security.domain.CustomUser;
import com.taskagile.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public ResponseEntity<ApiResult> createBoard(@RequestBody BoardDto boardDto, @CurrentUser CustomUser customUser) {
        log.info("boardDto: " + boardDto);
        log.info("login User: " + customUser.getUsername());
        Board board = boardService.createBoard(boardDto, customUser);
        log.info("api: " + CreateBoardResult.build(board));
        return CreateBoardResult.build(board);
    }
}
