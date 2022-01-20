package es.udc.psi.citizen.view.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;

public class TradeCityFragment extends Fragment {

    static int gameId, cityId;
    TableLayout tableLayout;

    public TradeCityFragment() {
        // Required empty public constructor
    }

    public static TradeCityFragment newInstance(int inputGameId, int inputCityId) {
        TradeCityFragment fragment = new TradeCityFragment();
        gameId = inputGameId;
        cityId = inputCityId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trade_city, container, false);
        createTable(view);
        return view;
    }

    private void createTable(View view) {
        tableLayout = view.findViewById(R.id.trade_city_table);

        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams labelParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        labelParams.weight= 1;
        TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);

        List<String> labels = getValuesNames();
        List<Integer> cityValues = DataRepository.getData().getCityGoodsValues(gameId, cityId);
        List<Integer> playerValues = DataRepository.getData().getPlayerStore(gameId);


        for (int i = 0; i < cityValues.size(); i++) {
            TableRow tableRow = new TableRow(view.getContext());
            tableRow.setLayoutParams(rowParams);

            TextView labelNameTv = new TextView(view.getContext());
            labelNameTv.setText(labels.get(i));
            labelNameTv.setLayoutParams(labelParams);
            TextView cityValueTv = new TextView(view.getContext());
            cityValueTv.setText("" + cityValues.get(i));
            cityValueTv.setLayoutParams(textParams);
            Button sellButton = new Button(view.getContext());
            sellButton.setText("-");
            sellButton.setLayoutParams(textParams);
            int j = i;
            sellButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataRepository.getData().sellGoods(gameId, cityId, j);
                }
            });
            TextView playerValueTv = new TextView(view.getContext());
            playerValueTv.setText("" + playerValues.get(i));
            playerValueTv.setLayoutParams(textParams);
            Button buyButton = new Button(view.getContext());
            buyButton.setText("+");
            buyButton.setLayoutParams(textParams);
            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataRepository.getData().buyGoods(gameId, cityId, j);
                }
            });

            tableRow.addView(labelNameTv);
            tableRow.addView(cityValueTv);
            tableRow.addView(sellButton);
            tableRow.addView(playerValueTv);
            tableRow.addView(buyButton);
            tableLayout.addView(tableRow);
        }
    }

    private List<String> getValuesNames(){
        ArrayList<String> names = new ArrayList<>();
        names.add(getString(R.string.goods_grain_str));
        names.add(getString(R.string.goods_wood_str));
        names.add(getString(R.string.goods_tools_str));
        names.add(getString(R.string.goods_iron_str));
        return names;
    }
}