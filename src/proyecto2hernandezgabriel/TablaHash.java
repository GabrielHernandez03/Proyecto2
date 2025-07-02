/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabiel
 */
public class TablaHash {
    private Nodo[] tabla;
    private int capacidad;
    private int tamaño;
    private int colisionesTotales;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Nodo[capacidad];
        this.tamaño = 0;
        this.colisionesTotales = 0;
    }

    private int hash(String fragmento) {
        if (fragmento.length() != 3) {
            throw new IllegalArgumentException("Los fragmentos deben tener 3 nucleótidos");
        }
        
        int hash = 0;
        for (int i = 0; i < 3; i++) {
            char c = fragmento.charAt(i);
            int valor = 0;
            switch (c) {
                case 'A': valor = 0; break;
                case 'C': valor = 1; break;
                case 'T': valor = 2; break;
                case 'G': valor = 3; break;
                default: throw new IllegalArgumentException("Nucleótido inválido: " + c);
            }
            hash = (hash << 2) | valor; 
        }
        return Math.abs(hash) % capacidad;
    }

    public void añadir(String fragmento, int ubicacion) {
        int index = hash(fragmento);
        Nodo actual = tabla[index];
        boolean encontrado = false;

        while (actual != null) {
            FragmentoADN f = (FragmentoADN) actual.dato;
            if (f.frag.equals(fragmento)) {
                f.frec++;
                f.ubi[f.frec - 1] = ubicacion;
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        }

        if (!encontrado) {
            FragmentoADN nuevo = new FragmentoADN(fragmento);
            nuevo.ubi[0] = ubicacion;
            nuevo.frec = 1;
            Nodo nuevoNodo = new Nodo(nuevo);
            if (tabla[index] != null) {
                colisionesTotales++; 
                nuevoNodo.siguiente = tabla[index];
            }
            tabla[index] = nuevoNodo;
            tamaño++;
        }
    }

    public FragmentoADN buscar(String fragmento) {
        int index = hash(fragmento);
        Nodo actual = tabla[index];
        
        while (actual != null) {
            FragmentoADN f = (FragmentoADN) actual.dato;
            if (f.frag.equals(fragmento)) {
                return f;
            }
            actual = actual.siguiente;
        }
        return null;
    }

public String[] reporteColisiones() {
    int totalColisiones = 0;
    for (int i = 0; i < capacidad; i++) {
        if (tabla[i] != null && tabla[i].siguiente != null) {
            totalColisiones++;
        }
    }

    String[] colisiones = new String[totalColisiones];
    int index = 0;

    for (int i = 0; i < capacidad; i++) {
        if (tabla[i] != null && tabla[i].siguiente != null) {
            StringBuilder reporte = new StringBuilder("Índice " + i + ":");
            Nodo actual = tabla[i];
            while (actual != null) {
                FragmentoADN f = (FragmentoADN) actual.dato;
                reporte.append("\n  - ").append(f.frag).append(" (frec: ").append(f.frec).append(")");
                actual = actual.siguiente;
            }
            colisiones[index++] = reporte.toString(); 
        }
    }
    return colisiones; 
}


}

