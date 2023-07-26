package com.fantasyleague.teamservice.controller;

import com.fantasyleague.teamservice.dto.TeamRequest;
import com.fantasyleague.teamservice.dto.TeamResponse;
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
    public ResponseEntity<TeamResponse> createTeam(@RequestBody TeamRequest teamRequest) {
        TeamResponse savedTeam = teamService.store(teamRequest);
        return new ResponseEntity<>(savedTeam, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams() {
        List<TeamResponse> teams = teamService.getAllTeams();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getSingleTeam(@PathVariable Long id) {
        TeamResponse team = teamService.getTeamById(id);
        if (team != null) {
            return ResponseEntity.ok(team);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
