package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.domain.Model;
import es.udc.psi.citizen.R;
import es.udc.psi.citizen.viewModel.GameViewModel;

import static es.udc.psi.citizen.viewModel.viewModelConst.CITY_ID_KEY;
import static es.udc.psi.citizen.viewModel.viewModelConst.GAME_ID_KEY;
import static es.udc.psi.citizen.viewModel.viewModelConst.MAX_GAMES_BUTTONS;

public class GameListActivity extends AppCompatActivity {

    List<GameViewModel> games;
    List<Button> gameButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        setUI();
    }

    private void setUI() {
        games = DataRepository.getData().getGameViewModels();
        gameButtons = new ArrayList<>();
        gameButtons.add(findViewById(R.id.game1_button));
        gameButtons.add(findViewById(R.id.game2_button));
        gameButtons.add(findViewById(R.id.game3_button));
        gameButtons.add(findViewById(R.id.game4_button));

        String dateFormat = getString(R.string.date_formatter);

        for(int i = 0; i < MAX_GAMES_BUTTONS; i++) {
            Button button = gameButtons.get(i);
            if (i < games.size())
                button.setText(games.get(i).toString(dateFormat));
            int j = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (j < games.size()) {
                        Intent intent = new Intent(getApplicationContext(), CityListActivity.class);
                        intent.putExtra(GAME_ID_KEY, j);
                        //intent.setAction(Intent.ACTION_SEND);
                        //Intent intent = new Intent(getApplicationContext(), CityActivity.class);
                        //intent.putExtra(GAME_ID_KEY, "3");
                        //intent.putExtra(CITY_ID_KEY, "4");
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Add games is not implemented yet", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}