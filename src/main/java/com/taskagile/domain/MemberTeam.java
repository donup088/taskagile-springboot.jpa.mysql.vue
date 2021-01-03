package com.taskagile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_team_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    private void setMember(Member member) {
        this.member = member;
        member.getMemberTeams().add(this);
    }

    private void setTeam(Team team) {
        this.team = team;
        team.getMemberTeam().add(this);
    }

    public static MemberTeam createMemberTeam(Member member, Team team) {
        MemberTeam memberTeam = new MemberTeam();
        memberTeam.setMember(member);
        memberTeam.setTeam(team);
        return memberTeam;
    }
}
