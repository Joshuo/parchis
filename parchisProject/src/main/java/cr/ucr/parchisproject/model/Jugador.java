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

    //Constructor
    public Jugador(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
        this.puntaje = 5;
        this.respuestasCorrectas = 0;
        this.respuestasIncorrectas = 0;
        this.fichas = new ArrayList<Ficha>();
        this.turnoActivo = false;
        inicializarFichas();
    }

    
    //Gets y sets
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

    public void activarTurno() {
        turnoActivo = true;
    }

    public void desactivarTurno() {
        turnoActivo = false;
    }  

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", color=" + color + ", puntaje=" + puntaje + ", respuestasCorrectas=" + respuestasCorrectas + ", respuestasIncorrectas=" + respuestasIncorrectas + ", fichas=" + fichas + ", turnoActivo=" + turnoActivo + '}';
    }
    
    //METODOS
    
    //Creacion de fichas
    private void inicializarFichas() {

        int[][] coords = obtenerCoordenadasIniciales(color);

        // Crea 4 fichas del mismo color
        for (int i = 0; i < 4; i++) {
            fichas.add(new Ficha(color, coords[i][0], coords[i][1]));
        }
    }
    
    //Coordenadas inciales segun el color
    private int[][] obtenerCoordenadasIniciales(String color) {

        int[][] coords = new int[4][2];

        switch (color.toLowerCase()) {
            case "rojo":
                coords[0] = new int[]{110, 740};
                coords[1] = new int[]{210, 740};
                coords[2] = new int[]{110, 840};
                coords[3] = new int[]{210, 840};
                break;

            case "azul":
                coords[0] = new int[]{110, 110};
                coords[1] = new int[]{210, 110};
                coords[2] = new int[]{110, 210};
                coords[3] = new int[]{210, 210};
                break;

            case "amarillo":
                coords[0] = new int[]{740, 110};
                coords[1] = new int[]{840, 110};
                coords[2] = new int[]{740, 210};
                coords[3] = new int[]{840, 210};
                break;

            case "verde":
                coords[0] = new int[]{740, 740};
                coords[1] = new int[]{840, 740};
                coords[2] = new int[]{740, 840};
                coords[3] = new int[]{840, 840};
                break;
        }

        return coords;
    }
    
    
    //Puntuacion / Respuesta
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
    
    //Reinicia al jugador
    public void reiniciar() {
        puntaje = 5;
        respuestasCorrectas = 0;
        respuestasIncorrectas = 0;
        for (int i = 0; i < fichas.size(); i++) {
            fichas.get(i).volverACasa();
        }
    }
    
    
}
