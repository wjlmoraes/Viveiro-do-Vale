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
import model.MudasDAO;
import view.PainelMudasBusca;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelMudasBusca {

    private PainelMudasBusca mudas;
    private ArrayList<Mudas> md;

    public ControlerPainelMudasBusca() {
        mudas = new PainelMudasBusca(new tratadorMudasBusca());
    }

    public class tratadorMudasBusca implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.all:
                    mudas.RemoveAll();
                    md = MudasDAO.busca();
                    if (md != null) {
                        mudas.addMuda(md);
                    } else {
                        JOptionPane.showMessageDialog(mudas, "Nenhum resultado para busca!");
                    }
                    break;
//##############################################################################
                case Constantes.search:
                    mudas.RemoveAll();
                    if ((mudas.getTextNome().equals(""))) {
                        JOptionPane.showMessageDialog(mudas, "Digite um nome \npara realizar a busca");
                    } else {
                        md = MudasDAO.busca(mudas.getTextNome());
                        if (md != null) {
                            mudas.addMuda(md);
                        } else {
                            JOptionPane.showMessageDialog(mudas, "Nenhum resultado para busca!");
                        }
                    }
                    break;
//##############################################################################
                case Constantes.clean:
                    mudas.RemoveAll();
                    mudas.setTextNome("");
                    break;
            }
        }
    }

    /**
     * @return the mudas
     */
    public PainelMudasBusca getMudas() {
        return mudas;
    }

    /**
     * @param mudas the mudas to set
     */
    public void setMudas(PainelMudasBusca mudas) {
        this.mudas = mudas;
    }
}