package es.udc.psi.citizen.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.udc.psi.citizen.R;
import es.udc.psi.citizen.data.DataRepository;
import es.udc.psi.citizen.domain.Model;
import es.udc.psi.citizen.viewModel.GameViewModel;
import static es.udc.psi.citizen.domain.ModelConst.MAX_GAMES;

public class GameListFragment extends Fragment {

    List<GameViewModel> games;
    Button game1, game2, game3, game4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        games = DataRepository.getData().getGameViewModels();
        setUI();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_list, container, false);
    }

    private void setUI() {
        game1 = (Button) getActivity().findViewById(R.id.game1_button);
        /*game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "hola", Toast.LENGTH_SHORT).show();
            }
        });*/
        //if (games.get(0)!=null)
            //game1.setText(games.get(0).getPlayerName());
        //else
            //game1.setText(getString(R.string.app_name));

        game2 = getActivity().findViewById(R.id.game2_button);
        /*game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), games.get(1).getPlayerName(), Toast.LENGTH_SHORT).show();
            }
        });*/
        /*if (games.get(1)!=null)
            game2.setText(games.get(1).getPlayerName());
        else
            game2.setText("");*/

        game3 = getActivity().findViewById(R.id.game3_button);
        /*if (games.get(2)!=null)
            game3.setText(games.get(2).getPlayerName());
        else
            game3.setText("");*/

        game4 = getActivity().findViewById(R.id.game4_button);
        /*if (games.get(3)!=null)
            game4.setText(games.get(3).getPlayerName());
        else
            game4.setText(getString(R.string.empty_str));*/
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
//        if (games.get(0)!=null)
        game1 = (Button) activity.findViewById(R.id.game1_button);
        //game1.setText("Hola");
//        else
//        game1.setText(getString(R.string.app_name));
    }
}