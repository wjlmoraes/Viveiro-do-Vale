/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class Adubo {

    private String nome; //Nome do adubo
    private float quant; //Quantidade em kg do adubo
    private float preco; //Preço por kg do adubo

    public Adubo(){ }

    public Adubo(String aNome, float aQuant, float aPreco) {
        this.nome = aNome;
        this.quant = aQuant;
        this.preco = aPreco;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the quant
     */
    public float getQuant() {
        return quant;
    }

    /**
     * @param quant the quant to set
     */
    public void setQuant(float quant) {
        this.quant = quant;
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