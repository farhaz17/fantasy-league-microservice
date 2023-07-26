package com.fantasyleague.playerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerRequest {
    private Long id;
    private String name;
    private Long teamId;
    private String photo;
    private String position;
    private Integer age;
    private Integer matchesPlayed;
    private Integer goals;
    private Integer assists;
    private Integer cleanSheet;
    private Integer fantasyPoints;
    private Double fantasyPrice;
}
