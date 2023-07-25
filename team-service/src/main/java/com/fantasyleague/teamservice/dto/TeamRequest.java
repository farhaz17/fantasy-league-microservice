package com.fantasyleague.teamservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TeamRequest {
    private Long id;
    private String name;
    private String shortName;
    private String logo;
    private int matchesPlayed;
    private int win;
    private int loss;
    private int draw;
    private int goalsScored;
    private int goalsConceded;
    private int points;
    private int position;
    private String teamGroup;
}
