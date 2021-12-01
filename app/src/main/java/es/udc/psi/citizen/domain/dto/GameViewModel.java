package es.udc.psi.citizen.domain.dto;

import java.time.LocalDateTime;

import es.udc.psi.citizen.domain.Game;

public class GameViewModel {
    private String playerName;
    private LocalDateTime lastUpdate;

    public GameViewModel(String playerName, LocalDateTime lastUpdate) {
        this.playerName = playerName;
        this.lastUpdate = lastUpdate;
    }

    public GameViewModel(Game game) {
        this.playerName = game.getPlayer().getName();
        this.lastUpdate = game.getLastUpdate();
    }

    public String getPlayerName() {
        return playerName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
