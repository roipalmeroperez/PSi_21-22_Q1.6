package es.udc.psi.citizen.domain;

import java.util.List;


import es.udc.psi.citizen.viewModel.CityViewModel;
import es.udc.psi.citizen.viewModel.GameViewModel;

public interface Model {
    public List<GameViewModel> getGameViewModels();
    public List<CityViewModel> getCityViewModels(int gameId);
    public int getPlayerMoney(int gameId);
    public City getCity(int gameId, int cityId);
}
