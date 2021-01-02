package com.taskagile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;
    @Column(nullable = false, length = 128)
    private String name;

    private LocalDate createdDate;

    @OneToMany(mappedBy = "team")
    private List<MemberTeam> memberTeam = new ArrayList<>();

    public static Team createTeam(String name, List<MemberTeam> memberTeam) {
        Team team = new Team();
        team.name = name;
        team.createdDate = LocalDate.now();
        team.memberTeam = memberTeam;
        return team;
    }
}
