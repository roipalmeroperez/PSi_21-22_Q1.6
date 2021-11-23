package es.udc.psi.citizen.entity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Game implements Updatable{

    Map map;
    UserPlayer player;
    LocalDateTime lastUpdate;

    public Game() {
        map = new Map(5);
        player = new UserPlayer();
        lastUpdate = LocalDateTime.now();
    }

    @Override
    public void update() {
        lastUpdate = LocalDateTime.now();
        map.update();
        player.update();
    }
}
