package es.udc.psi.citizen.domain;

public class City implements Updatable {
    private String name;
    private int population;
    private Commodity store;

    public City (String name){
        this.name = name;
        this.population = 2000;
        this.store = new Commodity();
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public void update() {

    }
}
