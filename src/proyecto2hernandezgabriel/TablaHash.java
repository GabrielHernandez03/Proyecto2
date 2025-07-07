/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

import proyecto2hernandezgabriel.FragmentoADN;
import proyecto2hernandezgabriel.Nodo;

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
            System.out.println(fragmento);
            throw new IllegalArgumentException("Los fragmentos deben tener 3 nucleótidos");
        }

        int hash = 0;
        for (int i = 0; i < 3; i++) {
            char c = fragmento.charAt(i);
            int valor = 0;
            switch (c) {
                case 'A':
                    valor = 0;
                    break;
                case 'C':
                    valor = 1;
                    break;
                case 'T':
                    valor = 2;
                    break;
                case 'U':
                    valor = 2;
                    break;
                case 'G':
                    valor = 3;
                    break;
                default:
                    throw new IllegalArgumentException("Nucleótido inválido: " + c);
            }
            hash = (hash << 2) | valor;
        }
        return Math.abs(hash) % capacidad;
    }

    public void añadir(FragmentoADN fragmento) {
        int index = hash(fragmento.getFrag());
        Nodo actual = tabla[index];

        while (actual != null) {
            FragmentoADN f = actual.getDato();
            if (f.getFrag().equals(fragmento.getFrag())) {
                return;
            }
            actual = actual.getSiguiente();
        }

        Nodo nuevoNodo = new Nodo(fragmento);
        if (tabla[index] != null) {
            colisionesTotales++;
            nuevoNodo.setSiguiente(tabla[index]);
        }
        tabla[index] = nuevoNodo;
        tamaño++;
    }

    public FragmentoADN buscar(String fragmento) {
        int index = hash(fragmento);
        Nodo actual = tabla[index];

        while (actual != null) {
            FragmentoADN f = (FragmentoADN) actual.getDato();
            if (f.getFrag().equals(fragmento)) {
                return f;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public String[] reporteColisiones() {
        int totalColisiones = 0;
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null && tabla[i].getSiguiente() != null) {
                totalColisiones++;
            }
        }

        String[] colisiones = new String[totalColisiones];
        int index = 0;

        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null && tabla[i].getSiguiente() != null) {
                StringBuilder reporte = new StringBuilder("Colisiones en el Índice " + i + ":");
                Nodo actual = tabla[i];
                while (actual != null) {
                    FragmentoADN f = (FragmentoADN) actual.getDato();
                    reporte.append("\n  - ").append(f.getFrag()).append(" (frec: ").append(f.getFrec()).append(")");
                    actual = actual.getSiguiente();
                }
                colisiones[index++] = reporte.toString();
            }
        }
        return colisiones;
    }
    
    public FragmentoADN[] obtenerTodosLosFragmentos() {
    int contador = 0;
    for (int i = 0; i < tabla.length; i++) {
        Nodo actual = tabla[i];
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
    }

    FragmentoADN[] fragmentos = new FragmentoADN[contador];
    int index = 0;

    for (int i = 0; i < tabla.length; i++) {
        Nodo actual = tabla[i];
        while (actual != null) {
            fragmentos[index++] = (FragmentoADN) actual.getDato();
            actual = actual.getSiguiente();
        }
    }

    return fragmentos;
}


}
