/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class AduboGasto {

    private float quant_ad;
    private String especie;
    private String nome_ad;
    private String data;

    public AduboGasto(float aQuant, String anEspecie, String anAdubo, String aData) {
        this.quant_ad = aQuant;
        this.especie = anEspecie;
        this.nome_ad = anAdubo;
        this.data = aData.substring(6, 10) + aData.substring(3, 5) + aData.substring(0, 2);
    }

    /**
     * @return the quant_ad
     */
    public float getQuant_ad() {
        return quant_ad;
    }

    /**
     * @param quant_ad the quant_ad to set
     */
    public void setQuant_ad(float quant_ad) {
        this.quant_ad = quant_ad;
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
     * @return the nome_ad
     */
    public String getNome_ad() {
        return nome_ad;
    }

    /**
     * @param nome_ad the nome_ad to set
     */
    public void setNome_ad(String nome_ad) {
        this.nome_ad = nome_ad;
    }

    /**
     * @return the data of typo dd/mm/yyyy
     */
    public String getData() {
        //return data.substring(0, 2) + "/" + data.substring(3, 5) + "/" + data.substring(6, 10);
        return data;
    }

    /**
     * @param data the data to set and the type is dd/mm/yyyy
     */
    public void setData(String aData) {
        this.data = aData.substring(6, 10) + aData.substring(3, 5) + aData.substring(0, 2);
    }
}