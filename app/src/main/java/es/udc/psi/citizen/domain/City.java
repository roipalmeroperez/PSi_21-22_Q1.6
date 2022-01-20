package es.udc.psi.citizen.domain;

public class City implements Updatable {
    private String name;
    private int population;
    private Goods store;

    public City (String name){
        this.name = name;
        this.population = 2000;
        this.store = new Goods();
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public Goods getStore() {
        return store;
    }

    public void setStore(Goods store) {
        this.store = store;
    }

    @Override
    public void update() {

    }
}
