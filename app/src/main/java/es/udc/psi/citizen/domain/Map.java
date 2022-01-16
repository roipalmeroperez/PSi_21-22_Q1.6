package es.udc.psi.citizen.domain;

import java.util.ArrayList;

public class Map implements Updatable{
    ArrayList<City> cities;

    public Map (int nCities) {
        cities = new ArrayList<>(nCities);
        for (int i = 0; i < nCities; i++)
            cities.add(new City("City " + i));
    }

    public Map (int nCities, String citiesNames) {
        String[] citiesNamesList = citiesNames.split(";");
        cities = new ArrayList<>(nCities);
        for (int i = 0; (i < citiesNamesList.length)&&(i < nCities); i++)
            cities.add(new City(citiesNamesList[i]));
        for (int i = citiesNamesList.length; i < nCities; i++)
            cities.add(new City("City " + i));

    }

    public ArrayList<City> getCities() {
        return cities;
    }

    @Override
    public void update() {
        for (int i = 0; i < cities.size(); i++)
            cities.get(i).update();
    }
}
