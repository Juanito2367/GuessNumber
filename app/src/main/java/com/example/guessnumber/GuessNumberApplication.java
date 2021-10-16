package com.example.guessnumber;

import android.app.Application;

import com.example.guessnumber.data.model.Jugador;

public class GuessNumberApplication extends Application {
   public Jugador jug;
    @Override
    public void onCreate() {
        super.onCreate();

    }
    public Jugador GetJugador(){
        return jug;

    }
}
