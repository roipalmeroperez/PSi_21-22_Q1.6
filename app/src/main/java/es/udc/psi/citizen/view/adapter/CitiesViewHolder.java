package es.udc.psi.citizen.view.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.viewModel.CityViewModel;

public class CitiesViewHolder extends RecyclerView.ViewHolder {

    TextView elementName, elementPopulation;

    public CitiesViewHolder(@NonNull View itemView) {
        super(itemView);
        elementName = itemView.findViewById(R.id.cities_list_element_name_tv);
        elementPopulation = itemView.findViewById(R.id.cities_list_element_population_tv);
    }

    public void bind(CityViewModel cityViewModel) {
        elementName.setText("Name: " + cityViewModel.getName());
        elementPopulation.setText("Population: " + cityViewModel.getPopulation());
    }
}
