package es.udc.psi.citizen.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import static es.udc.psi.citizen.domain.ModelConst.MIN_CITIES;
import static es.udc.psi.citizen.domain.ModelConst.MAX_CITIES;

public class GameListActivity extends AppCompatActivity {

    List<GameViewModel> games;
    List<Button> gameButtons;
    EditText nameEt, citiesEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        DataRepository.getData(getString(R.string.cities_names));
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
                        startActivity(intent);
                    } else {
                        createGame();
                    }
                }
            });
        }
    }

    private void createGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.creation_game_title));

        View alertDialogView = getLayoutInflater().inflate(R.layout.alert_dialog_create_game, null);
        builder.setView(alertDialogView);

        nameEt = findViewById(R.id.creation_game_name_et);
        citiesEt = findViewById(R.id.creation_game_citie_et);

        builder.setPositiveButton(getString(R.string.creation_game_positive_button_str), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                nameEt = alertDialogView.findViewById(R.id.creation_game_name_et);
                citiesEt = alertDialogView.findViewById(R.id.creation_game_citie_et);
                int nCities = 0;

                Boolean create = true;
                if (nameEt.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.creation_game_empty_name_err), Toast.LENGTH_SHORT).show();
                    create = false;
                }
                if (citiesEt.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), getString(R.string.creation_game_cities_number_err), Toast.LENGTH_SHORT).show();
                    create = false;
                } else {
                    nCities = Integer.parseInt(citiesEt.getText().toString());
                    if ((nCities < MIN_CITIES) || (nCities > MAX_CITIES)) {
                        Toast.makeText(getApplicationContext(), getString(R.string.creation_game_cities_number_err), Toast.LENGTH_SHORT).show();
                        create = false;
                    }
                }

                if (create)
                    DataRepository.getData().addGame(nameEt.getText().toString(), nCities, getString(R.string.cities_names));
            }
        });
        builder.setNegativeButton(getString(R.string.creation_game_negative_button_str), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}