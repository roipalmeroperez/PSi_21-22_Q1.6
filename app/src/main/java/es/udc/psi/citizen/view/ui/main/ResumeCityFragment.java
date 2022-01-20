package es.udc.psi.citizen.view.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.domain.City;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResumeCityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResumeCityFragment extends Fragment {

    private static int gameId, cityId;
    private TableLayout tableLayout;

    public ResumeCityFragment() {
        // Required empty public constructor
    }

    public static ResumeCityFragment newInstance(int inputGameId, int inputCityId) {
        ResumeCityFragment fragment = new ResumeCityFragment();
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
        View view = inflater.inflate(R.layout.fragment_resume_city, container, false);
        createTable(view);

        return view;
    }

    private void createTable(View view) {
        tableLayout = view.findViewById(R.id.resume_city_table);

        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams textParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        textParams.weight= 1;

        List<String> labels = getValuesNames();
        List<Integer> values = DataRepository.getData().getCityResumeValues(gameId, cityId);

        for (int i = 0; i < values.size(); i++) {
            TableRow tableRow = new TableRow(view.getContext());
            tableRow.setLayoutParams(rowParams);

            TextView detailName = new TextView(view.getContext());
            detailName.setText(labels.get(i));
            detailName.setLayoutParams(textParams);
            TextView detailValue = new TextView(view.getContext());
            detailValue.setText("" + values.get(i));
            detailValue.setLayoutParams(textParams);

            tableRow.addView(detailName);
            tableRow.addView(detailValue);
            tableLayout.addView(tableRow);
        }
    }

    private List<String> getValuesNames(){
        ArrayList<String> names = new ArrayList<>();
        names.add(getString(R.string.population_str));
        names.add(getString(R.string.goods_grain_str));
        names.add(getString(R.string.goods_wood_str));
        names.add(getString(R.string.goods_tools_str));
        names.add(getString(R.string.goods_iron_str));
        return names;
    }
}