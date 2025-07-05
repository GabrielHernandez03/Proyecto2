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
    private int tam;
    public Lista() {
        this.primero = null;
        tam = 0;
    }

    public void añadir(FragmentoADN nuevo) {
        Nodo nuevoNodo = new Nodo(nuevo);
        if (primero == null) {
            primero = nuevoNodo; 
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tam += 1;
    }

    public boolean buscar(FragmentoADN frag) {
        Nodo actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(frag)) {
                return true; 
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
    
    
    public String[] obtenerNombres() {
    Nodo actual = primero;
    String[] nombres = new String[tam];
    int indice = 0;
    while (actual != null) {
        nombres[indice] = actual.getDato().getFrag() + " (" + actual.getDato().getFrec() + ")";
        indice++;
        actual = actual.getSiguiente();
    }

    return nombres;
}

    
    
}

