/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.Adubo;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioAduboTodas extends DialogRelatorioAdubo {

    private String titulo;
    private String descricao;

    public DialogRelatorioAduboTodas(ArrayList<Adubo> lista) {
        super(lista);
        titulo = "Adubo gasto na plantação de todas mudas.";

        descricao = "     Este relatório contem os adubos utilizados na plantação "
                + "de todas as mudas plantadas como a quantidade e o preco e o "
                + "preço total.";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}