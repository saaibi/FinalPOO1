/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpoo1;

/**
 *
 * @author DAVID
 */
public class Dado {

    int valor;

    public Dado() {
    }

    public Dado(int valor) {
        this.valor = valor;
    }

    public void pintarDado() {
        switch (valor) {
            case 1:
                System.out.println("-----\n"
                        + "|   |\n"
                        + "| o |\n"
                        + "|   |\n"
                        + "-----");
                break;
            case 2:
                System.out.println("-----\n"
                        + "|o  |\n"
                        + "|   |\n"
                        + "|  o|\n"
                        + "-----");
                break;
            case 3:
                System.out.println("-----\n"
                        + "|o  |\n"
                        + "| o |\n"
                        + "|  o|\n"
                        + "-----");
                break;
            case 4:
                System.out.println("-----\n"
                        + "|o o|\n"
                        + "|   |\n"
                        + "|o o|\n"
                        + "-----");
                break;
            case 5:
                System.out.println("-----\n"
                        + "|o o|\n"
                        + "| o |\n"
                        + "|o o|\n"
                        + "-----");
                break;
            case 6:
                System.out.println("-----\n"
                        + "|o o|\n"
                        + "|o o|\n"
                        + "|o o|\n"
                        + "-----");
                break;
        }

    }

}
