package es.udc.psi.citizen.entity;

public class Game implements Updatable{

    Map map;
    UserPlayer player;

    public Game() {
        map = new Map(5);
        player = new UserPlayer();
    }

    @Override
    public void update() {
        map.update();
        player.update();
    }
}
