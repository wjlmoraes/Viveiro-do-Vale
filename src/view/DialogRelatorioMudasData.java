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
public class DialogRelatorioMudasData extends DialogRelatorioMudas {

    private String di;
    private String df;
    private String titulo;
    private String descricao;

    public DialogRelatorioMudasData(ArrayList<Mudas> lista, String d1, String d2) {
        super(lista);
        di = d1.substring(6, 8) + "/" + d1.substring(4, 6) + "/" + d1.substring(0, 4);
        df = d2.substring(6, 8) + "/" + d2.substring(4, 6) + "/" + d2.substring(0, 4);
        titulo = "Mudas plantadas entre " + di + " e " + df + ".";
        descricao = "     Este relatório contem as mudas que foram plantado durante"
                + "o período de " + di + " a " + df + " bem como a quantidade plantada em"
                + "cada dia.";
        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }
}