/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class VendaInclui {

    private String especie;
    private int numero_venda;
    private int quantidade;
    private float preco;

    public VendaInclui() { }

    public VendaInclui(String esp, int num, int quant, float preco) {
        this.especie = esp;
        this.numero_venda = num;
        this.quantidade = quant;
        this.preco = preco;
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
     * @return the numero_venda
     */
    public int getNumero_venda() {
        return numero_venda;
    }

    /**
     * @param numero_venda the numero_venda to set
     */
    public void setNumero_venda(int numero_venda) {
        this.numero_venda = numero_venda;
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

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}