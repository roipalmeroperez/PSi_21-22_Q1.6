package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.viewModel.CityViewModel;

import static es.udc.psi.citizen.viewModel.viewModelConst.GAME_ID_KEY;

import java.util.List;

public class CityListActivity extends AppCompatActivity {

    int gameId;
    List<CityViewModel> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        gameId = (int) Integer.parseInt(getIntent().getExtras().get(GAME_ID_KEY).toString()) ;
        cities = DataRepository.getData().getCityViewModels(gameId);

        TextView gameIdTv = findViewById(R.id.game_id_tv);
        gameIdTv.setText("Game Id: " + gameId);
        TextView citiesNumber = findViewById(R.id.cities_number_tv);
        citiesNumber.setText("Cities number: " + cities.size());

    }
}