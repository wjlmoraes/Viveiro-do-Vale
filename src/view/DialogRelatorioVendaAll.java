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
public class DialogRelatorioVendaAll extends DialogRelatorioVenda {
    
    public DialogRelatorioVendaAll(ArrayList<VendaInclui> lista) {
        super(lista);
        super.setTextoTitulo("Todas as venda realizadas até presente momento.");
    }
}