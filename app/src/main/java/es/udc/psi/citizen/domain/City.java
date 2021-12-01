package es.udc.psi.citizen.domain;

public class City implements Updatable {
    String name;
    int population;

    public City (String name){
        this.name = name;
        this.population = 2000;
    }

    @Override
    public void update() {

    }
}
