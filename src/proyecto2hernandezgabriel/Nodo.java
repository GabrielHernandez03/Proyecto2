/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */
public class Nodo {

    /**
     * @return the dato
     */
    public FragmentoADN getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(FragmentoADN dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    private FragmentoADN dato; 
    private Nodo siguiente;
    public Nodo(FragmentoADN dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
