package es.udc.psi.citizen.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.viewModel.CityViewModel;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesViewHolder> implements View.OnClickListener {

    private final List<CityViewModel> mDataset;
    private View.OnClickListener listener;

    public CitiesAdapter (List<CityViewModel> data) {
        mDataset = data;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cities_list_element, parent, false);
        v.setOnClickListener(this);
        return new CitiesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesViewHolder holder, int position) {
        holder.bind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setOnClickListener (View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }
}
