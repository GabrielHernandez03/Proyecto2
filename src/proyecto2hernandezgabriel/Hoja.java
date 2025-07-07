/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */

    
/**
 * Clase que representa un nodo hoja en un árbol binario
 */
public class Hoja {
    /** Fragmento de ADN almacenado en el nodo */
    public FragmentoADN fragmento;
    
    /** Referencia al hijo izquierdo */
    public Hoja izquierdo;
    
    /** Referencia al hijo derecho */
    public Hoja derecho;

    /**
     * Constructor que crea una nueva hoja
     * @param fragmento Fragmento de ADN a almacenar
     */
    public Hoja(FragmentoADN fragmento) {
        this.fragmento = fragmento;
        this.izquierdo = null;
        this.derecho = null;
    }
}

