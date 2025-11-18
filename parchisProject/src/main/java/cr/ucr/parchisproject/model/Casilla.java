/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

/**
 *
 * @author Xpc
 */
public class Casilla {
    
    private int numero;
    private int x;
    private int y;
    private boolean especial;
    private String tipo; //Normal, especial, salida, meta
    private String color; // solo para casillas del camino final, se me olvido el camino final (-.-")

    public Casilla(int numero, int x, int y, boolean esEspecial, String tipo) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.especial = especial;
        this.tipo = tipo;
        this.color = null;//Voy hacer que el tablero setee el color si es final
    }

    
    //Gets y Sets
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int[] getCoordenadas(){
        return new int []{x, y};
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Casilla{" + "numero=" + numero + ", x=" + x + ", y=" + y + ", especial=" + especial + ", tipo=" + tipo + ", color=" + color + '}';
    }
    
}
