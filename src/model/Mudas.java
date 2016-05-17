/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class Mudas {

    private String data;
    private String especie;
    private int quantidade;

    public Mudas(String anEspecie, int aQuant) {
        this.especie = anEspecie;
        this.quantidade = aQuant;
    }

    public Mudas(String aData, String anEspecie, int aQuant) {
        //this.data = aData.substring(6, 10) + aData.substring(3, 5) + aData.substring(0, 2);
        this.data = aData;
        this.especie = anEspecie;
        this.quantidade = aQuant;
    }

    /**
     * @return the data in the formated dd/mm/yyyy
     */
    public String getData() {
        return data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4);
        //return data.substring(0, 2)+ data.substring(3, 5) + data.substring(6, 10);
        //return data;
    }

    /**
     * @param data the data to set in the formated dd/mm/yyyy
     */
    public void setData(String data) {
        this.data = data.substring(6, 10) + data.substring(3, 5) + data.substring(0, 2);
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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}