/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2hernandezgabriel;

/**
 *
 * @author gabriel
 */
public class FragmentoADN {
    private String frag;
    private int frec;
    private int[] ubi;
    private static final int MAX_UBICACIONES = 100; 

    public FragmentoADN(String frag) {
        this.frag = frag;
        this.frec = 0;
        this.ubi = new int[MAX_UBICACIONES];
    }

    public String getFrag() {
        return frag;
    }

    public int getFrec() {
        return frec;
    }

    public void setFrec(int frec) {
        this.frec = frec;
    }

    public int[] getUbi() {
        return ubi;
    }

public void agregarUbicacion(int ubicacion) {
    if (frec >= ubi.length) {
        int nuevaCapacidad = ubi.length + 10;
        int[] nuevoArreglo = new int[nuevaCapacidad];
        for (int i = 0; i < ubi.length; i++) {
            nuevoArreglo[i] = ubi[i];
        }
        ubi = nuevoArreglo;
    }
    ubi[frec] = ubicacion;
    frec++;
}

}
