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
public class Maquina extends Jugador {

    
    public Maquina() {
        super.nombre = "CPU";
    }
    

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
