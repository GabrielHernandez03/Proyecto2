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
        if (fragmento.frec > nodo.fragmento.frec) {
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
            inOrder(nodo.izquierdo, lista); 
            FragmentoADN fragmento = nodo.fragmento;
            lista.añadir(fragmento); 
            inOrder(nodo.derecho, lista);
        }
    }

}
