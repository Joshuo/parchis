/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Xpc
 */
public class RecursoSonido {
    
    private Clip clip;
    
    public void cargarYReproducir(String ruta, boolean loop) {
        try {
            File audioFile = new File(ruta);
            if (!audioFile.exists()) return;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void reproducirEfecto(String ruta) {
        try {
            File audioFile = new File(ruta);
            if (!audioFile.exists()) return;
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(audioFile);
            Clip clipEfecto = AudioSystem.getClip();
            clipEfecto.open(audioIn);
            clipEfecto.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
