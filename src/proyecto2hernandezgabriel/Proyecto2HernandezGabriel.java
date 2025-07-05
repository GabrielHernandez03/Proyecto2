/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2hernandezgabriel;

import proyecto2hernandezgabriel.Ventanas.MenuPrincipal;

/**
 *
 * @author gabriel
 */
public class Proyecto2HernandezGabriel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here, 
        MenuPrincipal m = new MenuPrincipal(new ArbolBB(), new TablaHash(50));
        m.setVisible(true);
    }
    
}
