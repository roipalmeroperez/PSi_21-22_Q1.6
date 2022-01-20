package es.udc.psi.citizen.viewModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    public String toString(String dateFormat) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        return playerName + "\n" + lastUpdate.format(formatter);
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
