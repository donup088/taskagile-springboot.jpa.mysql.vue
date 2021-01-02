package com.taskagile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false, length = 128, unique = true)
    private String name;

    @Column(nullable = false, length = 256, unique = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private LocalDate createdDate;

    public static Board create(Member member, String name, String description, Team team) {
        Board board = new Board();
        board.member = member;
        board.team = team;
        board.name = name;
        board.description = description;
        board.createdDate = LocalDate.now();
        return board;
    }
}
