package com.taskagile.service;

import com.taskagile.domain.Member;
import com.taskagile.domain.MemberTeam;
import com.taskagile.domain.Team;
import com.taskagile.dto.TeamDto;
import com.taskagile.repository.MemberRepository;
import com.taskagile.repository.MemberTeamRepository;
import com.taskagile.repository.team.TeamRepository;
import com.taskagile.security.domain.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;
    private final MemberTeamRepository memberTeamRepository;

    public Team createTeam(TeamDto teamDto, CustomUser customUser) {
        Member member = memberRepository.findByUsername(customUser.getUsername()).get();

        Team team = Team.createTeam(teamDto.getName());
        Team savedTeam = teamRepository.save(team);

        MemberTeam memberTeam = MemberTeam.createMemberTeam(member, savedTeam);
        memberTeamRepository.save(memberTeam);

        return savedTeam;
    }
}
