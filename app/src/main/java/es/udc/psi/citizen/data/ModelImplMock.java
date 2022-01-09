package es.udc.psi.citizen.data;

import java.util.ArrayList;
import java.util.List;

import static es.udc.psi.citizen.domain.ModelConst.MAX_GAMES;

import es.udc.psi.citizen.domain.City;
import es.udc.psi.citizen.domain.Game;
import es.udc.psi.citizen.domain.Model;
import es.udc.psi.citizen.viewModel.CityViewModel;
import es.udc.psi.citizen.viewModel.GameViewModel;

public class ModelImplMock implements Model {
    ArrayList<Game> games;

    public ModelImplMock() {
        games = new ArrayList<>(MAX_GAMES);
        games.add(new Game(10, "Pepe"));
        games.add(new Game(5, "Manolo"));
        games.add(new Game(20, "Jaimito"));
    }

    @Override
    public List<GameViewModel> getGameViewModels() {
        ArrayList<GameViewModel> list = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            list.add(new GameViewModel(games.get(i)));
        }
        return list;
    }

    @Override
    public List<CityViewModel> getCityViewModels(int gameId) {
        ArrayList<CityViewModel> list = new ArrayList<>();
        List<City> cities = games.get(gameId).getMap().getCities();
        for (int i = 0; i < cities.size(); i++) {
            list.add(new CityViewModel(cities.get(i)));
        }
        return list;
    }

}
