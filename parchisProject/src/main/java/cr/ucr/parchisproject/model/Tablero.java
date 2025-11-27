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
        caminoFinal = new Casilla[4][8]; // 4 colores x (7 casillas finales + 1 meta)
        inicializarCaminoPrincipal();
        inicializarCaminosFinales();
    }

    //Camino Principal 1-68
    private void inicializarCaminoPrincipal() {
        caminoPrincipal[0] = new Casilla(1, 210, 580, false, "normal");
        caminoPrincipal[1] = new Casilla(2, 254, 580, false, "normal");
        caminoPrincipal[2] = new Casilla(3, 297, 580, false, "normal");
        caminoPrincipal[3] = new Casilla(4, 345, 580, false, "normal");
        caminoPrincipal[4] = new Casilla(5, 380, 615, false, "normal");
        caminoPrincipal[5] = new Casilla(6, 380, 663, false, "normal");
        caminoPrincipal[6] = new Casilla(7, 380, 707, false, "normal");
        caminoPrincipal[7] = new Casilla(8, 380, 750, true, "especial");
        caminoPrincipal[8] = new Casilla(9, 380, 795, false, "normal");
        caminoPrincipal[9] = new Casilla(10, 380, 840, false, "normal");
        caminoPrincipal[10] = new Casilla(11, 380, 885, false, "normal");
        caminoPrincipal[11] = new Casilla(12, 380, 930, false, "normal");
        caminoPrincipal[12] = new Casilla(13, 480, 930, true, "especial");
        caminoPrincipal[13] = new Casilla(14, 580, 930, false, "normal");
        caminoPrincipal[14] = new Casilla(15, 580, 885, false, "normal");
        caminoPrincipal[15] = new Casilla(16, 580, 840, false, "normal");
        caminoPrincipal[16] = new Casilla(17, 580, 795, false, "normal");

        caminoPrincipal[17] = new Casilla(18, 580, 750, false, "normal");
        caminoPrincipal[18] = new Casilla(19, 580, 707, false, "normal");
        caminoPrincipal[19] = new Casilla(20, 580, 663, true, "especial");
        caminoPrincipal[20] = new Casilla(21, 580, 615, false, "normal");
        caminoPrincipal[21] = new Casilla(22, 620, 580, false, "normal");
        caminoPrincipal[22] = new Casilla(23, 664, 580, false, "normal");
        caminoPrincipal[23] = new Casilla(24, 707, 580, false, "normal");
        caminoPrincipal[24] = new Casilla(25, 750, 580, false, "normal");
        caminoPrincipal[25] = new Casilla(26, 795, 580, true, "especial");
        caminoPrincipal[26] = new Casilla(27, 840, 580, false, "normal");
        caminoPrincipal[27] = new Casilla(28, 885, 580, false, "normal");
        caminoPrincipal[28] = new Casilla(29, 930, 580, false, "normal");
        caminoPrincipal[29] = new Casilla(30, 930, 480, true, "especial");
        caminoPrincipal[30] = new Casilla(31, 930, 380, false, "normal");
        caminoPrincipal[31] = new Casilla(32, 885, 380, false, "normal");
        caminoPrincipal[32] = new Casilla(33, 840, 380, false, "normal");
        caminoPrincipal[33] = new Casilla(34, 795, 380, false, "normal");

        caminoPrincipal[34] = new Casilla(35, 750, 380, false, "normal");
        caminoPrincipal[35] = new Casilla(36, 707, 380, false, "normal");
        caminoPrincipal[36] = new Casilla(37, 664, 380, false, "normal");
        caminoPrincipal[37] = new Casilla(38, 620, 380, false, "normal");
        caminoPrincipal[38] = new Casilla(39, 580, 345, false, "normal");
        caminoPrincipal[39] = new Casilla(40, 580, 298, false, "normal");
        caminoPrincipal[40] = new Casilla(41, 580, 255, false, "normal");
        caminoPrincipal[41] = new Casilla(42, 580, 210, true, "especial");
        caminoPrincipal[42] = new Casilla(43, 580, 165, false, "normal");
        caminoPrincipal[43] = new Casilla(44, 580, 120, false, "normal");
        caminoPrincipal[44] = new Casilla(45, 580, 75, false, "normal");
        caminoPrincipal[45] = new Casilla(46, 580, 30, false, "normal");
        caminoPrincipal[46] = new Casilla(47, 480, 30, true, "especial");
        caminoPrincipal[47] = new Casilla(48, 380, 30, false, "normal");
        caminoPrincipal[48] = new Casilla(49, 380, 75, false, "normal");
        caminoPrincipal[49] = new Casilla(50, 380, 120, false, "normal");
        caminoPrincipal[50] = new Casilla(51, 380, 165, false, "normal");
        caminoPrincipal[51] = new Casilla(52, 380, 210, false, "normal");

        caminoPrincipal[52] = new Casilla(53, 380, 255, false, "normal");
        caminoPrincipal[53] = new Casilla(54, 380, 298, false, "normal");
        caminoPrincipal[54] = new Casilla(55, 380, 345, false, "normal");
        caminoPrincipal[55] = new Casilla(56, 345, 380, false, "normal");
        caminoPrincipal[56] = new Casilla(57, 297, 380, false, "normal");
        caminoPrincipal[57] = new Casilla(58, 254, 380, false, "normal");
        caminoPrincipal[58] = new Casilla(59, 210, 380, true, "especial");
        caminoPrincipal[59] = new Casilla(60, 165, 380, false, "normal");
        caminoPrincipal[60] = new Casilla(61, 122, 380, false, "normal");
        caminoPrincipal[61] = new Casilla(62, 77, 380, false, "normal");
        caminoPrincipal[62] = new Casilla(63, 30, 380, false, "normal");
        caminoPrincipal[63] = new Casilla(64, 30, 480, true, "especial");
        caminoPrincipal[64] = new Casilla(65, 30, 580, false, "normal");
        caminoPrincipal[65] = new Casilla(66, 77, 580, false, "normal");
        caminoPrincipal[66] = new Casilla(67, 122, 580, false, "normal");
        caminoPrincipal[67] = new Casilla(68, 165, 580, false, "normal");
        //Deteste cada segundo de escribir coordenadas
    }

    //Camino Final 
    private void inicializarCaminosFinales() {
        // Color 0 = rojo
        // Color 1 = azul
        // Color 2 = amarillo
        // Color 3 = verde
        caminoFinal[0][0] = new Casilla(101, 77, 480, false, "final");
        caminoFinal[0][1] = new Casilla(102, 122, 480, false, "final");
        caminoFinal[0][2] = new Casilla(103, 165, 480, false, "final");
        caminoFinal[0][3] = new Casilla(104, 210, 480, false, "final");
        caminoFinal[0][4] = new Casilla(105, 254, 480, false, "final");
        caminoFinal[0][5] = new Casilla(106, 297, 480, false, "final");
        caminoFinal[0][6] = new Casilla(107, 345, 480, false, "final");
        caminoFinal[0][7] = new Casilla(108, 415, 480, false, "meta");

        caminoFinal[1][0] = new Casilla(201, 480, 75, false, "final");
        caminoFinal[1][1] = new Casilla(202, 480, 120, false, "final");
        caminoFinal[1][2] = new Casilla(203, 480, 165, false, "final");
        caminoFinal[1][3] = new Casilla(204, 480, 210, false, "final");
        caminoFinal[1][4] = new Casilla(205, 480, 255, false, "final");
        caminoFinal[1][5] = new Casilla(206, 480, 298, false, "final");
        caminoFinal[1][6] = new Casilla(207, 480, 345, false, "final");
        caminoFinal[1][7] = new Casilla(208, 480, 415, false, "meta");

        caminoFinal[2][0] = new Casilla(301, 885, 480, false, "final");
        caminoFinal[2][1] = new Casilla(302, 840, 480, false, "final");
        caminoFinal[2][2] = new Casilla(303, 795, 480, false, "final");
        caminoFinal[2][3] = new Casilla(304, 750, 480, false, "final");
        caminoFinal[2][4] = new Casilla(305, 707, 480, false, "final");
        caminoFinal[2][5] = new Casilla(306, 664, 480, false, "final");
        caminoFinal[2][6] = new Casilla(307, 620, 480, false, "final");
        caminoFinal[2][7] = new Casilla(308, 550, 480, false, "meta");

        caminoFinal[3][0] = new Casilla(401, 480, 885, false, "final");
        caminoFinal[3][1] = new Casilla(402, 480, 840, false, "final");
        caminoFinal[3][2] = new Casilla(403, 480, 795, false, "final");
        caminoFinal[3][3] = new Casilla(404, 480, 750, false, "final");
        caminoFinal[3][4] = new Casilla(405, 480, 707, false, "final");
        caminoFinal[3][5] = new Casilla(406, 480, 663, false, "final");
        caminoFinal[3][6] = new Casilla(407, 480, 615, false, "final");
        caminoFinal[3][7] = new Casilla(408, 480, 545, false, "meta");

        // Asignar color a todas las casillas finales
        for (int color = 0; color < 4; color++) {
            for (int i = 0; i < 8; i++) {
                caminoFinal[color][i].setColor(colores[color]);
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
