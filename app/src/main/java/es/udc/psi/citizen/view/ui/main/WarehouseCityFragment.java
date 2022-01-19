package es.udc.psi.citizen.view.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;


public class WarehouseCityFragment extends Fragment {

    static int gameId;
    TableLayout tableLayout;

    public WarehouseCityFragment() {
        // Required empty public constructor
    }

    public static WarehouseCityFragment newInstance(int inputGameId) {
        gameId = inputGameId;
        WarehouseCityFragment fragment = new WarehouseCityFragment();
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
        View view = inflater.inflate(R.layout.fragment_warehouse_city, container, false);
        createTable(view);

        return view;
    }

    private void createTable(View view) {
        tableLayout = view.findViewById(R.id.warehouse_city_table);

        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        textParams.weight= 1;

        List<String> labels = getValuesNames();
        List<Integer> values = DataRepository.getData().getPlayerStore(gameId);

        for (int i = 0; i < values.size(); i++) {
            TableRow tableRow = new TableRow(view.getContext());
            tableRow.setLayoutParams(rowParams);

            TextView labelNameTv = new TextView(view.getContext());
            labelNameTv.setText(labels.get(i));
            labelNameTv.setLayoutParams(textParams);
            TextView valueTv = new TextView(view.getContext());
            valueTv.setText("" + values.get(i));
            valueTv.setLayoutParams(textParams);

            tableRow.addView(labelNameTv);
            tableRow.addView(valueTv);
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