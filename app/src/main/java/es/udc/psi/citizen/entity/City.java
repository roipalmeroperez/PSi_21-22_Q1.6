package es.udc.psi.citizen.entity;

public class City implements Updatable {
    String name;

    public City (String name){
        this.name = name;
    }

    @Override
    public void update() {

    }
}
