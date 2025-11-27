/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Xpc
 */
public class RecursoSonido {
    
    private Clip clip;
    
    public void cargarYReproducir(String ruta, boolean loop) {
        try {
            URL url = getClass().getResource(ruta);

            if (url == null) {
                System.out.println("ERROR: No se encontró el archivo de audio: " + ruta);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void reproducirEfecto(String ruta) {
        try {
            URL url = getClass().getResource(ruta);

            if (url == null) {
                System.out.println("ERROR: No se encontró el efecto de sonido: " + ruta);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            Clip clipEfecto = AudioSystem.getClip();
            clipEfecto.open(audioIn);
            clipEfecto.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
