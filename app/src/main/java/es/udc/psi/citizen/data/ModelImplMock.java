package es.udc.psi.citizen.data;

import java.util.ArrayList;
import java.util.List;

import static es.udc.psi.citizen.domain.ModelConst.MAX_GAMES;

import es.udc.psi.citizen.domain.City;
import es.udc.psi.citizen.domain.Game;
import es.udc.psi.citizen.domain.Goods;
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

    public ModelImplMock(String citiesNames) {
        games = new ArrayList<>(MAX_GAMES);
        games.add(new Game(10, citiesNames, "Pepe"));
        games.add(new Game(5, citiesNames, "Manolo"));
        games.add(new Game(20, citiesNames, "Jaimito"));
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

    @Override
    public int getPlayerMoney(int gameId) {
        return games.get(gameId).getPlayer().getGold();
    }

    @Override
    public City getCity(int gameId, int cityId) {
        return games.get(gameId).getMap().getCities().get(cityId);
    }

    @Override
    public void addGame(String playerName, int citiesNumber, String citiesNames) {
        games.add(new Game(citiesNumber, citiesNames, playerName));
    }

    @Override
    public List<Integer> getCityResumeValues(int gameId, int cityId) {
        ArrayList<Integer> values = new ArrayList<>();
        City city = getCity(gameId, cityId);
        values.add(city.getPopulation());
        values.add(city.getStore().grain);
        values.add(city.getStore().wood);
        values.add(city.getStore().tools);
        values.add(city.getStore().iron);
        return values;
    }

    @Override
    public List<Integer> getPlayerStore(int gameId) {
        ArrayList<Integer> values = new ArrayList<>();
        Goods goods = games.get(gameId).getPlayer().getStore();
        values.add(goods.grain);
        values.add(goods.wood);
        values.add(goods.tools);
        values.add(goods.iron);
        return values;
    }

}
