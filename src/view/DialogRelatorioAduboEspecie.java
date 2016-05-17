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
public class DialogRelatorioAduboEspecie extends DialogRelatorioAdubo {

    private String titulo;
    private String descricao;

    public DialogRelatorioAduboEspecie(ArrayList<Adubo> lista, String especie) {
        super(lista);
        titulo = "Adubo gasto na produção das mudas de " + especie + ".";

        descricao = "     Este relatório contem os adubos utilizados na plantação "
                + "de todas as mudas de " + especie + ", bem como o valor relativo"
                + " a quantidade do adubo gasto.";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}