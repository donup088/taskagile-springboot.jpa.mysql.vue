package com.taskagile.service;

import com.taskagile.domain.Board;
import com.taskagile.domain.Member;
import com.taskagile.domain.Team;
import com.taskagile.dto.BoardDto;
import com.taskagile.repository.BoardRepository;
import com.taskagile.repository.MemberRepository;
import com.taskagile.security.domain.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    public Board createBoard(BoardDto boardDto, CustomUser customUser) {
        Member member = memberRepository.findByUsername(customUser.getUsername()).get();

        if (boardDto.getTeamId() == 0) {
            Board board = Board.create(member, boardDto.getName(), boardDto.getDescription(), null);
            return boardRepository.save(board);
        }

        return null;
    }
}
