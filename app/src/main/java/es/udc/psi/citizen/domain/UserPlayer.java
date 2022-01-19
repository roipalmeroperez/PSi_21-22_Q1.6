package es.udc.psi.citizen.domain;

public class UserPlayer implements Updatable{

    private String name;
    private int gold;
    private Goods store;

    public UserPlayer(String name, int gold) {
        this.name = name;
        this.gold = gold;
        this.store = new Goods();
        store.grain = 100;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public Goods getStore() {
        return store;
    }

    @Override
    public void update() {

    }
}
