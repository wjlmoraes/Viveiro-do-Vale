/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Mudas;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioMudasSocio extends DialogRelatorioMudas {

    private String titulo;
    private String descricao;

    public DialogRelatorioMudasSocio(ArrayList<Mudas> lista, String nome) {
        super(lista);
        titulo = "Mudas que " + nome + " ajudou plantar.";

        descricao = "     Este relatório contem as especie e as datas em "
                + "que " + nome + " trabalhou na produção!";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}