/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Mudas;
import model.RelatorioMudas;
import model.Socio;
import model.SocioDAO;
import view.DialogRelatorioMudasData;
import view.DialogRelatorioMudasEspecie;
import view.DialogRelatorioMudasSocio;
import view.DialogRelatorioMudasTodas;
import view.PainelRelatorioMudas;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelRelatorioMudas {

    private int op;
    private ArrayList<Mudas> resultado;
    private DialogRelatorioMudasEspecie especie;
    private DialogRelatorioMudasData data;
    private DialogRelatorioMudasSocio socio;
    private DialogRelatorioMudasTodas all;
    private PainelRelatorioMudas painel;

    public ControlerPainelRelatorioMudas() {
        painel = new PainelRelatorioMudas(new tratadorRelatorioMudas());
        op = 0;
    }

    private class tratadorRelatorioMudas implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case "Datas do plantio de uma especie":
                    op = 1;
                    painel.pesquisa1();
                    break;
//##############################################################################
                case "Mudas plantadas durante um perído de tempo":
                    op = 2;
                    painel.pesquisa2();
                    break;
//##############################################################################
                case "Mudas plantadas por um socio":
                    op = 3;
                    painel.pesquisa3();
                    break;
//##############################################################################
                case "Todas mudas plantadas até hoje":
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
                        case 1:
                            if (painel.getTextEspecie() == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da especie!");
                            } else {
                                resultado = RelatorioMudas.relatorioMudasEspecie(painel.getTextEspecie());
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    especie = new DialogRelatorioMudasEspecie(resultado, painel.getTextEspecie());
                                    especie.setModal(true);
                                    especie.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 2:
                            String[] a = painel.getTextDatas();
                            if (a == null) {
                                JOptionPane.showMessageDialog(painel, "Digite as datas!");
                            } else {
                                resultado = RelatorioMudas.relatorioMudasData(a[0], a[1]);
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    data = new DialogRelatorioMudasData(resultado, a[0], a[1]);
                                    data.setModal(true);
                                    data.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 3:
                            if (painel.getTextCpf() == null) {
                                JOptionPane.showMessageDialog(painel, "Digite um CPF!");
                            } else {
                                ArrayList<Socio> aux = SocioDAO.buscaPorCpf(painel.getTextCpf());
                                if (aux == null) {
                                    JOptionPane.showMessageDialog(painel, "CPF não cadastrado!");
                                } else {
                                    resultado = RelatorioMudas.relatorioMudasSocio(painel.getTextCpf());
                                    if (resultado == null) {
                                        JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                    } else {
                                        socio = new DialogRelatorioMudasSocio(resultado, aux.get(0).getNome());
                                        socio.setModal(true);
                                        socio.setVisible(true);
                                    }
                                }
                            }
                            break;
//******************************************************************************
                        case 4:
                            resultado = RelatorioMudas.relatorioMudasAllUntilToday();
                            if (resultado == null) {
                                JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                            } else {
                                all = new DialogRelatorioMudasTodas(resultado);
                                all.setModal(true);
                                all.setVisible(true);
                            }
                            break;
//******************************************************************************
                        case 0:
                            break;
                    }
                    break;
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelRelatorioMudas getPainel() {
        return painel;
    }
}
