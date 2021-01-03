package com.taskagile.controller.api;

import com.taskagile.annotation.CurrentUser;
import com.taskagile.apiutils.ApiResult;
import com.taskagile.apiutils.CreateTeamResult;
import com.taskagile.domain.Team;
import com.taskagile.dto.TeamDto;
import com.taskagile.security.domain.CustomUser;
import com.taskagile.service.TeamService;
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
public class TeamApiController {

    private final TeamService teamService;

    @PostMapping("/teams")
    public ResponseEntity<ApiResult> create(@RequestBody TeamDto teamDto, @CurrentUser CustomUser customUser) {
        log.info("teamDto: " + teamDto);
        Team team = teamService.createTeam(teamDto, customUser);

        return CreateTeamResult.build(team);
    }
}
