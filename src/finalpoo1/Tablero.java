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
 * @author avalencia
 */
public class Tablero {

    private final String[][] matrizParques = new String[24][4];

    private final String fichaVerde = "♙";
    private final String fichaRoja = "♔";
    private final String fichaAzul = "♘";
    private final String fichaAmarilla = "♗";

    private final String FONDO_AMARILLO = "\u001B[43m";//FONDO AMARILLO
    private final String FONDO_ROJO = "\u001B[41m";//FONDO ROJO        
    private final String FONDO_VERDE = "\u001B[42m";//FONDO VERDE        
    private final String FONDO_AZUL = "\u001B[44m";//FONDO AZUL
    private final String FONDO_BLANCO = "\u001B[47m";//FONDO BLANCO
    private final String FONDO_NEGRO = "\u001B[40m";//FONDO NEGRO

    private final String LETRA_BLANCA = "\u001B[37m";//LETRA BLANCA
    private final String LETRA_AZUL = "\u001B[34m";//LETRA AZUL
    private final String LETRA_VERDE = "\u001B[32m";//LETRA VERDE
    private final String LETRA_ROJA = "\u001B[31m";//LETRA ROJA
    private final String LETRA_AMARILLA = "\u001B[33m";//LETRA AMARILLA

    
    String[][] colores = {{"Amarillo", ""}, {"Rojo", ""}, {"Verde", ""}, {"Azul", ""}};

    String BORRAR = "\u001B[0m"; //borrar letra y fondo

    public Tablero() {
    }

    public void inicializar() {

        String fondo = FONDO_AMARILLO;

        for (int i = 0; i < matrizParques.length; i++) {

            for (int j = 0; j < matrizParques[i].length; j++) {

                switch (j) {
                    case 0:
                        fondo = FONDO_AMARILLO;
                        break;
                    case 1:
                        fondo = FONDO_ROJO;
                        break;
                    case 2:
                        fondo = FONDO_VERDE;
                        break;
                    case 3:
                        fondo = FONDO_AZUL;
                        break;
                    default:
                        break;
                }

                matrizParques[i][j] = fondo + i + "," + j;
            }

        }

        for (String[] matrizParque : matrizParques) {
            for (String matrizParque1 : matrizParque) {
                System.out.print(matrizParque1);
            }
            System.out.println("");
        }
    }

    public void mostrar() {

        String variable10 = "       ";

        System.out.println("");
        String[][] matrizTablero = {{FONDO_BLANCO + "ZA1-CA1" + "  " + FONDO_AMARILLO + "   SEGURO   " + FONDO_AMARILLO, FONDO_BLANCO + "ZR1-CR1" + "  " + FONDO_ROJO + "   SEGURO   ", FONDO_BLANCO + "ZV1-CV1" + "  " + FONDO_VERDE + "   SEGURO   ", FONDO_BLANCO + "ZAZ1-CA1Z" + "  " + FONDO_AZUL + "   SEGURO   "},
        {FONDO_BLANCO + "CA2" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR2" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV2" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ2" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA3" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR3" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV3" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ3" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA4" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR4" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV4" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ4" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA5" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR5" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV5" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ5" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA6" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR6" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV6" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ6" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA7" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR7" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV7" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ7" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "CA8" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "CR8" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "CV8" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "CAZ8" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA2" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR2" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV2" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ2" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA3" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR3" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV3" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ3" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA4" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR4" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV4" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ4" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA5" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR5" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV5" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ5" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "SA-ZA6" + "   " + FONDO_AMARILLO + "   SALIDA   " + FONDO_AMARILLO, FONDO_BLANCO + "SR-ZR6" + "   " + FONDO_ROJO + "   SALIDA   ", FONDO_BLANCO + "SV-ZV6" + "   " + FONDO_VERDE + "   SALIDA   ", FONDO_BLANCO + "SAZ-ZAZ6" + "   " + FONDO_AZUL + "   SALIDA   "},
        {FONDO_BLANCO + "ZA7" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR7" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV7" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ7" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA8" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR8" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV8" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ8" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA9" + "      " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR9" + "      " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV9" + "      " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ9" + "       " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA10" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR10" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV10" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ10" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA11" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR11" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV11" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ11" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA12" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR12" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV12" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ12" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA13" + "     " + FONDO_AMARILLO + "   SEGURO   " + FONDO_AMARILLO, FONDO_BLANCO + "ZR13" + "     " + FONDO_ROJO + "   SEGURO   ", FONDO_BLANCO + "ZV13" + "     " + FONDO_VERDE + "   SEGURO   ", FONDO_BLANCO + "ZAZ13" + "      " + FONDO_AZUL + "   SEGURO   "},
        {FONDO_BLANCO + "ZA14" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR14" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV14" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ14" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA15" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR15" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV15" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ15" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA16" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR16" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV16" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ16" + "      " + FONDO_AZUL + "   " + variable10 + "  "},
        {FONDO_BLANCO + "ZA17" + "     " + FONDO_AMARILLO + "   " + variable10 + "  " + FONDO_AMARILLO, FONDO_BLANCO + "ZR17" + "     " + FONDO_ROJO + "   " + variable10 + "  ", FONDO_BLANCO + "ZV17" + "     " + FONDO_VERDE + "   " + variable10 + "  ", FONDO_BLANCO + "ZAZ17" + "      " + FONDO_AZUL + "   " + variable10 + "  "}};
        for (String[] matrizTablero1 : matrizTablero) {
            for (String matrizTablero11 : matrizTablero1) {
                System.out.print(matrizTablero11);
            }
            System.out.println("");
        }
    }
}
