package com.fantasyleague.teamservice.service;

import com.fantasyleague.teamservice.dto.TeamRequest;
import com.fantasyleague.teamservice.dto.TeamResponse;
import com.fantasyleague.teamservice.model.Team;
import com.fantasyleague.teamservice.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public TeamResponse store(TeamRequest teamRequest) {
        // Create a new Team entity and set its properties from the TeamRequest
        Team team = new Team();
        team.setName(teamRequest.getName());
        team.setShortName(teamRequest.getShortName());
        teamRepository.save(team);

        return convertToResponse(team);
    }

    public List<TeamResponse> getAllTeams() {
        List<Team> teamList = teamRepository.findAll();
        return teamList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public TeamResponse getTeamById(Long id) {
        Optional<Team> teamOptional = teamRepository.findById(id);
        return teamOptional.map(this::convertToResponse).orElse(null);
    }

    private TeamResponse convertToResponse(Team team) {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setId(team.getId());
        teamResponse.setName(team.getName());
        teamResponse.setShortName(team.getShortName());
        teamResponse.setLogo(team.getLogo());
        teamResponse.setMatchesPlayed(team.getMatchesPlayed());
        teamResponse.setWin(team.getWin());
        teamResponse.setLoss(team.getLoss());
        teamResponse.setDraw(team.getDraw());
        teamResponse.setGoalsScored(team.getGoalsScored());
        teamResponse.setGoalsConceded(team.getGoalsConceded());
        teamResponse.setPoints(team.getPoints());
        teamResponse.setPosition(team.getPosition());
        teamResponse.setTeamGroup(team.getTeamGroup());
        teamResponse.setCreatedAt(team.getCreatedAt());
        teamResponse.setUpdatedAt(team.getUpdatedAt());

        return teamResponse;
    }
}
