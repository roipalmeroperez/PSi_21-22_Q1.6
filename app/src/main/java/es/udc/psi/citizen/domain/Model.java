package es.udc.psi.citizen.domain;

import java.util.List;


import es.udc.psi.citizen.domain.dto.GameViewModel;

public interface Model extends Updatable {
    public List<GameViewModel> getGameViewModel();
}
