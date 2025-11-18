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
    
    private Casilla[] caminoPrincipal; // 1–68
    private Casilla[][] caminoFinal;   // 4 colores, 7 casillas cada uno
    
    private final String[] colores = {"rojo", "azul", "amarillo", "verde"};
    
    public Tablero() {
        caminoPrincipal = new Casilla[68];
        caminoFinal = new Casilla[4][7]; // 4 colores x 7 casillas finales
        inicializarCaminoPrincipal();
        inicializarCaminosFinales();
    }
    
    //Camino Principal 1-68
    private void inicializarCaminoPrincipal() {
        //Aqui irian las coordenadas... SI TUVIERA ALGUNA    >:(
        //Ejemplo: casillas[0] = new Casilla(1, 80, 500, false, "normal");
        //Casillas especiales: 68, 63, 51, 46, 34, 29, 17, 12
        //casillas[11] = new Casilla(12, 320, 420, true, "especial");
        //Hugo del futuro recuerda que las casillas especiales son -1, empieza esto en 0
        //Esto se pospone xq que pereza
    }
    
    //Camino Final 
    private void inicializarCaminosFinales() {
        // Color 0 = rojo
        // Color 1 = azul
        // Color 2 = amarillo
        // Color 3 = verde
        for (int color = 0; color < 4; color++) {
            for (int i = 0; i < 7; i++) {
                //caminoFinal[color][i] = new Casilla(100 + (color * 10),  X, Y, false, "final");
            }
        }
    }
    
    //Retorna la casilla del camino principal según su número (1–68)
    public Casilla obtenerCasillaPrincipal(int numero) {
        return caminoPrincipal[numero - 1];
    }
    
    //Retorna las coordenadas (x, y) de una casilla del camino principal
    public int[] getCoordenadas(int numeroCasilla) {
        if (numeroCasilla < 1 || numeroCasilla > 68) {
            return new int[]{0, 0};
        }
        Casilla c = caminoPrincipal[numeroCasilla - 1];
        return new int[]{c.getX(), c.getY()};
    }

    //Devuelve una casilla del camino final según color y posición
    public Casilla obtenerCasillaFinal(int color, int posicion) {
        return caminoFinal[color][posicion];
    }
  
}
