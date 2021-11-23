package es.udc.psi.citizen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import es.udc.psi.citizen.entity.Model;

public class MainActivity extends AppCompatActivity {

    Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = new Model();
    }
}