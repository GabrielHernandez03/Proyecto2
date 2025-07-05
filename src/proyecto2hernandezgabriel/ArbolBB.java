/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */
public class ArbolBB {

    private Hoja raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public void insertar(FragmentoADN fragmento) {
        raiz = insertarRec(raiz, fragmento);
    }

    private Hoja insertarRec(Hoja nodo, FragmentoADN fragmento) {
        if (nodo == null) {
            return new Hoja(fragmento);
        }
        if (fragmento.getFrec() >= nodo.fragmento.getFrec()) {
            nodo.izquierdo = insertarRec(nodo.izquierdo, fragmento);
        } else {
            nodo.derecho = insertarRec(nodo.derecho, fragmento);
        }
        return nodo;
    }

    public FragmentoADN getMasFrecuente() {
        if (raiz == null) {
            return null;
        }
        Hoja actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo; 
        }
        return actual.fragmento;
    }

    public FragmentoADN getMenosFrecuente() {
        if (raiz == null) {
            return null;
        }
        Hoja actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.fragmento;
    }

    public Lista getFragmentosOrdenados() {
        Lista listaOrdenada = new Lista();
        inOrder(raiz, listaOrdenada);
        return listaOrdenada;
    }

private void inOrder(Hoja nodo, Lista lista) {
    if (nodo != null) {
        inOrder(nodo.derecho, lista);  
        lista.añadir(nodo.fragmento); 
        inOrder(nodo.izquierdo, lista); 
    }
}

    
    public FragmentoADN buscar(int frecuencia, String nombre) {
    return buscarRec(raiz, frecuencia, nombre);
}

private FragmentoADN buscarRec(Hoja nodo, int frecuencia, String nombre) {
    if (nodo == null) {
        return null; 
    }

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
