/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.RelatorioSocio;
import model.SocioTrabalhou;
import view.DialogRelatorioSocioCpfData;
import view.DialogRelatorioSocioData;
import view.DialogRelatorioSocioEspecie;
import view.PainelRelatorioSocio;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelRelatorioSocio {

    private int op;
    private ArrayList<SocioTrabalhou> resultado;
    private DialogRelatorioSocioEspecie especie;
    private DialogRelatorioSocioData data;
    private DialogRelatorioSocioCpfData cpfData;
    private PainelRelatorioSocio painel;

    public ControlerPainelRelatorioSocio() {
        painel = new PainelRelatorioSocio(new tratadorRelatorioSocio());
        op = 0;
    }

    private class tratadorRelatorioSocio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case "Socio que trabalharam no plantio de uma especie":
                    op = 1;
                    painel.pesquisa1();
                    break;
//##############################################################################
                case "Socios que trabalharam em um perído de tempo":
                    op = 2;
                    painel.pesquisa2();
                    break;
//##############################################################################
                case "Horas que um socio trabalhou em um período":
                    op = 3;
                    painel.pesquisa3();
                    break;
//##############################################################################
                case "Horas total que um socio trabalhou":
                    op = 4;
                    painel.pesquisa4();
                    break;
//##############################################################################
                case Constantes.clean:
                    op = 0;
                    painel.limpa();
                    break;
//##############################################################################
                case Constantes.ok:
                    switch (op) {
//******************************************************************************
                        case 1:
                            if (painel.getTextEspecie() == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da especie!");
                            } else {
                                resultado = RelatorioSocio.relatorioSocioEspecie(painel.getTextEspecie());
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    especie = new DialogRelatorioSocioEspecie(resultado, painel.getTextEspecie());
                                    especie.setModal(true);
                                    especie.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 2:
                            String[] a = painel.getTextDatas();
                            if (a == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da especie!");
                            } else {
                                resultado = RelatorioSocio.relatorioSocioData(a[0], a[1]);
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    data = new DialogRelatorioSocioData(resultado, a[0], a[1]);
                                    data.setModal(true);
                                    data.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 3:
                            String[] b = painel.getTextCpfDatas();
                            if (b == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da especie!");
                            } else {
                                resultado = RelatorioSocio.relatorioSocioHorasData(b[0], b[1], b[2]);
                                if (resultado == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    cpfData = new DialogRelatorioSocioCpfData(resultado, null, b[1], b[2]);
                                    cpfData.setModal(true);
                                    cpfData.setVisible(true);
                                }
                            }
                            break;
//******************************************************************************
                        case 4:
                            String cpf = painel.getTextCpf();
                            if (cpf == null) {
                                JOptionPane.showMessageDialog(painel, "Digite o nome da especie!");
                            } else {
                                String horas = RelatorioSocio.relatorioSocioTotalHoras(cpf);
                                if (cpf == null) {
                                    JOptionPane.showMessageDialog(painel, "Não há resultado para este relatorio!");
                                } else {
                                    JOptionPane.showMessageDialog(painel, "O socio " + cpf + " trabalhou um total de " + horas + " horas.");
                                }
                            }
                            break;
//******************************************************************************
                        case 0:
                            JOptionPane.showMessageDialog(painel, "Escolhar um opção!");
                            break;
                    }
                    break;
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelRelatorioSocio getPainel() {
        return painel;
    }
}