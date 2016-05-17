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
public class DialogRelatorioAduboData extends DialogRelatorioAdubo {

    private String titulo;
    private String descricao;

    public DialogRelatorioAduboData(ArrayList<Adubo> lista, String di, String df) {
        super(lista);
        titulo = "Adubo gasto no perido de " + di + " até " + df + ".";

        descricao = "     Este relatório contem os adubos utilizados na plantação"
                + "de todas as mudas no periodo de " + di + " até " + df + "bem "
                + "como a quantidade e o preço total.";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}