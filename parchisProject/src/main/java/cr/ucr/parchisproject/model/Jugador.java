/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

import java.util.ArrayList;

/**
 *
 * @author Xpc
 */
public class Jugador {
    
    private String nombre;
    private String color;
    private int puntaje;
    private int respuestasCorrectas;
    private int respuestasIncorrectas;
    private ArrayList<Ficha> fichas;
    private boolean turnoActivo;

    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.puntaje = 5;
        this.respuestasCorrectas = 0;
        this.respuestasIncorrectas = 0;
        this.fichas = new ArrayList<Ficha>();
        this.turnoActivo = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getRespuestasCorrectas() {
        return respuestasCorrectas;
    }

    public void setRespuestasCorrectas(int respuestasCorrectas) {
        this.respuestasCorrectas = respuestasCorrectas;
    }

    public int getRespuestasIncorrectas() {
        return respuestasIncorrectas;
    }

    public void setRespuestasIncorrectas(int respuestasIncorrectas) {
        this.respuestasIncorrectas = respuestasIncorrectas;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(ArrayList<Ficha> fichas) {
        this.fichas = fichas;
    }

    public boolean isTurnoActivo() {
        return turnoActivo;
    }

    public void setTurnoActivo(boolean turnoActivo) {
        this.turnoActivo = turnoActivo;
    }  

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", color=" + color + ", puntaje=" + puntaje + ", respuestasCorrectas=" + respuestasCorrectas + ", respuestasIncorrectas=" + respuestasIncorrectas + ", fichas=" + fichas + ", turnoActivo=" + turnoActivo + '}';
    }
    
    
    public void agregarFicha(Ficha ficha) {
        fichas.add(ficha);
    }
    
    public void sumarPunto() { 
        puntaje++; 
    }
    
    public void restarPunto() { 
        if (puntaje > 0) {
            puntaje--;
        }   
    }
    
    public boolean estaEliminado() {
        return puntaje <= 0; 
    }
    
    public void registrarRespuestaCorrecta() {
        respuestasCorrectas++;
        sumarPunto();
    }
    
    public void registrarRespuestaIncorrecta() {
        respuestasIncorrectas++;
        restarPunto();
    }
    
    public void reiniciar() {
        puntaje = 5;
        respuestasCorrectas = 0;
        respuestasIncorrectas = 0;
        for (int i = 0; i < fichas.size(); i++) {
            fichas.get(i).volverACasa();
        }
    }
    
    
}
