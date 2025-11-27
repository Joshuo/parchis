/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cr.ucr.parchisproject;

import cr.ucr.parchisproject.view.GUIMenu;
import cr.ucr.parchisproject.controller.ControladorMenu;

/**
 *
 * @author Xpc
 */
public class ParchisProject {

    public static void main(String[] args) {
        
        // Iniciar interfaz gráfica en el hilo de eventos
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                GUIMenu menu = new GUIMenu();
                ControladorMenu controlador = new ControladorMenu(menu);
                menu.setVisible(true);
            }
        });
    }
}
