package com.taskagile.apiutils;

import com.taskagile.domain.Board;
import org.springframework.http.ResponseEntity;

public class CreateBoardResult {
    public static ResponseEntity<ApiResult> build(Board board) {
        ApiResult apiResult = ApiResult.blank()
                .add("id", board.getId())
                .add("name", board.getName())
                .add("description", board.getDescription());
        if (board.getTeam() == null) {
            apiResult.add("teamId", 0);
        }

        return Result.ok(apiResult);
    }
}
