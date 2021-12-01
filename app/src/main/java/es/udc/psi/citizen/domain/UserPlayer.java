package es.udc.psi.citizen.domain;

public class UserPlayer implements Updatable{

    private String name;
    private int gold;

    public UserPlayer(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    @Override
    public void update() {

    }
}
