package com.example.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.guessnumber.GuessNumberApplication;
import com.example.guessnumber.data.model.Jugador;
import com.example.guessnumber.databinding.ActivityEndPlayBinding;

/**
 * Esta Activity se encarga dse mostrar en la pantalla si has acertado el número o no y en cuantos
 * Intentos con el campo isResultado que es un booleano.
 */
public class EndPlayActivity extends AppCompatActivity {
    private ActivityEndPlayBinding binding;
Jugador jug;

    /**
     * Al Sobreescribir este método lo que hacemos es que si pulsamos en retroceder nos vamos a la
     * Activity inicial.
     */
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,ConfigActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEndPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        jug=((GuessNumberApplication)getApplication()).jug;
        binding.tvNombreJugador.setText(jug.getUser());
        Integer Intentos=jug.getIntentosRealizados();
        if (jug.isResultado()){


            binding.tvResul.setText("Has Acertado el Número en "+Intentos+" Intentos");

            binding.tvNum.setText(jug.getNumeroGenerado().toString());
        }
        else {
            binding.tvResul.setText("Has fallado el Número en "+Intentos+" Intentos");
            binding.tvNum.setText(jug.getNumeroGenerado().toString());
        }
    }
}