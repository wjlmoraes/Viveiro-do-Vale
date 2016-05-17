/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Adubo;
import model.AduboDAO;
import model.Mudas;
import model.MudasDAO;
import model.Socio;
import model.SocioDAO;
import view.FramePrincipal;
import view.PainelAduboListar;
import view.PainelSocioListar;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerFramePrincipal {

    private FramePrincipal fp;
    private ArrayList<Adubo> aux;
    private PainelAduboListar adubobus;
    private PainelSocioListar sociobus;
    private ControlerPainelAduboCadastro adubocad;
    private ControlerPainelMudasBusca mudasbus;
    private ControlerPainelMudasCadastro mudascad;
    private ControlerPainelSocio socio;
    private ControlerPainelVendaRealiza venda;
    private ControlerPainelRelatorioAdubo relatorioAdubo;
    private ControlerPainelRelatorioMudas relatorioMudas;
    private ControlerPainelRelatorioSocio relatorioSocio;
    private ControlerPainelRelatorioVenda relatorioVenda;

    public ControlerFramePrincipal() {
        fp = new FramePrincipal(new tratadorFramePrincipal());
    }

    public class tratadorFramePrincipal implements ActionListener, KeyListener {

        @Override
        public void actionPerformed(ActionEvent event) { //Eventos de botoes;
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.adubocad:
                    adubocad = new ControlerPainelAduboCadastro();
                    fp.addPainel(adubocad.getPainelAdubo(), Constantes.pac);
                    fp.show(Constantes.pac);
                    break;
//##############################################################################
                case Constantes.adubolis:
                    aux = AduboDAO.busca();
                    if (aux != null) {
                        adubobus = new PainelAduboListar(aux);
                        fp.addPainel(adubobus, Constantes.pab);
                        fp.show(Constantes.pab);
                    } else {
                        JOptionPane.showMessageDialog(fp, "Não existe nenhum adubo cadastrado!");
                    }
                    break;
//##############################################################################
                case Constantes.mudasbus:
                    mudasbus = new ControlerPainelMudasBusca();
                    fp.addPainel(mudasbus.getMudas(), Constantes.pmb);
                    fp.show(Constantes.pmb);
                    break;
//##############################################################################
                case Constantes.mudascad:
                    ArrayList<Adubo> listaadubo = AduboDAO.busca();
                    ArrayList<Socio> listasocio = SocioDAO.buscaAll();
                    if (listaadubo == null) {
                        JOptionPane.showMessageDialog(fp, "Não existe nenhum adubo cadastrado!\nCadastre pelo menos um adubo primeiro!");
                    } else if (listasocio == null) {
                        JOptionPane.showMessageDialog(fp, "Não existe nenhum socio cadastrado!\nCadastre pelo mesnos um socio primeiro!");
                    } else {
                        mudascad = new ControlerPainelMudasCadastro(listaadubo, listasocio);
                        fp.addPainel(mudascad.getMudas(), Constantes.pmc);
                        fp.show(Constantes.pmc);
                    }
                    break;
//##############################################################################
                case Constantes.sociobus:
                    ArrayList<Socio> aux = SocioDAO.buscaAll();
                    if (aux != null) {
                        sociobus = new PainelSocioListar(aux);
                        fp.addPainel(sociobus, Constantes.psb);
                        fp.show(Constantes.psb);
                    } else {
                        JOptionPane.showMessageDialog(fp, "Não existe nenhum socio cadastrado!");
                    }
                    break;
//##############################################################################
                case Constantes.sociocad:
                    socio = new ControlerPainelSocio();
                    fp.addPainel(socio.getPainelSocio(), Constantes.ps);
                    fp.show(Constantes.ps);
                    break;
//##############################################################################
                case Constantes.vendarlz:
                    ArrayList<Mudas> md = MudasDAO.busca();
                    if (md != null) {
                        venda = new ControlerPainelVendaRealiza(md);
                        fp.addPainel(venda.getPainel(), Constantes.pvr);
                        fp.show(Constantes.pvr);
                    } else {
                        JOptionPane.showMessageDialog(fp, "Não existem mudas para venda!");
                    }
                    break;
//##############################################################################
                case Constantes.relatadu:
                    relatorioAdubo = new ControlerPainelRelatorioAdubo();
                    fp.addPainel(relatorioAdubo.getPainel(), Constantes.pra);
                    fp.show(Constantes.pra);
                    break;
//##############################################################################
                case Constantes.relatmud:
                    relatorioMudas = new ControlerPainelRelatorioMudas();
                    fp.addPainel(relatorioMudas.getPainel(), Constantes.prm);
                    fp.show(Constantes.prm);
                    break;
//##############################################################################
                case Constantes.relatsoc:
                    relatorioSocio = new ControlerPainelRelatorioSocio();
                    fp.addPainel(relatorioSocio.getPainel(), Constantes.prs);
                    fp.show(Constantes.prs);
                    break;
//##############################################################################
                case Constantes.relatven:
                    relatorioVenda = new ControlerPainelRelatorioVenda();
                    fp.addPainel(relatorioVenda.getPainel(), Constantes.prv);
                    fp.show(Constantes.prv);
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent event) { //
        }

        @Override
        public void keyPressed(KeyEvent event) { //Quando a tecla eh precionada
        }

        @Override
        public void keyReleased(KeyEvent event) { //Depois que a tecla eh precionada
            if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
                fp.show(Constantes.inicial);
            }
        }
    }
}