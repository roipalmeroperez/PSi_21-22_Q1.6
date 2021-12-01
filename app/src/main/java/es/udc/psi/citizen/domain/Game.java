package es.udc.psi.citizen.domain;

import java.time.LocalDateTime;

public class Game implements Updatable{

    private Map map;
    private UserPlayer player;
    private LocalDateTime lastUpdate;

    public Game() {
        map = new Map(5);
        player = new UserPlayer("Name", 30000);
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
