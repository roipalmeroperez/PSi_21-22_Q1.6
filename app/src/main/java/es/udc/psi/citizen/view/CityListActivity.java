package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.view.adapter.CitiesAdapter;
import es.udc.psi.citizen.viewModel.CityViewModel;

import static es.udc.psi.citizen.viewModel.viewModelConst.CITY_ID_KEY;
import static es.udc.psi.citizen.viewModel.viewModelConst.GAME_ID_KEY;

import java.util.List;

public class CityListActivity extends AppCompatActivity {

    int gameId;
    List<CityViewModel> cities;
    RecyclerView recyclerView;
    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        gameId = (int) Integer.parseInt(getIntent().getExtras().get(GAME_ID_KEY).toString()) ;
        cities = DataRepository.getData().getCityViewModels(gameId);
        recyclerView = findViewById(R.id.cities_rv);

        initRecycler(cities);
    }

    private void initRecycler(List<CityViewModel> data) {
        citiesAdapter = new CitiesAdapter(data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(citiesAdapter);

        citiesAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cities.get(recyclerView.getChildAdapterPosition(view));
                Intent intent = new Intent(getApplicationContext(), CityActivity.class);
                intent.putExtra(GAME_ID_KEY, gameId);
                intent.putExtra(CITY_ID_KEY, recyclerView.getChildAdapterPosition(view));
                startActivity(intent);
            }
        });
    }
}