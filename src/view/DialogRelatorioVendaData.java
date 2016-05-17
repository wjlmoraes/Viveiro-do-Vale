/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import model.VendaInclui;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioVendaData extends DialogRelatorioVenda {

    public DialogRelatorioVendaData(ArrayList<VendaInclui> lista, String di, String df) {
        super(lista);
        String d1 = di.substring(6, 8) + "/" + di.substring(4, 6) + "/" + di.substring(0, 4);
        String d2 = df.substring(6, 8) + "/" + df.substring(4, 6) + "/" + df.substring(0, 4);
        super.setTextoTitulo("Vendas realizadas no período de " + d1 + " a " + d2 + " .");
    }
}