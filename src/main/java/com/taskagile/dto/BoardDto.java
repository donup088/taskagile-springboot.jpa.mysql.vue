package com.taskagile.dto;

import lombok.Data;

@Data
public class BoardDto {
    private String name;

    private String description;

    private Long teamId;
}
