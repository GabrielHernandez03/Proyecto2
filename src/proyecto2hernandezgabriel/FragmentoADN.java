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
 * Clase que representa un fragmento de ADN con su frecuencia y ubicaciones
 */
public class FragmentoADN {
    /** Secuencia de nucleótidos del fragmento */
    private String frag;
    
    /** Frecuencia de aparición del fragmento */
    private int frec;
    
    /** Ubicaciones donde aparece el fragmento */
    private int[] ubi;
    
    /** Capacidad máxima inicial del array de ubicaciones */
    private static final int MAX_UBICACIONES = 100; 

    /**
     * Constructor que inicializa un nuevo fragmento
     * @param frag Secuencia de nucleótidos
     */
    public FragmentoADN(String frag) {
        this.frag = frag;
        this.frec = 1;
        this.ubi = new int[MAX_UBICACIONES];
    }

    // Métodos getters y setters
    public String getFrag() { return frag; }
    public int getFrec() { return frec; }
    public void setFrec(int frec) { this.frec = frec; }
    public int[] getUbi() { return ubi; }

    /**
     * Añade una nueva ubicación al fragmento
     * @param ubicacion Posición donde se encuentra el fragmento
     */
    public void agregarUbicacion(int ubicacion) {
        if (frec >= ubi.length) {
            int nuevaCapacidad = ubi.length + 10;
            int[] nuevoArreglo = new int[nuevaCapacidad];
            System.arraycopy(ubi, 0, nuevoArreglo, 0, ubi.length);
            ubi = nuevoArreglo;
        }
        ubi[frec] = ubicacion;
    }

    /**
     * Genera una representación en String de las ubicaciones
     * @return String formateado con las ubicaciones
     */
    public String ubicacionesToString() {
        if (frec == 0) return "[]";

        StringBuilder resultado = new StringBuilder("[");
        resultado.append(ubi[0]);
        for (int i = 1; i < frec; i++) {
            resultado.append(", ").append(ubi[i]);
        }
        return resultado.append("]").toString();
    }
}
