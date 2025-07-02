/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */
public class Lista {
    private Nodo primero;

    public Lista() {
        this.primero = null;
    }

    public void añadir(FragmentoADN nuevo) {
        Nodo nuevoNodo = new Nodo(nuevo);
        if (primero == null) {
            primero = nuevoNodo; 
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public boolean buscar(FragmentoADN frag) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.dato.equals(frag)) {
                return true; 
            }
            actual = actual.siguiente;
        }
        return false;
    }
}

