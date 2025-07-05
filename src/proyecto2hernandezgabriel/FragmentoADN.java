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
    
    public FragmentoADN(String f){
        this.frag = f;
        this.frec = 0;
        this.ubi = new int[100];
    }

    /**
     * @return the frag
     */
    public String getFrag() {
        return frag;
    }

    /**
     * @param frag the frag to set
     */
    public void setFrag(String frag) {
        this.frag = frag;
    }

    /**
     * @return the frec
     */
    public int getFrec() {
        return frec;
    }

    /**
     * @param frec the frec to set
     */
    public void setFrec(int frec) {
        this.frec = frec;
    }

    /**
     * @return the ubi
     */
    public int[] getUbi() {
        return ubi;
    }

    /**
     * @param ubi the ubi to set
     */
    public void setUbi(int[] ubi) {
        this.ubi = ubi;
    }
}
