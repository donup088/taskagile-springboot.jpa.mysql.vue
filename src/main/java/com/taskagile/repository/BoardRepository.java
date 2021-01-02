package com.taskagile.repository;

import com.taskagile.domain.Board;
import com.taskagile.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByMember(Member member);
}
