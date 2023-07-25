package com.fantasyleague.teamservice.service;

import com.fantasyleague.teamservice.dto.TeamRequest;
import com.fantasyleague.teamservice.model.Team;
import com.fantasyleague.teamservice.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public Team store(TeamRequest teamRequest) {
        // Create a new Team entity and set its properties from the TeamRequest
        Team team = new Team();
        team.setName(teamRequest.getName());
        team.setShortName(teamRequest.getShortName());

        // Save the Team entity to the database
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
