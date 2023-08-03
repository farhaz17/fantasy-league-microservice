package com.fantasyleague.playerservice.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerCreatedEvent {
    private Long playerId;
    private Long teamId;
    private String playerName;
}

