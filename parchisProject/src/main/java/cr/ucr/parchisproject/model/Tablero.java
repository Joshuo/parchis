/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.model;

/**
 *
 * @author Xpc
 */
public class Tablero {
    
    private Casilla[] casillas;
    
    public Tablero() {
        casillas = new Casilla[68];
        inicializarCasillas();
    }
    
    private void inicializarCasillas() {
        //Aqui irian las con sus coordenadas... SI TUVIERA ALGUNA    >:(
        //Ejemplo: casillas[0] = new Casilla(1, 80, 500, false, "normal");
        //Casillas especiales: 68, 63, 51, 46, 34, 29, 17, 12
        //casillas[11] = new Casilla(12, 320, 420, true, "especial");
        //Hugo del futuro recuerda que las casillas especiales son -1, empieza esto en 0
        //Esto se pospone xq que pereza
    }
    
    //Retorna la casilla según su número (1–68)
    public Casilla obtenerCasilla(int numero) {
        return casillas[numero - 1];
    }
    
    //Retorna las coordenadas (x, y) de una casilla específica
    public int[] getCoordenadas(int numeroCasilla) {
        Casilla c = obtenerCasilla(numeroCasilla);
        if (c != null) {
            return new int[]{c.getX(), c.getY()};
        }
        return new int[]{0, 0};
    }

    
    
    
}
