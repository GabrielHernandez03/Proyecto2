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
 * Clase que representa un aminoácido con sus fragmentos y abreviaturas
 */
public class Aminoacido {
    /** Array de fragmentos que componen el aminoácido */
    public String[] fragmentos;
    
    /** Primera abreviatura estándar del aminoácido */
    public String abv1;
    
    /** Segunda abreviatura estándar del aminoácido */
    public String abv2;

    /**
     * Constructor que inicializa un aminoácido
     * @param fragmentos Array de cadenas que representan los fragmentos
     * @param abv1 Abreviatura de 1 letra del aminoácido
     * @param abv2 Abreviatura de 3 letras del aminoácido
     */
    public Aminoacido(String[] fragmentos, String abv1, String abv2) {
        this.fragmentos = fragmentos;
        this.abv1 = abv1;
        this.abv2 = abv2;
    }
}
