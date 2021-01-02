package com.taskagile.apiutils;

import com.taskagile.domain.Board;
import com.taskagile.domain.Team;
import com.taskagile.security.domain.CustomUser;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyDataResult {
    public static ResponseEntity<ApiResult> build(CustomUser currentUser, List<Team> teams, List<Board> boards) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", currentUser.getUsername());
        List<TeamResult> teamResults = new ArrayList<>();

        if (teams.size() > 0) {
            for (Team team : teams) {
                teamResults.add(new TeamResult(team));
            }
        }

        List<BoardResult> boardResults = new ArrayList<>();
        for (Board board : boards) {
            boardResults.add(new BoardResult(board));
        }

        ApiResult apiResult = ApiResult.blank()
                .add("user", user)
                .add("teams", teamResults)
                .add("boards", boardResults);

        return Result.ok(apiResult);
    }

    @Getter
    private static class TeamResult {
        private long id;
        private String name;

        TeamResult(Team team) {
            this.id = team.getId();
            this.name = team.getName();
        }
    }

    @Getter
    private static class BoardResult {
        private long id;
        private String name;
        private String description;
        private long teamId;

        BoardResult(Board board) {
            this.id = board.getId();
            this.name = board.getName();
            this.description = board.getDescription();
            if (board.getTeam() != null) {
                this.teamId = board.getTeam().getId();
            }
        }
    }
}
