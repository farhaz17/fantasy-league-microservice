package com.fantasyleague.playerservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "players")
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "team_id", nullable = false)
    private Long teamId;

    @Column(name = "photo")
    private String photo;

    @Column(name = "position")
    private String position;

    @Column(name = "age")
    private int age;

    @Column(name = "matches_played")
    private int matchesPlayed;

    @Column(name = "goals")
    private int goals;

    @Column(name = "assists")
    private int assists;

    @Column(name = "clean_sheet")
    private int cleanSheet;

    @Column(name = "fantasy_points")
    private int fantasyPoints;

    @Column(name = "fantasy_price")
    private double fantasyPrice;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
