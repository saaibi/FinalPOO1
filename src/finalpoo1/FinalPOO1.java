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
    static Scanner lector = new Scanner(System.in);
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Dado dado1 = new Dado();
    static Dado dado2 = new Dado();
    static Random rnd = new Random();
    static Jugador p1 = new Jugador();
    static Jugador p2;
    static Jugador p3;
    static Jugador p4;
    static Maquina cpu = new Maquina();
    static String[] colores = {"Azul", "Verde", "Amarillo", "Rojo"};

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        menu();

    }

    public static void menu() throws IOException {
        namePlayer(p1);
        System.out.println("Seleccione el tipo de Juego\n1. Juego normal\n2. Juego Pieadra a Piedra");
        int rpta = lector.nextInt();
        switch (rpta) {
            case 1:
                juegoNormal();
                jugador2();
                break;
            case 2:
                juegoPP();
                rifarTurno(p1);
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
                if (rifarTurno(p1) > rifarTurno(cpu)) {
                    System.out.println("El primer turno es para " + p1.nombre);
                } else {
                    System.out.println("El primer turno es para " + cpu.nombre);
                }
                break;
            case 2:
                System.out.println("Cuaántos jugadores aparte de usted hay?\n(1-3)");
                int numjug = lector.nextInt();
                switch (numjug) {
                    case 1:
                        p2 = new Jugador();
                        namePlayer(p2);
                        break;
                    case 2:
                        p2 = new Jugador();
                        p3 = new Jugador();
                        namePlayer(p2);
                        namePlayer(p3);
                        break;
                    case 3:
                        p2 = new Jugador();
                        p3 = new Jugador();
                        p4 = new Jugador();
                        namePlayer(p2);
                        namePlayer(p3);
                        namePlayer(p4);
                        break;
                }
                break;
            default:
                break;
        }
    }

    public static void namePlayer(Jugador player) throws IOException {
        System.out.println("Por favor ingrese su nombre:");
        player.nombre = reader.readLine();
    }

    public static void juegoPP() {

    }

    public static void juegoNormal() {

    }

    public static int rifarTurno(Jugador player) {
        Dado dadorifa = new Dado();
        System.out.println("Se va a rifar el turno para " + player.nombre);
        dadorifa.valor = rnd.nextInt(6) + 1;
        dadorifa.pintarDado();
        return dadorifa.valor;
    }

    public static void seleccionarColor(Jugador player) throws IOException {
        String color;
        System.out.println(player.nombre + " selecionnee un color:\n1. Amarillo\n2. Rojo\n3. Azul\n4. Verde");
        int colorSelecionado = reader.read();
        switch (colorSelecionado) {
            case 1:
                color = "Amarillo";
                colorPicked(color, player);
                break;
            case 2:
                color = "Rojo";
                colorPicked(color, player);
                break;
            case 3:
                color = "Azul";
                colorPicked(color, player);

                break;
            case 4:
                color = "Verde";
                colorPicked(color, player);

                break;
        }
    }

    public static void colorPicked(String color, Jugador player) {
        for (String colore : colores) {
            if (color.equalsIgnoreCase(colore)) {
                colore = "X";
            }
        }
        player.color = color;
    }

}
