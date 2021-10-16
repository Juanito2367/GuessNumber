package com.example.guessnumber.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.guessnumber.GuessNumberApplication;
import com.example.guessnumber.R;
import com.example.guessnumber.data.model.Jugador;
import com.example.guessnumber.databinding.ActivityConfigBinding;

/**
 * Esta Activity es la que se encarga de recoger los datos del Nombre del jugador y Los intentos y se los pasa al objeto contenido en la clase
 * que hereda de application para que el resto de activity tengan acceso. Ademas comprueba que los campos no esten vacios para que no de error de ningun tipo.
 * Que el campo sea númerico se comprueba desde el layout.
 */
public class ConfigActivity extends AppCompatActivity {
private ActivityConfigBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }


    public void getOnclick(View view) {
        switch (view.getId()) {
            case R.id.btnPlay:
                Jugar();
                break;

        }
    }

    /**
     * Este método es el que ejecuta el Button que lo unico que hace es hacer comprobaciones con un método que he creado para que compruebe que no este vacio si no
     * lanza una alerta, y relleno el objeto jug de la clase heredada de application con el que contiene los datos.     */
        void Jugar(){
        if (EsRellenado(binding.txtIntentos.getText().toString())&&EsRellenado(binding.txtNom.getText().toString())&&EsMayor1()){
            Jugador jug=new Jugador(binding.txtNom.getText().toString(),Integer.valueOf(binding.txtIntentos.getText().toString()));
            ((GuessNumberApplication)getApplication()).jug=jug;
            Intent intent=new Intent(this,PlayActivity.class);
            startActivity(intent);}

        }

    /**
     * Este es el método que comprueba si esta vacia la cadena que se le pasa y lo comprueba con TextUtil.IsEmpty()
     * @param text Es el String que queremos comprobar si esta vacio.
     * @return Si es false es que esta vacio y si me devuelve true es que esta relleno.
     */
    Boolean EsRellenado(String text){
        if (TextUtils.isEmpty(text)){
            ShowMessage("Todos los campos tienen que estar rellenos");
            return false;

        }
        else {
            return true;
        }

}
    Boolean EsMayor1(){
        if (Integer.valueOf(String.valueOf(binding.txtIntentos.getText()))<1){
            ShowMessage("El número tiene que ser mayor o igual que 1");
            return false;

        }
        else {
            return true;
        }

    }

    /**
     * Este método sirve para mostrar un mensaje durante un tiempo corto para avisar al usuario que no esta cumpliendo con las normas de la aplicación.
     * @param Mensaje El mensaje que le pasamos desde las comprobaciones que sera el que se le muestre al Usuario.
     */
    void ShowMessage(String Mensaje){
    Toast.makeText(this,Mensaje,Toast.LENGTH_LONG).show();

}
}

