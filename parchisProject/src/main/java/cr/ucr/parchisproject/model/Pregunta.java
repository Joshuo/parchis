/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

/**
 *
 * @author Xpc
 */
public class Pregunta {
    
    private String texto;
    private boolean respuestaCorrecta;
    private String dificultad; // "facil" o "dificil"

    public Pregunta(String texto, boolean respuestaCorrecta, String dificultad) {
        this.texto = texto;
        this.respuestaCorrecta = respuestaCorrecta;
        this.dificultad = dificultad;
    }

    public String getTexto() {
        return texto;
    }

    public boolean getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public String getDificultad() {
        return dificultad;
    }


    //Verifica si la respuesta del jugador es correcta.

    public boolean esCorrecta(boolean respuestaJugador) {
        return respuestaJugador == respuestaCorrecta;
    }
    
    
}

