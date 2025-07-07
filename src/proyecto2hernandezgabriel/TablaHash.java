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
/**
 * Clase que implementa una tabla hash para almacenar Fragmentos de ADN
 */
public class TablaHash {
    /** Array de nodos que forma la tabla */
    private Nodo[] tabla;
    
    /** Capacidad total de la tabla */
    private int capacidad;
    
    /** Número actual de elementos */
    private int tamaño;
    
    /** Contador de colisiones */
    private int colisionesTotales;

    /**
     * Constructor que inicializa la tabla
     * @param capacidad Tamaño inicial de la tabla
     */
    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Nodo[capacidad];
        this.tamaño = 0;
        this.colisionesTotales = 0;
    }

    /**
     * Función hash para fragmentos de 3 nucleótidos
     * @param fragmento Secuencia de 3 nucleótidos
     * @return Índice hash calculado
     * @throws IllegalArgumentException Si el fragmento no tiene 3 nucleótidos
     */
    private int hash(String fragmento) {
        if (fragmento.length() != 3) {
            throw new IllegalArgumentException("Los fragmentos deben tener 3 nucleótidos");
        }

        int hash = 0;
        for (int i = 0; i < 3; i++) {
            hash = (hash << 2) | switch (fragmento.charAt(i)) {
                case 'A' -> 0;
                case 'C' -> 1;
                case 'T', 'U' -> 2;
                case 'G' -> 3;
                default -> throw new IllegalArgumentException("Nucleótido inválido: " + fragmento.charAt(i));
            };
        }
        return Math.abs(hash) % capacidad;
    }

    /**
     * Añade un nuevo fragmento a la tabla
     * @param fragmento Fragmento de ADN a añadir
     */
    public void añadir(FragmentoADN fragmento) {
        int index = hash(fragmento.getFrag());
        for (Nodo actual = tabla[index]; actual != null; actual = actual.getSiguiente()) {
            if (actual.getDato().getFrag().equals(fragmento.getFrag())) {
                return;
            }
        }

        Nodo nuevoNodo = new Nodo(fragmento);
        if (tabla[index] != null) {
            colisionesTotales++;
            nuevoNodo.setSiguiente(tabla[index]);
        }
        tabla[index] = nuevoNodo;
        tamaño++;
    }

    /**
     * Busca un fragmento en la tabla
     * @param fragmento Secuencia a buscar
     * @return Fragmento encontrado o null
     */
    public FragmentoADN buscar(String fragmento) {
        for (Nodo actual = tabla[hash(fragmento)]; actual != null; actual = actual.getSiguiente()) {
            FragmentoADN f = actual.getDato();
            if (f.getFrag().equals(fragmento)) {
                return f;
            }
        }
        return null;
    }

    /**
     * Genera un reporte de las colisiones en la tabla
     * @return Array de Strings con la información de colisiones
     */
    public String[] reporteColisiones() {
        String[] reportes = new String[colisionesTotales];
        int index = 0;
        
        for (int i = 0; i < capacidad; i++) {
            if (tabla[i] != null && tabla[i].getSiguiente() != null) {
                StringBuilder sb = new StringBuilder("Índice ").append(i).append(": ");
                for (Nodo actual = tabla[i]; actual != null; actual = actual.getSiguiente()) {
                    sb.append(actual.getDato().getFrag()).append(" ");
                }
                reportes[index++] = sb.toString();
            }
        }
        return reportes;
    }

    /**
     * Obtiene todos los fragmentos almacenados en la tabla
     * @return Array con todos los fragmentos
     */
    public FragmentoADN[] obtenerTodosLosFragmentos() {
        FragmentoADN[] fragmentos = new FragmentoADN[tamaño];
        int index = 0;
        
        for (int i = 0; i < capacidad; i++) {
            for (Nodo actual = tabla[i]; actual != null; actual = actual.getSiguiente()) {
                fragmentos[index++] = actual.getDato();
            }
        }
        return fragmentos;
    }
}
