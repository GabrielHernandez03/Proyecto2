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
       if (raiz == null) return null;
       NodoBST actual = raiz;
       while (actual.izquierdo != null) {
           actual = actual.izquierdo; // El máximo está en el extremo izquierdo
       }
       return actual.fragmento;
   }
      public FragmentoADN getMenosFrecuente() {
       if (raiz == null) return null;
       NodoBST actual = raiz;
       while (actual.derecho != null) {
           actual = actual.derecho; // El mínimo está en el extremo derecho
       }
       return actual.fragmento;
   }
      
   
}

