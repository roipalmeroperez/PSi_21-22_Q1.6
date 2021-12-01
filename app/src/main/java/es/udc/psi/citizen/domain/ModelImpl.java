package es.udc.psi.citizen.domain;

import java.util.ArrayList;
import java.util.List;

import static es.udc.psi.citizen.domain.ModelConst.MAX_GAMES;

import es.udc.psi.citizen.domain.dto.GameViewModel;

public class ModelImpl implements Model{
    ArrayList<Game> games;

    public ModelImpl() {
        games = new ArrayList<>(MAX_GAMES);
        for (int i = 0; i < MAX_GAMES; i++) {
            games.add(new Game());
        }
    }

    @Override
    public List<GameViewModel> getGameViewModel() {
        ArrayList<GameViewModel> list = new ArrayList<>();
        for (int i = 0; i < games.size(); i++) {
            list.add(new GameViewModel(games.get(i)));
        }
        return list;
    }

    @Override
    public void update() {

    }
}
