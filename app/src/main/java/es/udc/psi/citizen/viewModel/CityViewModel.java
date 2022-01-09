package es.udc.psi.citizen.viewModel;

import es.udc.psi.citizen.domain.City;

public class CityViewModel {
    private String name;
    private int population;

    public CityViewModel(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public CityViewModel(City city) {
        this.name = city.getName();
        this.population = city.getPopulation();
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }
}
