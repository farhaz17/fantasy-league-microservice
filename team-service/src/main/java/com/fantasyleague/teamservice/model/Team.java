package com.fantasyleague.teamservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "logo")
    private String logo;

    @Column(name = "matches_played", columnDefinition = "INT default 0")
    private int matchesPlayed;

    @Column(name = "win", columnDefinition = "INT default 0")
    private int win;

    @Column(name = "loss", columnDefinition = "INT default 0")
    private int loss;

    @Column(name = "draw", columnDefinition = "INT default 0")
    private int draw;

    @Column(name = "goals_scored", columnDefinition = "INT default 0")
    private int goalsScored;

    @Column(name = "goals_conceded", columnDefinition = "INT default 0")
    private int goalsConceded;

    @Column(name = "points", columnDefinition = "INT default 0")
    private int points;

    @Column(name = "position", columnDefinition = "INT default 0")
    private int position;

    @Column(name = "team_group")
    private String teamGroup;
}

