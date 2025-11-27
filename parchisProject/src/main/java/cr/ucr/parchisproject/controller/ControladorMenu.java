/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.controller;

import cr.ucr.parchisproject.view.GUIMenu;
import cr.ucr.parchisproject.view.MenuPanel;
import cr.ucr.parchisproject.view.GUITablero;
import cr.ucr.parchisproject.model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Xpc
 */
public class ControladorMenu implements ActionListener{
    
    private GUIMenu gUIMenu;
    private MenuPanel panel;

    public ControladorMenu(GUIMenu ventana) {
        this.gUIMenu = ventana;
        this.panel = ventana.getMenuPanel();
        this.panel.listen(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jugar":
                iniciarJuego();
                break;

            case "Historial":
                JOptionPane.showMessageDialog(gUIMenu,
                        "Historial aún no implementado.",
                        "Historial",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Instrucciones":
                JOptionPane.showMessageDialog(gUIMenu,
                        """
                        Instrucciones del juego Parchís Pokémon:
                        
                        • Tira el dado para mover tu ficha.
                        • Si caes en una casilla especial, deberás responder una pregunta.
                        • Las respuestas correctas dan puntos, las incorrectas restan.
                        • Lleva tus fichas a la meta recorriendo el camino final según color.
                        """,
                        "Instrucciones",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Creditos":
                JOptionPane.showMessageDialog(gUIMenu,
                        "Desarrollado por: Hugo Carranza\nUniversidad de Costa Rica",
                        "Créditos",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    
    //Inicia la pantalla de juego, creando jugadores, tablero y controlador.
    private void iniciarJuego() {

        String nombre = panel.getNombreJugador();

        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(gUIMenu,
                    "Debe ingresar un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener color del panel
        String colorElegido = panel.getColorSeleccionado();
        if (colorElegido == null) {
            JOptionPane.showMessageDialog(gUIMenu,
                    "Debe elegir un color.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Color del rival
        String colorRival = obtenerColorRival(colorElegido);

        // Crear jugadores
        Jugador jugador1 = new Jugador(nombre, colorElegido);
        Jugador jugador2 = new Jugador("Rival", colorRival);

        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);

        // Crear ventana del juego
        GUITablero guiTablero = new GUITablero();

        // Instanciar Tablero y controladores
        Tablero tablero = new Tablero();
        Dado dado = new Dado();
        BancoPreguntas banco = new BancoPreguntas();
        Temporizador temporizador = new Temporizador();

        // Crear controlador del juego
        new ControladorJuego(guiTablero, tablero, listaJugadores, dado, banco, temporizador);

        // Cerrar menú e iniciar juego
        guiTablero.setVisible(true);
        gUIMenu.dispose();
    }

    //Devuelve el color rival dependiendo del escogido
    private String obtenerColorRival(String color) {
        return switch (color.toLowerCase()) {
            case "rojo" -> "amarillo";
            case "azul" -> "verde";
            case "amarillo" -> "rojo";
            default      -> "azul";
        };
    }
    
}
