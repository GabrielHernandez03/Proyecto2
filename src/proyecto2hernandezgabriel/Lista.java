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
 * Clase que implementa una lista enlazada de Fragmentos de ADN
 */
public class Lista {
    /** Primer nodo de la lista */
    private Nodo primero;
    
    /** Tamaño actual de la lista */
    private int tam;

    /**
     * Constructor que crea una lista vacía
     */
    public Lista() {
        this.primero = null;
        tam = 0;
    }

    /**
     * Añade un nuevo fragmento al final de la lista
     * @param nuevo Fragmento de ADN a añadir
     */
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
        tam++;
    }

    /**
     * Verifica si un fragmento existe en la lista
     * @param frag Fragmento a buscar
     * @return true si existe, false si no
     */
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

    /**
     * Obtiene un array con los nombres y frecuencias de los fragmentos
     * @return Array de Strings formateados
     */
    public String[] obtenerNombres() {
        String[] nombres = new String[tam];
        Nodo actual = primero;
        for (int i = 0; actual != null; i++, actual = actual.getSiguiente()) {
            nombres[i] = actual.getDato().getFrag() + " (" + actual.getDato().getFrec() + ")";
        }
        return nombres;
    }
}
