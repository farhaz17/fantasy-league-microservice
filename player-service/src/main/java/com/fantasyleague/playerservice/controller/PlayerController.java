package com.fantasyleague.playerservice.controller;

import com.fantasyleague.playerservice.dto.PlayerRequest;
import com.fantasyleague.playerservice.model.Player;
import com.fantasyleague.playerservice.service.PlayerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping
    @CircuitBreaker(name="player", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name="player")
    @Retry(name = "player")
    public ResponseEntity<Player> createPlayer(@RequestBody PlayerRequest playerRequest) {
        Player playerResponse = playerService.createPlayer(playerRequest);
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> player = playerService.getAllPlayers();
        if (!player.isEmpty()) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public CompletableFuture<String> fallbackMethod(RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(()-> "Oops! Something went wrong, please try again later!");
    }
}
