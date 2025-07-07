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
 * Clase que implementa un árbol binario de búsqueda para Fragmentos de ADN
 */
public class ArbolBB {
    /** Nodo raíz del árbol */
    private Hoja raiz;

    /**
     * Constructor que crea un árbol vacío
     */
    public ArbolBB() {
        this.raiz = null;
    }

    /**
     * Inserta un nuevo fragmento en el árbol
     * @param fragmento Fragmento de ADN a insertar
     */
    public void insertar(FragmentoADN fragmento) {
        raiz = insertarRec(raiz, fragmento);
    }

    /**
     * Método recursivo para insertar un fragmento
     * @param nodo Nodo actual
     * @param fragmento Fragmento a insertar
     * @return Nodo modificado
     */
    private Hoja insertarRec(Hoja nodo, FragmentoADN fragmento) {
        if (nodo == null) return new Hoja(fragmento);
        
        if (fragmento.getFrec() >= nodo.fragmento.getFrec()) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, fragmento);
        } else {
            nodo.derecho = insertarRec(nodo.derecho, fragmento);
        }
        return nodo;
    }

    /**
     * Obtiene el fragmento de mayor frecuencia
     * @return Fragmento más frecuente o null si árbol vacío
     */
    public FragmentoADN getMasFrecuente() {
        if (raiz == null) return null;
        
        Hoja actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo; 
        }
        return actual.fragmento;
    }

    /**
     * Obtiene el fragmento de menor frecuencia
     * @return Fragmento menos frecuente o null si árbol vacío
     */
    public FragmentoADN getMenosFrecuente() {
        if (raiz == null) return null;
        
        Hoja actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.fragmento;
    }

    /**
     * Obtiene todos los fragmentos en orden descendente de frecuencia
     * @return Lista ordenada de fragmentos
     */
    public Lista getFragmentosOrdenados() {
        Lista listaOrdenada = new Lista();
        inOrder(raiz, listaOrdenada);
        return listaOrdenada;
    }

    /**
     * Recorrido in-order modificado para orden descendente
     * @param nodo Nodo actual
     * @param lista Lista donde se almacenan los fragmentos
     */
    private void inOrder(Hoja nodo, Lista lista) {
        if (nodo != null) {
            inOrder(nodo.derecho, lista);
            lista.añadir(nodo.fragmento);
            inOrder(nodo.izquierdo, lista);
        }
    }

    /**
     * Busca un fragmento específico por frecuencia y nombre
     * @param frecuencia Frecuencia objetivo
     * @param nombre Nombre del fragmento
     * @return Fragmento encontrado o null
     */
    public FragmentoADN buscar(int frecuencia, String nombre) {
        return buscarRec(raiz, frecuencia, nombre);
    }

    /**
     * Búsqueda recursiva en el árbol
     * @param nodo Nodo actual
     * @param frecuencia Frecuencia a buscar
     * @param nombre Nombre del fragmento
     * @return Fragmento encontrado o null
     */
    private FragmentoADN buscarRec(Hoja nodo, int frecuencia, String nombre) {
        if (nodo == null) return null;
        
        if (nodo.fragmento.getFrec() == frecuencia && nodo.fragmento.getFrag().equals(nombre)) {
            return nodo.fragmento;
        }
        
        if (frecuencia >= nodo.fragmento.getFrec()) {
            return buscarRec(nodo.izquierdo, frecuencia, nombre);
        } else {
            return buscarRec(nodo.derecho, frecuencia, nombre);
        }
    }
}
