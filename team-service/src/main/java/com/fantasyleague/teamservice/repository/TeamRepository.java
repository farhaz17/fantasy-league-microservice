package com.fantasyleague.teamservice.repository;

import com.fantasyleague.teamservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
