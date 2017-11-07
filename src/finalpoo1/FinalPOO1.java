/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpoo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author DAVID
 */
public class FinalPOO1 {

    /**
     * @param args the command line arguments
     */
    static Tablero tablero = new Tablero();
    static boolean inicioP1 = false;
    static Scanner lector = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Random rnd = new Random();
    static Jugador p1 = new Jugador();
    static Jugador p2;
    static Maquina cpu = new Maquina();
    static boolean victoria = false, modoJuego = false;

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        menu();
    }

    public static void menu() throws IOException {
        p1.namePlayer();
        System.out.println("***********************************************");
        p1.seleccionarColor();
        System.out.println("***********************************************");
        //jugador2();
        modoJuego();
        System.out.println("***********************************************");
        tablero.mostrar();
        System.out.println("***********************************************");
        while (!victoria) {
            if (modoJuego == true) {
                juegoPP(modoJuego);
            } else {
                juegoNormal(modoJuego);
            }

        }
        System.out.println("***********************************************");

    }

    public static void modoJuego() throws IOException {
        System.out.println("Seleccione el tipo de Juego\n1. Juego normal\n2. Juego Pieadra a Piedra");
        int rpta = lector.nextInt();
        switch (rpta) {
            case 1:
                modoJuego = false;
                jugador2();
                juegoNormal(modoJuego);
                break;
            case 2:
                modoJuego = true;
                newJuegador();
                juegoPP(modoJuego);
                break;
            default:
                break;
        }
    }

    public static void jugador2() throws IOException {
        System.out.println("Quien va a ser tu rival?\n1. Máquina\n2. Humanos");
        int rpta = lector.nextInt();
        switch (rpta) {
            case 1:
                System.out.println("Su oponente será la máquina");
                p2 = cpu;
                rifaSaque(p1, cpu);
                break;
            case 2:
                newJuegador();
                break;
        }
    }

    private static void newJuegador() {
        p2 = new Jugador();
        System.out.println("Nombre Jugador 2");
        p2.namePlayer();
        p2.seleccionarColor();
        rifaSaque(p1, p2);
    }

    public static void rifaSaque(Jugador p1, Jugador p2) {
        int numP1 = rifarTurno(p1);
        int numP2 = rifarTurno(p2);
        if (numP1 != numP2) {
            if (numP1 > numP2) {
                System.out.println("El primer turno es para " + p1.nombre);
                inicioP1 = true;
            } else {
                System.out.println("El primer turno es para " + p2.nombre);
            }
        } else {
            rifaSaque(p1, p2);
        }
    }

    public static void juegoPP(boolean modoJuego) {
        if (inicioP1) {
            System.out.println("***********************************************");
            System.out.println("Turno " + p1.nombre);
            p1.menuTurno(modoJuego);
            validarFichasCarcel(p1, p2);
            matarFicha(p1, p2);
            System.out.println("-----------------------------------------------");
            System.out.println("Turno " + p2.nombre);
            p2.menuTurno(modoJuego);
            validarFichasCarcel(p2, p1);
            matarFicha(p1, p2);
            System.out.println("***********************************************");
            condicionVictoria(p1);
            condicionVictoria(p2);
        } else {
            System.out.println("***********************************************");
            System.out.println("Turno " + p2.nombre);
            p2.menuTurno(modoJuego);
            validarFichasCarcel(p2, p1);
            matarFicha(p1, p2);
            System.out.println("-----------------------------------------------");
            System.out.println("Turno " + p1.nombre);
            p1.menuTurno(modoJuego);
            validarFichasCarcel(p1, p2);
            matarFicha(p1, p2);
            System.out.println("***********************************************");
            condicionVictoria(p1);
            condicionVictoria(p2);
        }
    }

    public static void juegoNormal(boolean modoJuego) {
        if (inicioP1) {
            System.out.println("***********************************************");
            System.out.println("Turno " + p1.nombre);
            p1.menuTurno(modoJuego);
            validarFichasCarcel(p1, p2);
            matarFicha(p1, p2);
            System.out.println("-----------------------------------------------");
            System.out.println("Turno " + p2.nombre);
            p2.menuTurno(modoJuego);
            validarFichasCarcel(p2, p1);
            matarFicha(p1, p2);
            System.out.println("***********************************************");
            condicionVictoria(p1);
            condicionVictoria(p2);
        } else {
            System.out.println("***********************************************");
            System.out.println("Turno " + p2.nombre);
            p2.menuTurno(modoJuego);
            validarFichasCarcel(p2, p1);
            matarFicha(p1, p2);
            System.out.println("-----------------------------------------------");
            System.out.println("Turno " + p1.nombre);
            p1.menuTurno(modoJuego);
            validarFichasCarcel(p1, p2);
            matarFicha(p1, p2);
            System.out.println("***********************************************");
            condicionVictoria(p1);
            condicionVictoria(p2);
        }
    }

    private static void validarFichasCarcel(Jugador p1, Jugador p2) {
        if (p1.ficha1.enJuego && p1.ficha2.enJuego && p1.ficha3.enJuego && p1.ficha4.enJuego) {
            System.out.println("");
        } else {
            matarFicha(p1, p2);
        }
    }

    private static void condicionVictoria(Jugador p1) {
        if (p1.ficha1.corona && p1.ficha2.corona && p1.ficha2.corona && p1.ficha2.corona) {
            victoria = true;
            System.out.println(p1.nombre + " coronó todas sus fichas, FELICIDADES!!");
        }
    }

    private static void matarFicha(Jugador p1, Jugador p2) {
        p1.matarFicha(p2);
    }

    public static int rifarTurno(Jugador player) {
        Dado dadorifa = new Dado();
        Dado dadorifa2 = new Dado();
        System.out.println("Se va a rifar el turno para " + player.nombre);
        dadorifa.valor = rnd.nextInt(6) + 1;
        dadorifa2.valor = rnd.nextInt(6) + 1;
        System.out.println("Los dados se tiraron:");
        dadorifa.pintarDado();
        dadorifa2.pintarDado();
        int sumadados = dadorifa.valor + dadorifa2.valor;
        return sumadados;
    }

}
