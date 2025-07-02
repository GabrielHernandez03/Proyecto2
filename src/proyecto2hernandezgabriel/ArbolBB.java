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
   
}

