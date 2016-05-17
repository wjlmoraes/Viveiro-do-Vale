/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Adubo;
import model.AduboDAO;
import view.PainelAduboCadastro;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelAduboCadastro {

    private int rs;
    private PainelAduboCadastro painel;

    public ControlerPainelAduboCadastro() {
        painel = new PainelAduboCadastro(new tratadorAduboCad());
    }

    private class tratadorAduboCad implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.cancel:
                    break;
//##############################################################################
                case Constantes.clean:
                    painel.Limpa();
                    painel.focusTextNome();
                    break;
//##############################################################################
                case Constantes.save:
                    if (painel.getTextNome().equals("")) {

                        JOptionPane.showMessageDialog(painel, "Digite um nome!");
                        painel.focusTextNome();

                    } else if (painel.getTextQuantidade().equals("")) {

                        JOptionPane.showMessageDialog(painel, "Digite uma quantidade!");
                        painel.focusTextQuant();

                    } else if (painel.getTextPreco().equals("")) {

                        JOptionPane.showMessageDialog(painel, "Digite um preço!");
                        painel.focusTextPreco();
                    } else {
                        String nome = painel.getTextNome();
                        String quan = painel.getTextQuantidade();
                        String prec = painel.getTextPreco();
                        Adubo novo = new Adubo(nome, Float.parseFloat(quan), Float.parseFloat(prec));
                        rs = AduboDAO.insere(novo);
                        if (rs == 1) {
                            JOptionPane.showMessageDialog(painel, "Inserção realizada com sucesso!");
                            painel.Limpa();
                            painel.focusTextNome();
                        } else if (rs == 2) {
                            JOptionPane.showMessageDialog(painel, "Atualização realizada com sucesso!");
                            painel.Limpa();
                            painel.focusTextNome();
                        } else {
                            JOptionPane.showMessageDialog(painel, "Não foi possível realizar inserção!");
                        }
                    }
                    break;
            }
        }
    }

    /**
     * @return the painel
     */
    public PainelAduboCadastro getPainelAdubo() {
        return painel;
    }
}