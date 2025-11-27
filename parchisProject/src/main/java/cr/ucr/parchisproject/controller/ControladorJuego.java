/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ucr.parchisproject.controller;

import cr.ucr.parchisproject.model.*;
import cr.ucr.parchisproject.view.GUITablero;
import cr.ucr.parchisproject.view.PanelControles;
import cr.ucr.parchisproject.view.PanelTablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Xpc
 */
public class ControladorJuego implements ActionListener {

    private GUITablero gUITablero;
    private PanelTablero panelTablero;
    private PanelControles panelControles;

    private Tablero tablero;
    private Dado dado;
    private BancoPreguntas bancoPreguntas;
    private Temporizador temporizador;
    private Timer timerSwing;//Refresca cronometro en la cista
    private RecursoSonido sonido;

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private ArrayList<Jugador> listaJugadores;

    public ControladorJuego(GUITablero gUITablero, Tablero tablero, ArrayList<Jugador> jugadores, Dado dado, BancoPreguntas banco, Temporizador temporizador) {

        // Vista
        this.gUITablero = gUITablero;
        this.panelTablero = gUITablero.getPanelTablero();
        this.panelControles = gUITablero.getPanelControles();

        // Modelos recibidos (NO se vuelven a crear)
        this.tablero = tablero;
        this.dado = dado;
        this.bancoPreguntas = banco;
        this.temporizador = temporizador;

        // Jugadores recibidos del menú
        this.listaJugadores = jugadores;
        this.jugador1 = jugadores.get(0);
        this.jugador2 = jugadores.get(1);

        // Turno inicial
        jugador1.activarTurno();
        jugadorActual = jugador1;

        // Pasar jugadores a los paneles
        panelTablero.setJugadores(listaJugadores);
        panelControles.setJugadores(listaJugadores);
        panelControles.actualizarPuntajes();

        // El ActionListerine XD
        panelControles.listen(this);

        // Temporizador
        temporizador.iniciar();
        iniciarTimerSwing();

        // Inicializar música del juego
        sonido = new RecursoSonido();
        sonido.cargarYReproducir("/audio/PokemonSoundParchis.wav", true);

        // Actualizar cronómetro
        panelControles.actualizarCronometro(temporizador.getTiempoFormateado());

    }

    // Inicializa un Timer de Swing que cada segundo pide el tiempo formateado al modelo Temporizador y actualiza el JLabel de tiempo en PanelControles
    private void iniciarTimerSwing() {
        timerSwing = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelControles.actualizarCronometro(temporizador.getTiempoFormateado());
            }
        });
        timerSwing.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Dado":
                manejarLanzamientoDado();
                break;

            case "Reiniciar":
                reiniciarPartida();
                break;

            case "Salir":
                salirDelJuego();
                break;

            default:
                break;
        }
    }

    // Lógica de lanzar dado y mover ficha
    private void manejarLanzamientoDado() {

        if (todosEnMeta(jugadorActual)) {
            JOptionPane.showMessageDialog(gUITablero, jugadorActual.getNombre() + " ya ganó.");
            return;
        }

        int resultado = dado.lanzar();
        panelControles.actualizarDado(resultado);

        Ficha ficha = obtenerFichaMovible(jugadorActual);
        if (ficha == null) {
            cambiarTurno();
            return;
        }

        // Salir de casa con un 5
        if (ficha.isEnCasa()) {
            if (resultado == 5) {
                int salida = obtenerPosicionSalida(jugadorActual.getColor());
                ficha.salirDeCasa(salida);
                actualizarCoordenadasFicha(ficha);
                panelTablero.repaint();
            } else {
                JOptionPane.showMessageDialog(gUITablero, "Necesitas un 5 para salir de casa.");
            }
            cambiarTurno();
            return;
        }

        // Casos especiales de movimiento(normal, loop y entrada al camino final
        moverFichaConReglas(ficha, resultado);

        // Colosiones
        verificarColision(ficha);

        panelTablero.repaint();

        // Pregunta en casillas especiales
        if (!ficha.isEnCaminoFinal() && !ficha.isEnMeta()) {
            verificarCasillaEspecial(ficha);
        }

        // Gana
        if (todosEnMeta(jugadorActual)) {
            JOptionPane.showMessageDialog(gUITablero,
                    "¡" + jugadorActual.getNombre() + " ha ganado!");
            temporizador.detener();
            timerSwing.stop();
            return;
        }

        cambiarTurno();
    }

    //Moviento con casos especiales
    private void moverFichaConReglas(Ficha ficha, int pasos) {

        // Si ya está dentro del camino final
        if (ficha.isEnCaminoFinal()) {
            ficha.mover(pasos);
            actualizarCoordenadasFicha(ficha);
            return;
        }

        int posActual = ficha.getPosicionActual();
        int nuevaPos = posActual + pasos;

        // Movimiento circular
        if (nuevaPos > 68) {
            nuevaPos -= 68;
        }

        int entradaColor = ficha.getEntradaFinal();

        // Detectar si pasa por la entrada final (aunque la salte)
        if (cruzaEntrada(posActual, pasos, entradaColor)) {
            ficha.setPosicionActual(entradaColor);
            ficha.mover(0); // activa caminoFinal y posicionFinal=0
            actualizarCoordenadasFicha(ficha);
            return;
        }

        ficha.setPosicionActual(nuevaPos);
        actualizarCoordenadasFicha(ficha);
    }

    // Detecta si se pasó por la entrada final aunque no caiga exacto
    private boolean cruzaEntrada(int pos, int pasos, int entrada) {
        for (int i = 1; i <= pasos; i++) {
            pos++;
            if (pos > 68) {
                pos = 1;
            }
            if (pos == entrada) {
                return true;
            }
        }
        return false;
    }

    //Colisiones
    private void verificarColision(Ficha fichaMovimiento) {
        //Tuve que agregar este if por un error cuando las fichas llegan a la meta
        // Si la ficha que se mueve está en meta o en camino final, no hacemos colisión
        if (fichaMovimiento.isEnMeta() || fichaMovimiento.isEnCaminoFinal()) {
            return;
        }

        int x = fichaMovimiento.getX();
        int y = fichaMovimiento.getY();

        for (Jugador jugador : listaJugadores) {
            for (Ficha ficha : jugador.getFichas()) {

                if (ficha == fichaMovimiento) {
                    continue;
                }

                // Si la otra ficha está en meta o en camino final, no se la puede comer
                if (ficha.isEnMeta() || ficha.isEnCaminoFinal()) {
                    continue;
                }

                boolean colision
                        = Math.abs(ficha.getX() - x) < 10
                        && Math.abs(ficha.getY() - y) < 10;

                if (colision) {
                    ficha.volverACasa();
                    actualizarCoordenadasFicha(ficha);
                    JOptionPane.showMessageDialog(gUITablero,
                            "¡Colisión! Una ficha vuelve a casa.");
                }
            }
        }
    }

    // Devuelve la primera ficha que todavía pueda moverse (no en meta)
    private Ficha obtenerFichaMovible(Jugador jugador) {
        for (Ficha f : jugador.getFichas()) {
            if (!f.isEnMeta()) {
                return f;
            }
        }
        return null;
    }

    // Posición de salida según color del jugador
    private int obtenerPosicionSalida(String color) {
        // Estas posiciones deben coincidir con tu caminoPrincipal
        if (color.equalsIgnoreCase("rojo")) {
            return 1;   // casilla 1
        } else if (color.equalsIgnoreCase("verde")) {
            return 18;  // casilla 18
        } else if (color.equalsIgnoreCase("amarillo")) {
            return 34;  // casilla 34
        } else if (color.equalsIgnoreCase("azul")) {
            return 52;  // casilla 52
        }
        return 1;
    }

    // Actualiza las coordenadas (x,y) de una ficha según su estado (camino principal o final)
    private void actualizarCoordenadasFicha(Ficha ficha) {
        // Si está en camino final, usamos caminoFinal[colorIndex][getPosicionFinal]
        if (ficha.isEnCaminoFinal()) {
            int colorIndex = colorAIndice(ficha.getColor());
            Casilla casillaFinal = tablero.obtenerCasillaFinal(colorIndex, ficha.getPosicionFinal());
            ficha.actualizarCoordenadas(casillaFinal.getX(), casillaFinal.getY());
            return;
        }

        // Si está en camino principal (1..68)
        Casilla casillaPrincipal = tablero.obtenerCasillaPrincipal(ficha.getPosicionActual());
        ficha.actualizarCoordenadas(casillaPrincipal.getX(), casillaPrincipal.getY());
    }

    // Convierte color a índice de caminoFinal (0=rojo, 1=azul, 2=amarillo, 3=verde)
    private int colorAIndice(String color) {
        if (color.equalsIgnoreCase("rojo")) {
            return 0;
        } else if (color.equalsIgnoreCase("azul")) {
            return 1;
        } else if (color.equalsIgnoreCase("amarillo")) {
            return 2;
        } else if (color.equalsIgnoreCase("verde")) {
            return 3;
        }
        return 0;
    }

    // Verifica si la casilla principal de la ficha es especial y lanza una pregunta si lo es
    private void verificarCasillaEspecial(Ficha ficha) {
        Casilla casilla = tablero.obtenerCasillaPrincipal(ficha.getPosicionActual());
        if (casilla.isEspecial()) {
            // Usar "facil" o "dificil"
            Pregunta pregunta = bancoPreguntas.obtenerPreguntaAleatoria("dificil");
            if (pregunta == null) {
                return;
            }

            int respuesta = JOptionPane.showConfirmDialog(gUITablero, pregunta.getTexto(), "Pregunta (" + pregunta.getDificultad() + ")", JOptionPane.YES_NO_OPTION);

            boolean respuestaJugador = (respuesta == JOptionPane.YES_OPTION);

            if (pregunta.esCorrecta(respuestaJugador)) {
                jugadorActual.registrarRespuestaCorrecta();
                JOptionPane.showMessageDialog(gUITablero, "¡Respuesta correcta! +1 punto.");
            } else {
                jugadorActual.registrarRespuestaIncorrecta();
                JOptionPane.showMessageDialog(gUITablero, "Respuesta incorrecta. -1 punto.");
            }

            // Actualizar puntajes en el panel
            panelControles.actualizarPuntajes();
        }
    }

    // Cambia el turno entre jugador1 y jugador2
    private void cambiarTurno() {
        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
    }

    // Reinicia por completo la partida (sin cerrar ventana)
    private void reiniciarPartida() {
        JOptionPane.showMessageDialog(gUITablero, "Reiniciar no implementado aún.");
    }

    // Cierra el juego de forma controlada
    private void salirDelJuego() {
        int opcion = JOptionPane.showConfirmDialog(gUITablero,
                "¿Deseas salir del juego?",
                "Salir",
                JOptionPane.YES_NO_OPTION
        );

        if (opcion == JOptionPane.YES_OPTION) {
            if (sonido != null) sonido.detener();
            temporizador.detener();
            if (timerSwing != null) {
                timerSwing.stop();
            }
            System.exit(0);
        }
    }

    // Verifica si todas las fichas del jugador están en meta
    private boolean todosEnMeta(Jugador jugador) {
        ArrayList<Ficha> fichas = jugador.getFichas();
        for (int i = 0; i < fichas.size(); i++) {
            if (!fichas.get(i).isEnMeta()) {
                return false;
            }
        }
        return true;
    }

}
