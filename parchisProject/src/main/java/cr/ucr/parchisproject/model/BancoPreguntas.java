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
        preguntas.add(new Pregunta("Pikachu es un Pokémon de tipo Eléctrico.", true, "facil"));
        preguntas.add(new Pregunta("Charmander evoluciona a Charizard sin pasar por ninguna otra evolución.", false, "facil"));
        preguntas.add(new Pregunta("Squirtle es uno de los Pokémon iniciales de Kanto.", true, "facil"));
        preguntas.add(new Pregunta("Mewtwo pertenece a la primera generación.", true, "facil"));
        preguntas.add(new Pregunta("Gyarados es un Pokémon de tipo Agua/Dragón.", false, "facil"));
        preguntas.add(new Pregunta("Chikorita es un Pokémon inicial de la región Johto.", true, "facil"));
        preguntas.add(new Pregunta("Totodile es de tipo Planta.", false, "facil"));
        preguntas.add(new Pregunta("Lugia es un Pokémon legendario de la segunda generación.", true, "facil"));
        preguntas.add(new Pregunta("Torchic es un Pokémon inicial de Hoenn.", true, "facil"));
        preguntas.add(new Pregunta("Wurmple puede evolucionar en Silcoon o Cascoon.", true, "facil"));
        preguntas.add(new Pregunta("Piplup es un Pokémon inicial de Sinnoh.", true, "facil"));
        preguntas.add(new Pregunta("Shinx es un Pokémon de tipo Eléctrico.", true, "facil"));
        preguntas.add(new Pregunta("Bidoof es un Pokémon legendario de Sinnoh.", false, "facil"));
        preguntas.add(new Pregunta("Dialga es un Pokémon de tipo Dragón/Acero.", true, "facil"));
        preguntas.add(new Pregunta("Riolu evoluciona a Lucario por nivel sin ninguna condición especial.", false, "facil"));

        //Preguntas dificiles
        preguntas.add(new Pregunta("En la Generación 1, el movimiento Golpe Cuerpo podía paralizar a Pokémon de tipo Normal.", true, "dificil"));
        preguntas.add(new Pregunta("En la Generación 2, Umbreon evoluciona subiendo de nivel con alta amistad durante el día.", false, "dificil"));
        preguntas.add(new Pregunta("Wynaut solo puede obtenerse por crianza en Generación 3 usando un Lax Incense.", true, "dificil"));
        preguntas.add(new Pregunta("En Hoenn, Shedinja aparece automáticamente al evolucionar a Nincada con un espacio libre y una Poké Ball en la mochila.", true, "dificil"));
        preguntas.add(new Pregunta("En la Generación 4, el tipo Fantasma es totalmente inmune a movimientos de tipo Siniestro.", false, "dificil"));
        preguntas.add(new Pregunta("En la Generación 3, Slaking puede atacar cada turno si posee la habilidad Ausente.", false, "dificil"));
        preguntas.add(new Pregunta("Smeargle puede aprender prácticamente cualquier movimiento mediante Esquema, excepto Struggle.", true, "dificil"));
        preguntas.add(new Pregunta("En la Generación 2, los movimientos físicos y especiales dependían del tipo del movimiento, no de la estadística del Pokémon.", true, "dificil"));
        preguntas.add(new Pregunta("Spiritomb originalmente no tenía debilidades antes de que se introdujera el tipo Hada.", true, "dificil"));
        preguntas.add(new Pregunta("En la Generación 4, Rotom podía cambiar de forma sin necesidad de un objeto especial.", false, "dificil"));

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
