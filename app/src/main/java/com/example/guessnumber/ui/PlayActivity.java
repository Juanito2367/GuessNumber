package com.example.guessnumber.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.guessnumber.GuessNumberApplication;
import com.example.guessnumber.R;
import com.example.guessnumber.data.model.Jugador;
import com.example.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

/**
 * Esta Activity se encarga de recoger el objeto jugador de la clase GuessNumberApplication ,recoger el número de intentos
 * para ponerlos en el TextView,generar un número Aleatorio y guardarlo en el campo del objeto llamado NumeroGenerado
 * Realiza las comprobaciones del numero seleccionado desde la interfaz y el generado y va mostrado dialogos inidicando si el número generado
 * es mayor o menor que el seleccionado si es el mismo pasamos a la siguiente activity o si se superan los intentos permitidos.
 * */
public class PlayActivity extends AppCompatActivity {
private ActivityPlayBinding binding;
Random rnd=new Random();
Jugador jug;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        jug=((GuessNumberApplication)getApplication()).jug;

        binding.tvIntentosRes.setText(jug.getIntentos().toString());






jug.setNumeroGenerado(rnd.nextInt(101));


    }
    public void getOnclick(View view) {
        switch (view.getId()) {
            case R.id.btnComprobar:
                Comprobar();
                break;

        }
    }

    /**
     * Este método es que el ejecuta al pulsar sobre el Button Comprobar y lo que hace es comprobar si es un número y si esta relleno
     * , realiza las comprobaciones para comparar si es mayor,menor o igual el generado que el introducido y lo va mostrando en cuadros de dialogo.
     * El cuadro de Dialogo tiene una funcion Reintentar que deja vacio el EditText si quedan intentos.
     */
    void Comprobar(){
        if (EsRellenado(binding.txtNum.getText().toString())&&EsNumero(binding.txtNum.getText().toString())){
        jug.setIntentosRealizados(jug.getIntentosRealizados()+1);
        Integer IntentosFaltantes=(jug.getIntentos()-jug.getIntentosRealizados());
        binding.tvIntentosRes.setText(IntentosFaltantes.toString());
        Integer NumSel=Integer.valueOf(binding.txtNum.getText().toString());
        if (IntentosFaltantes==0){
Fallado();
        }
        if (NumSel>jug.getNumeroGenerado()){
if (IntentosFaltantes!=0)
Esmayor();

        }
        if (NumSel<jug.getNumeroGenerado()){
            if (IntentosFaltantes!=0)
         Esmenor();

        }

if (NumSel==jug.getNumeroGenerado()){

 Acertado();
}}
    }

    void Esmayor(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Número Erroneo");
        builder.setMessage("El Número seleccionado es mayor que el Correcto");
        builder.setNeutralButton( "Reintentar", Reintentar());


        AlertDialog dialog = builder.create();

        dialog.show();

    }
    void Esmenor(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Número Erroneo");
        builder.setMessage("El Número seleccionado es menor que el Correcto");
        builder.setNeutralButton( "Reintentar", Reintentar());
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
    void Acertado(){
        jug.setResultado(true);
        Intent intent=new Intent(this,EndPlayActivity.class);
        startActivity(intent);
    }
void Fallado(){
    Intent intent=new Intent(this,EndPlayActivity.class);
    startActivity(intent);
}
    /**
     * Este es el método que comprueba si el texto es un número y lo comprueba con TextUtil.IsDigitOnly()
     * @param text Es el String que queremos comprobar si es un número.
     * @return Si es false es que no es un número y si me devuelve true es que si lo es.
     */
    Boolean EsNumero(String text){
      if (TextUtils.isDigitsOnly((CharSequence) text)){
          return true;
      }
      else {
          showMessage("Tiene que ser un Número");
          return false;
      }

}
    /**
     * Este es el método que comprueba si esta vacia la cadena que se le pasa y lo comprueba con TextUtil.IsEmpty()
     * @param text Es el String que queremos comprobar si esta vacio.
     * @return Si es false es que esta vacio y si me devuelve true es que esta relleno.
     */
    Boolean EsRellenado(String text){
        if (TextUtils.isEmpty((CharSequence) text)){
            showMessage("Tienes que rellenar los campos");
            return false;

        }
        else {

            return true;
        }

    }
    /**
     * Este método sirve para mostrar un mensaje durante un tiempo corto para avisar al usuario que no esta cumpliendo con las normas de la aplicación.
     * @param Text El mensaje que le pasamos desde las comprobaciones que sera el que se le muestre al Usuario.
     */
void  showMessage(String Text){
    Toast.makeText(this,Text,Toast.LENGTH_LONG).show();

}

    /**
     * Este método lo que hace es dejar en blanco el campo EditText donde se introducen los números.
     * @return
     */
    @SuppressLint("ResourceType")
    DialogInterface.OnClickListener Reintentar(){
binding.txtNum.setText("");



        return null;
    }

}