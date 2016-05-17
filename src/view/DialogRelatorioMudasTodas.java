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
public class DialogRelatorioMudasTodas extends DialogRelatorioMudas {

    private String titulo;
    private String descricao;

    public DialogRelatorioMudasTodas(ArrayList<Mudas> lista) {
        super(lista);
        titulo = "Todas mudas plantadas.";

        descricao = "     Este relatório contem todas mudas plantadas até o presente "
                + "momentos, bem como a data de plantio e a quantidade plantada em"
                + "cada data.";

        super.setTextoTitulo(titulo);
        super.setTextoDescricao(descricao);
    }   
}