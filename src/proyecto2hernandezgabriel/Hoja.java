/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */

    
public class Hoja {
        FragmentoADN fragmento;
        Hoja izquierdo;
        Hoja derecho;

        public Hoja(FragmentoADN fragmento) {
            this.fragmento = fragmento;
            this.izquierdo = null;
            this.derecho = null;
        }
    

}
