package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.domain.Model;
import es.udc.psi.citizen.R;
import es.udc.psi.citizen.viewModel.GameViewModel;

public class GameListActivity extends AppCompatActivity {

    List<GameViewModel> games;
    List<Button> gameButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        games = DataRepository.getData().getGameViewModels();
        gameButtons = new ArrayList<>();
        gameButtons.add(findViewById(R.id.game1_button));
        gameButtons.add(findViewById(R.id.game2_button));
        gameButtons.add(findViewById(R.id.game3_button));
        gameButtons.add(findViewById(R.id.game4_button));

        String dateFormat = getString(R.string.date_formatter);

        for(int i = 0; i < games.size(); i++) {
            gameButtons.get(i).setText(games.get(i).toString(dateFormat));
        }
    }
}