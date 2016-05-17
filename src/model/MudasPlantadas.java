/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class MudasPlantadas {

    private int quant;
    private String especie;
    private String data;

    public MudasPlantadas(int aQuant, String anEspecie, String aData) {
        this.quant = aQuant;
        this.especie = anEspecie;
        this.data = aData.substring(6, 10) + aData.substring(3, 5) + aData.substring(0, 2);;
    }

    /**
     * @return the quant
     */
    public int getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(int quant) {
        this.quant = quant;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
}
