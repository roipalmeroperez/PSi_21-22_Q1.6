package es.udc.psi.citizen.entity;

import java.util.ArrayList;

public class Map implements Updatable{
    ArrayList<City> cities;

    public Map (int nCities) {
        cities = new ArrayList<>(nCities);
        for (int i = 0; i < nCities; i++)
            cities.add(new City("City " + i));
    }

    @Override
    public void update() {
        for (int i = 0; i < cities.size(); i++)
            cities.get(i).update();
    }
}
