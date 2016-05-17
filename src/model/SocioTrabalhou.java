/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Walas Jhony
 */
public class SocioTrabalhou {

    private String cpf;
    private String especie;
    private String data;
    private String hora;

    public SocioTrabalhou() { }

    public SocioTrabalhou(String cpf, String esp,  String data, String hora) {
        this.cpf = cpf;
        this.especie = esp;
        this.data = data.substring(6, 10) + data.substring(3, 5) + data.substring(0, 2);
        this.hora = hora+":00";
    }

    @Override
    public String toString(){
        return "CPF: "+cpf+"\nNome: "+especie+"\nHoras: "+hora+"\n";
    }
    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
}