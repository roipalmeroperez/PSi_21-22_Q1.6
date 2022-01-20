package es.udc.psi.citizen.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static es.udc.psi.citizen.domain.ModelConst.MONEY_AT_START;

public class Game implements Updatable{

    private Map map;
    private UserPlayer player;
    private LocalDateTime lastUpdate;

    public Game() {
        map = new Map(5);
        player = new UserPlayer("Name", MONEY_AT_START);
        lastUpdate = LocalDateTime.now();
    }

    public Game(int nCities, String userName) {
        map = new Map(nCities);
        player = new UserPlayer(userName, MONEY_AT_START);
        lastUpdate = LocalDateTime.now();
    }

    public Game(int nCities, String citiesNames, String userName) {
        map = new Map(nCities, citiesNames);
        player = new UserPlayer(userName, MONEY_AT_START);
        lastUpdate = LocalDateTime.now();
    }

    @Override
    public void update() {
        lastUpdate = LocalDateTime.now();
        map.update();
        player.update();
    }

    public Map getMap() {
        return map;
    }

    public UserPlayer getPlayer() {
        return player;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }
}
