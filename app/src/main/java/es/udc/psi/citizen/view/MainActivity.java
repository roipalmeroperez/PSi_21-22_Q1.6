package es.udc.psi.citizen.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.domain.Model;

public class MainActivity extends AppCompatActivity {

    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}