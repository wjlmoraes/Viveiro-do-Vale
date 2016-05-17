/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Adubo;
import model.RelatorioAdubo;
import view.DialogRelatorioAduboData;
import view.DialogRelatorioAduboDisponivel;
import view.DialogRelatorioAduboEspecie;
import view.DialogRelatorioAduboTodas;
import view.PainelRelatorioAdubo;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelRelatorioAdubo {

    private int op;
    private ArrayList<Adubo> resultado;
    private DialogRelatorioAduboEspecie especie;
    private DialogRelatorioAduboData data;
    private DialogRelatorioAduboDisponivel disp;
    private DialogRelatorioAduboTodas all;
    private PainelRelatorioAdubo painel;

    public ControlerPainelRelatorioAdubo() {
        painel = new PainelRelatorioAdubo(new tratadorRelatorioAdubo());
        op = 0;
    }

    private class tratadorRelatorioAdubo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case "Adubos gastos na plantação de uma espécie":
                    op = 1;
                    painel.pesquisa1();
                    break;
//##############################################################################
                case "Adubos gastos durante um perído de tempo":
                    op = 2;
                    painel.pesquisa2();
                    break;
//##############################################################################
                case "Adubos gastos na plantação das mudas disponíveis":
                    op = 3;
                    painel.limpa();
                    break;
//##############################################################################
                case "Todos adubos gastos até hoje":
                    op = 4;
                    painel.limpa();
                    break;
//##############################################################################
                case Constantes.clean:
                    op = 0;
                    painel.limpa();
                    painel.limpaButtonGroup();
                    break;
//##############################################################################
                case Constantes.ok:
                    switch (op) {
//******************************************************************************
                        case 1:
                            if (painel.getTextEspecie() == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da espécie!");
                            } else {
                                resultado = RelatorioAdubo.relatorioAduboEspecie(painel.getTextEspecie());
                                if (resultado != null) {
                                    especie = new DialogRelatorioAduboEspecie(resultado, painel.getTextEspecie());
                                    especie.setModal(true);
                                    especie.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 2:
                            String[] a = painel.getTextDatas();
                            if (a == null) {
                                JOptionPane.showMessageDialog(painel, "Digite a data inicial e a data final!");
                            } else {
                                resultado = RelatorioAdubo.relatorioAduboData(a[0], a[1]);
                                if (resultado != null) {
                                    data = new DialogRelatorioAduboData(resultado, a[0], a[1]);
                                    data.setModal(true);
                                    data.setVisible(true);
                                } else {
                                    JOptionPane.showMessageDialog(painel, "Não há resultados para esse relatorio!");
                                }
                            }
                            break;
//******************************************************************************
                        case 3:
                            resultado = RelatorioAdubo.relatorioAduboGasto();
                            if (resultado != null) {
                                disp = new DialogRelatorioAduboDisponivel(resultado);
                                disp.setModal(true);
                                disp.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(painel, "Não há resultados para esse relatorio!");
                            }
                            break;
//******************************************************************************
                        case 4:
                            resultado = RelatorioAdubo.relatorioAduboAllUntilToday();
                            if (resultado != null) {
                                all = new DialogRelatorioAduboTodas(resultado);
                                all.setModal(true);
                                all.setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(painel, "Não há resultados para esse relatorio!");
                            }
                            break;
//******************************************************************************
                        case 0:
                            JOptionPane.showMessageDialog(painel, "Escolha um relatorio!");
                            break;
                    }
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelRelatorioAdubo getPainel() {
        return painel;
    }
}