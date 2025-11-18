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

        // Conectar botones del panel a este controlador
        this.panel.listen(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Jugar":
                //iniciarJuego();
                break;

            case "Historial":
                JOptionPane.showMessageDialog(gUIMenu,
                        "Historial aún no implementado.",
                        "Historial",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Instrucciones":
                JOptionPane.showMessageDialog(gUIMenu,
                        "Instrucciones:\n\n" +
                        "1. El jugador tira un dado.\n" +
                        "2. Si cae en casilla especial, se pregunta.\n" +
                        "3. Se avanza hacia la meta según el color.\n",
                        "Instrucciones",
                        JOptionPane.INFORMATION_MESSAGE);
                break;

            case "Creditos":
                JOptionPane.showMessageDialog(gUIMenu,
                        "Mira mami, estoy en los creditos\nDesarrollado por: Hugo Carranza",
                        "Créditos",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    private void iniciarJuego() {

        String nombre = panel.getNombreJugador();

        if (nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(gUIMenu,
                    "Debe ingresar un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    /*
    private String obtenerColorRival(String color) {
        if (color.equalsIgnoreCase("Rojo")) return "Azul";
        if (color.equalsIgnoreCase("Azul")) return "Rojo";
        if (color.equalsIgnoreCase("Amarillo")) return "Verde";
        return "Amarillo";
    }
    */
}
