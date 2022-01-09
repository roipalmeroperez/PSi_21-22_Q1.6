package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        gameId = getIntent().getExtras().getInt(GAME_ID_KEY, -1);
        cities = DataRepository.getData().getCityViewModels(gameId);

    }
}