package com.taskagile.repository.team;

import com.taskagile.domain.Member;
import com.taskagile.domain.Team;
import com.taskagile.dto.TeamDto;

import java.util.List;

public interface TeamCustomRepository {
    List<Team> getTeamByMember(Member member);
}
