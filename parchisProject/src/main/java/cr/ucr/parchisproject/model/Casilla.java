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
    private boolean esEspecial;
    private String tipo; //Normal, especial, salida, meta

    public Casilla(int numero, int x, int y, boolean esEspecial, String tipo) {
        this.numero = numero;
        this.x = x;
        this.y = y;
        this.esEspecial = esEspecial;
        this.tipo = tipo;
    }

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

    public boolean isEsEspecial() {
        return esEspecial;
    }

    public void setEsEspecial(boolean esEspecial) {
        this.esEspecial = esEspecial;
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
    
    @Override
    public String toString() {
        return "Casilla{" + "numero=" + numero + ", x=" + x + ", y=" + y + ", esEspecial=" + esEspecial + ", tipo=" + tipo + '}';
    }
    
    
}
