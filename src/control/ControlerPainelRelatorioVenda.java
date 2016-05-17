/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.RelatorioVenda;
import model.VendaInclui;
import view.DialogRelatorioVendaAll;
import view.DialogRelatorioVendaData;
import view.PainelRelatorioVenda;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelRelatorioVenda {

    private VendaInclui rs;
    private ArrayList<VendaInclui> resultado;
    private DialogRelatorioVendaData data;
    private DialogRelatorioVendaAll all;
    private PainelRelatorioVenda painel;

    public ControlerPainelRelatorioVenda() {
        painel = new PainelRelatorioVenda(new tratadorRelatorioVenda());
    }

    private class tratadorRelatorioVenda implements ActionListener {

        private int op = 0;

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case "Especie mais vendida":
                    op = 1;
                    painel.limpaPainel();
                    break;
//##############################################################################
                case "Quantidade vendida de uma especie":
                    op = 2;
                    painel.pesquisa1();
                    break;
//##############################################################################
                case "Vendas realizadas em um período de tempo":
                    op = 3;
                    painel.pesquisa2();
                    break;
//##############################################################################
                case "Todas as vendas realizadas":
                    op = 4;
                    painel.limpaPainel();
                    break;
//##############################################################################
                case Constantes.ok:
                    switch (op) {
//******************************************************************************
                        case 1:
                            rs = RelatorioVenda.relatorioVendaMais();
                            if (rs == null) {
                                JOptionPane.showMessageDialog(painel, "Não há resultado para este relatório!");
                            } else {
                                JOptionPane.showMessageDialog(painel, "A especie mais vendida "
                                        + "é \"" + rs.getEspecie() + "\" com " + rs.getQuantidade() + " "
                                        + "mudas vendidas!");
                            }
                            break;
//******************************************************************************
                        case 2:
                            if (painel.getTextEspecie() == null) {
                                JOptionPane.showMessageDialog(painel, "Digite um texto!");
                            } else {
                                rs = RelatorioVenda.relatorioVendaQuant(painel.getTextEspecie());
                                if (rs == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatório!");
                                } else {
                                    JOptionPane.showMessageDialog(painel, "Foram vendidas " + rs.getQuantidade() + " mudas "
                                            + "da especie " + rs.getEspecie() + "!");
                                }
                            }
                            break;
//******************************************************************************
                        case 3:
                            String[] a = painel.getTextDatas();
                            if (a == null) {
                                JOptionPane.showMessageDialog(painel, "Digite um texto!");
                            } else {
                                resultado = RelatorioVenda.relatorioVendaData(a[0], a[1]);
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatório!");
                                } else {
                                    data = new DialogRelatorioVendaData(resultado, a[0], a[1]);
                                    data.setModal(true);
                                    data.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 4:
                            resultado = RelatorioVenda.relatorioVendaAll();
                            if (resultado == null) {
                                JOptionPane.showMessageDialog(painel, "Não há resultado para este relatório!");
                            } else {
                                all = new DialogRelatorioVendaAll(resultado);
                                all.setModal(true);
                                all.setVisible(true);
                            }
                            break;
//******************************************************************************
                        case 0:
                            break;
                    }
                    break;
                case Constantes.clean:
                    op = 0;
                    painel.limpaTudo();
                    break;
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelRelatorioVenda getPainel() {
        return painel;
    }
}