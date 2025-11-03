/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Xpc
 */
public class BancoPreguntas {

    private ArrayList<Pregunta> preguntas;
    private Random random;

    public BancoPreguntas() {
        preguntas = new ArrayList<Pregunta>();
        random = new Random();
        cargarPreguntas();
    }

    private void cargarPreguntas() {
        //Preguntas faciles
        preguntas.add(new Pregunta("El Sol es una estrella.", true, "facil"));

        //Preguntas dificiles
    }

    
    //Retorna una pregunta aleatoria según la dificultad especificada.
    public Pregunta obtenerPreguntaAleatoria(String dificultad) {
        ArrayList<Pregunta> preguntasFiltradas = new ArrayList<Pregunta>();

        // Filtra las preguntas de acuerdo a la dificultad
        for (int i = 0; i < preguntas.size(); i++) {
            Pregunta p = preguntas.get(i);
            if (p.getDificultad().equalsIgnoreCase(dificultad)) {
                preguntasFiltradas.add(p);
            }
        }

        if (preguntasFiltradas.isEmpty()) {
            return null; // Si no hay preguntas de ese tipo
        }

        int indice = random.nextInt(preguntasFiltradas.size());
        return preguntasFiltradas.get(indice);
    }

    

    //Devuelve el total de preguntas almacenadas.
    public int totalPreguntas() {
        return preguntas.size();
    }
    
}
