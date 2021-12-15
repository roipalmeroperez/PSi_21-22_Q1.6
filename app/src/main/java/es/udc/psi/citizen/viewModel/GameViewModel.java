package es.udc.psi.citizen.viewModel;

import java.time.LocalDateTime;

import es.udc.psi.citizen.domain.Game;

public class GameViewModel {
    private String playerName;
    private int citiesNumber;
    private LocalDateTime lastUpdate;

    public GameViewModel(Game game) {
        this.playerName = game.getPlayer().getName();
        this.lastUpdate = game.getLastUpdate();
        this.citiesNumber = game.getMap().getCities().size();
    }

    public String getPlayerName() {
        return playerName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public int getCitiesNumber() {
        return citiesNumber;
    }
}
