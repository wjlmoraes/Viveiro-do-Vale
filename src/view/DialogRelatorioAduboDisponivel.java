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
public class DialogRelatorioAduboDisponivel extends DialogRelatorioAdubo {

    private String titulo;
    private String descricao;

    public DialogRelatorioAduboDisponivel(ArrayList<Adubo> lista) {
        super(lista);
        titulo = "Adubo gasto na plantação das mudas disponíveis para venda.";

        descricao = "     Este relatório contem os adubos utilizados na plantação"
                + "de todas as mudas que estão dispónives para venda bem  como a "
                + "quantidade e o preço total.";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}