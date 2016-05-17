/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Socio;
import model.SocioDAO;
import view.PainelSocio;
import viveiro.Constantes;
import viveiro.Verifica;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelSocio {

    private PainelSocio painel;

    public ControlerPainelSocio() {
        painel = new PainelSocio(new tratadorSocio());
        painel.CamposTexto(false);
    }

    public class tratadorSocio implements ActionListener, FocusListener {

        private int rs;
        private int est;
        private boolean leitura;
        private boolean valida;
        private String cpf;
        private String nom;
        private String rua;
        private String num;
        private String bai;
        private String cmp;
        private String cty;
        private String tfl;

        //Trata evento de botões
        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.cancel:
                    
                    break;
//##############################################################################
                case Constantes.clean:
                    painel.Limpar();
                    painel.CamposTexto(false);
                    break;
//##############################################################################
                case Constantes.save:
                    if (painel.getTextNome().equals("")) { //Verifica se foi digitado um nome

                        JOptionPane.showMessageDialog(painel, "Digite um nome!");
                        painel.focusTextNome();

                    } else if (!painel.numberState() && painel.getTextNumero().equals("")) { //Verifica check box numero não esta marcado

                        //Verifica se foi digitado um nome
                        JOptionPane.showMessageDialog(painel, "Digite um número de residencia!\nCaso não haja, marque a opção sem número!");
                        painel.focusTextNumero();

                    } else if (painel.getTextCidade().equals("")) { //Verifica check box numero não esta marcado

                        JOptionPane.showMessageDialog(painel, "Digite o nome da cidade!");
                        painel.focusTextCidade();

                    } else if ((painel.getComboBoxEstados()) == 0) { //Verifica se um estado foi selecionado

                        JOptionPane.showMessageDialog(painel, "Selecionie um estado!");

                    } else {
                        cpf = painel.getTextCpf();
                        nom = painel.getTextNome();
                        rua = painel.getTextRuaAvenida();
                        num = painel.getTextNumero();
                        bai = painel.getTextBairro();
                        cmp = painel.getTextComplemento();
                        cty = painel.getTextCidade();
                        tfl = painel.getTextTelefone();
                        est = painel.getComboBoxEstados();
                        Socio novo;
                        if (!painel.numberState()) {
                            novo = new Socio(Integer.parseInt(num), est, cpf, nom, rua, bai, cmp, cty, tfl);
                        } else {
                            novo = new Socio(0, est, cpf, nom, rua, bai, cmp, cty, tfl);
                        }
                        rs = SocioDAO.insere(novo);
                        if (rs == 1) {
                            JOptionPane.showMessageDialog(painel, "Novo socio inserido com sucesso!");
                            painel.Limpar();
                            painel.CamposTexto(false);
                            painel.focusTextCpf();
                        } else if (rs == 2) {
                            JOptionPane.showMessageDialog(painel, "Novo socio atualiza do com sucesso!");
                            painel.Limpar();
                            painel.CamposTexto(false);
                            painel.focusTextCpf();
                        } else {
                            JOptionPane.showMessageDialog(painel, "Novo socio não inserido!");
                        }
                    }
                    break;
            }
        }

        //Trata evento de campos de texto
        @Override
        public void focusGained(FocusEvent event) {
        }

        @Override
        public void focusLost(FocusEvent event) {
            if (Constantes.cpfdoispontos.equals(event.getComponent().getName())) { //Campo CPF
                leitura = true;
                for (int i = 0; i < painel.getTextCpf().length(); i++) {
                    if (painel.getTextCpf().charAt(i) == ' ') {
                        leitura = false;
                        break;
                    }
                }
                if (leitura) {
                    valida = Verifica.validaCPF(painel.getTextCpf());
                    if (!valida) {
                        JOptionPane.showMessageDialog(painel, "CPF inválido!");
                        painel.focusTextCpf();
                        painel.Limpar();
                    } else {
                        ArrayList res = SocioDAO.buscaPorCpf(painel.getTextCpf());
                        Socio aux;
                        if (res != null) {
                            aux = (Socio) res.get(0);
                            painel.setTextNome(aux.getNome());
                            painel.setTextRuaAvenida(aux.getRua());
                            painel.setTextNumero(String.valueOf(aux.getNumero()));
                            painel.setTextBairro(aux.getBairro());
                            painel.setTextComplemento(aux.getComplemento());
                            painel.setTextCidade(aux.getCidade());
                            painel.setTextTelefone(aux.getTelefone());
                            painel.setComboBoxEstados(aux.getEstado());
                        }
                        painel.CamposTexto(true);
                    }
                } else {
                    painel.focusTextCpf();
                }
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelSocio getPainelSocio() {
        return painel;
    }
}