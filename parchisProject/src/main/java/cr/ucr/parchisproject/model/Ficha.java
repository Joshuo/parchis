/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

import java.awt.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Xpc
 */
public class Ficha {

    private String color;
    private int posicionActual; //Solo contemplaba el camino principal 1-68
    private int x;
    private int y;
    boolean enCasa;
    boolean enMeta;
    private boolean enCaminoFinal;
    private int posicionFinal;    // 0–7 (7 = meta)
    private int entradaFinal;     // casilla donde entra al camino final
    private Image imagen;

    public Ficha(String color, int xInicial, int yInicial) {
        this.color = color;
        this.posicionActual = 0;
        this.x = xInicial + 20;
        this.y = yInicial + 20;
        this.enCasa = true;
        this.enMeta = false;
        this.enCaminoFinal = false;
        this.posicionFinal = -1;
        asignarEntradaFinal(color);
        cargarImagenFicha(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEnCasa() {
        return enCasa;
    }

    public void setEnCasa(boolean enCasa) {
        this.enCasa = enCasa;
    }

    public boolean isEnMeta() {
        return enMeta;
    }

    public void setEnMeta(boolean enMeta) {
        this.enMeta = enMeta;
    }

    public Image getImagen() {
        return imagen;
    }

    public boolean isEnCaminoFinal() {
        return enCaminoFinal;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public int getEntradaFinal() {
        return entradaFinal;
    }

    //Carga imagen de ficha segun color
    private void cargarImagenFicha(String color) {
        try {
            switch (color.toLowerCase()) {
                case "rojo":
                    imagen = ImageIO.read(getClass().getResource("/img/FichaFuego.png"));
                    break;
                case "azul":
                    imagen = ImageIO.read(getClass().getResource("/img/FichaAgua.png"));
                    break;
                case "amarillo":
                    imagen = ImageIO.read(getClass().getResource("/img/FichaElectrico.png"));
                    break;
                case "verde":
                    imagen = ImageIO.read(getClass().getResource("/img/FichaPlanta.png"));
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error cargando imagen de ficha " + color);
        }
    }

    //Asigna entrada final
    private void asignarEntradaFinal(String color) {
        switch (color.toLowerCase()) {
            case "rojo":
                entradaFinal = 64;
                break;
            case "azul":
                entradaFinal = 47;
                break;
            case "amarillo":
                entradaFinal = 30;
                break;
            case "verde":
                entradaFinal = 13;
                break;
        }
    }

    //Movimiento ficha
    //Los return vacios significan salir inmediatamente de este método y no ejecutar nada más (Es como un break chafa), era esto o todo a puro if y else
    public void mover(int pasos) {
        // Si está en casa o ya en meta, no se mueve
        if (enCasa || enMeta) {
            return;
        }

        // Si ya está en camino final, solo aplica la lógica del camino final
        if (enCaminoFinal) {
            moverEnCaminoFinal(pasos);
            return;
        }

        // Movimiento en camino principal 
        posicionActual += pasos;

        // Si llega exactamente a la entrada final, cambia a camino final 
        if (posicionActual == entradaFinal) {
            enCaminoFinal = true;
            posicionFinal = 0; // primer casilla del camino final 
            return;
        }
        
        // Por seguridad, tope 
        if (posicionActual > 68) {
            posicionActual = 68;
        }
    }

    private void moverEnCaminoFinal(int pasos) {
        if (enMeta) {
            return;
        }

        int nuevaPosFinal = posicionFinal + pasos;

        if (nuevaPosFinal == 7) {
            posicionFinal = 7;
            enMeta = true;
            return;
        }

        if (nuevaPosFinal > 7) {
            // no se mueve si se pasa
            return;
        }

        posicionFinal = nuevaPosFinal;
    }

    public void entrarAlCaminoFinal() {
        enCaminoFinal = true;
        posicionFinal = 0;
    }

    //Dado igual 5 para sacarlo de la casa
    public void salirDeCasa(int posicionSalida) {
        if (enCasa) {
            posicionActual = posicionSalida;
            enCasa = false;
        }
    }

    //Envia la ficha a casa(por colison o error)
    public void volverACasa() {
        posicionActual = 0;
        enCasa = true;
        enMeta = false;
        enCaminoFinal = false;
        posicionFinal = -1;
    }

    public void actualizarCoordenadas(int nuevaX, int nuevaY) {
        this.x = nuevaX;
        this.y = nuevaY;
    }

}
