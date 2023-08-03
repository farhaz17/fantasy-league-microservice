package com.fantasyleague.playerservice.service;

import com.fantasyleague.playerservice.dto.PlayerRequest;
import com.fantasyleague.playerservice.dto.TeamResponse;
import com.fantasyleague.playerservice.event.PlayerCreatedEvent;
import com.fantasyleague.playerservice.model.Player;
import com.fantasyleague.playerservice.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final WebClient.Builder webClientBuilder;

    private final KafkaTemplate<String, PlayerCreatedEvent> kafkaTemplate;

    @Transactional
    public Player createPlayer(PlayerRequest playerRequest) {

        Player player = new Player();
        player.setName(playerRequest.getName());
        player.setPosition(playerRequest.getPosition());
        player.setTeamId(playerRequest.getTeamId());

        TeamResponse teamExists = webClientBuilder.build().get()
                .uri("http://team-service:8087/api/teams/{id}", player.getTeamId())
                .retrieve()
                .bodyToMono(TeamResponse.class)
                .onErrorResume(WebClientResponseException.NotFound.class, ex -> Mono.empty()) // Handle 404 Not Found
                .block();

        if (teamExists != null) {
            Player playerCreated = playerRepository.save(player);
            kafkaTemplate.send("notificationTopic", new PlayerCreatedEvent(playerCreated.getId(), playerCreated.getTeamId(), playerCreated.getName()));
            return playerCreated;
        } else {
            throw new IllegalArgumentException("Team Id " + playerRequest.getTeamId() + " Not Found");
        }

    }

    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        return players;
    }
}
