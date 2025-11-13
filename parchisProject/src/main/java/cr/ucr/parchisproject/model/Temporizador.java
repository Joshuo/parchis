/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

/**
 *
 * @author Xpc
 */
public class Temporizador implements Runnable{
    
    private int segundos;
    private boolean activo;
    private Thread hilo;
    
   public Temporizador() {
        this.segundos = 0;
        this.activo = false;
    }

    public void iniciar() {
        if (activo) return;
        activo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    public void detener() {
        activo = false;
        // interrupción ligera
        if (hilo != null) {
            hilo.interrupt();
        }
    } 
    
    public String getTiempoFormateado() {
        int s = segundos % 60;
        int m = (segundos / 60) % 60;
        int h = segundos / 3600;
        return String.format("%02d:%02d:%02d", h, m, s);
        /*Segun lo que investigue este es el formato es el mas optimo al hacer temporizadores
        %: Indica el inicio de un especificador de formato.
        0: Especifica que el número debe rellenarse con ceros a la izquierda si tiene menos del ancho especificado.
        2: Especifica que el número debe ocupar un ancho mínimo de 2 caracteres.
        d: Indica que el argumento es un número entero decimal.*/
    }

    public int getSegundos() { return segundos; }

    @Override
    public void run() {
        while (activo) {
            try {
                Thread.sleep(1000);
                segundos++;
            } catch (InterruptedException e) {
                if (!activo) break;
            }
        }
    }
}
