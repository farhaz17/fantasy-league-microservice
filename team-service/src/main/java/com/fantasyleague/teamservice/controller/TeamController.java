package com.fantasyleague.teamservice.controller;

import com.fantasyleague.teamservice.dto.TeamRequest;
import com.fantasyleague.teamservice.model.Team;
import com.fantasyleague.teamservice.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody TeamRequest teamRequest) {
        Team savedTeam = teamService.store(teamRequest);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }
}
