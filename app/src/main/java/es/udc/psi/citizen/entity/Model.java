package es.udc.psi.citizen.entity;

import java.util.ArrayList;
import static es.udc.psi.citizen.entity.ModelConst.MAX_GAMES;

public class Model {
    ArrayList<Game> games;

    public Model() {
        games = new ArrayList<>(MAX_GAMES);
        for (int i = 0; i < MAX_GAMES; i++) {
            games.add(new Game());
        }
    }
}
