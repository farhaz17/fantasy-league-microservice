package com.fantasyleague.playerservice.repository;

import com.fantasyleague.playerservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
