package com.example.guessnumber.data.model;


import java.io.Serializable;

public class Jugador implements Serializable {

    private String user;
    private Integer Intentos;
    private Integer IntentosRealizados;
private boolean Resultado=false;
private Integer NumeroGenerado;

    public Integer getNumeroGenerado() {
        return NumeroGenerado;
    }

    public void setNumeroGenerado(Integer numeroGenerado) {
        NumeroGenerado = numeroGenerado;
    }

    //Constructor
    public Jugador(String user, Integer Intentos) {
        this.user = user;
        this.Intentos = Intentos;
        IntentosRealizados=0;
    }

    public boolean isResultado() {
        return Resultado;
    }

    public void setResultado(boolean resultado) {
        Resultado = resultado;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "user='" + user + '\'' +
                ", Intentos=" + Intentos +
                ", IntentosRealizados=" + IntentosRealizados +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getIntentos() {
        return Intentos;
    }

    public void setIntentos(Integer intentos) {
        Intentos = intentos;
    }

    public Integer getIntentosRealizados() {
        return IntentosRealizados;
    }

    public void setIntentosRealizados(Integer intentosRealizados) {
        IntentosRealizados = intentosRealizados;
    }
}