package es.udc.psi.citizen.view;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.databinding.ActivityCityBinding;
import es.udc.psi.citizen.domain.City;
import es.udc.psi.citizen.view.ui.main.SectionsPagerAdapter;
import es.udc.psi.citizen.R;

import static es.udc.psi.citizen.viewModel.viewModelConst.CITY_ID_KEY;
import static es.udc.psi.citizen.viewModel.viewModelConst.GAME_ID_KEY;

public class CityActivity extends AppCompatActivity {

    private ActivityCityBinding binding;
    int gameId, cityId;
    City city;
    TextView cityNameTv, cityPlayerMoney;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        binding = ActivityCityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        gameId = getIntent().getExtras().getInt(GAME_ID_KEY);
        cityId = getIntent().getExtras().getInt(CITY_ID_KEY);
        city = DataRepository.getData().getCity(gameId, cityId);

        cityNameTv = findViewById(R.id.city_title);
        cityNameTv.setText(city.getName());
        cityPlayerMoney = findViewById(R.id.city_player_money);
        cityPlayerMoney.setText(getText(R.string.player_money_str).toString() + ": " + DataRepository.getData().getPlayerMoney(gameId));
    }
}