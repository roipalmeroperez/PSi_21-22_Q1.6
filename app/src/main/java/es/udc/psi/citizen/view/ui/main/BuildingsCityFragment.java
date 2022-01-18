package es.udc.psi.citizen.view.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.udc.psi.citizen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BuildingsCityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BuildingsCityFragment extends Fragment {

    public BuildingsCityFragment() {
        // Required empty public constructor
    }

    public static BuildingsCityFragment newInstance() {
        BuildingsCityFragment fragment = new BuildingsCityFragment();
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
        return inflater.inflate(R.layout.fragment_buildings_city, container, false);
    }
}