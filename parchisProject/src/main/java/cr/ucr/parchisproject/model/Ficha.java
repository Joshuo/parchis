/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

/**
 *
 * @author Xpc
 */
public class Ficha {
    
    private String color;
    private int posicionActual;
    private int x;
    private int y;
    boolean enCasa;
    boolean enMeta;

    public Ficha(String color, int xInicial, int yInicial) {
        this.color = color;
        this.posicionActual = 0;
        this.x = xInicial;
        this.y = yInicial;
        this.enCasa = true;
        this.enMeta = false;
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
    
    
    //Movimiento ficha
    //@param?
    public void mover(int pasos) {
        if (!enCasa && !enMeta) {
            posicionActual += pasos;
            
            if(posicionActual >= 68) {
                posicionActual = 68;
                enMeta = true;
            }
        }
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
    }
    
    public void actualizarCoordenadas(int nuevaX, int nuevaY) {
        this.x = nuevaX;
        this.y = nuevaY;
    }
    
    
}
