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
public class DialogRelatorioMudasEspecie extends DialogRelatorioMudas {

    private String titulo;
    private String descricao;

    public DialogRelatorioMudasEspecie(ArrayList<Mudas> lista, String especie) {
        super(lista);
        titulo = "Data do plantio da especie " + especie + ".";

        descricao = "     Este relatório contem as data em que foram plantadas "
                + "as mudas das especies " + especie + ".";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}