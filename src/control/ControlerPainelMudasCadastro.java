/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.Adubo;
import model.AduboGasto;
import model.AduboGastoDAO;
import model.Mudas;
import model.MudasDAO;
import model.MudasPlantadas;
import model.MudasPlantadasDAO;
import model.Socio;
import model.SocioTrabalhou;
import model.SocioTrabalhouDAO;
import view.DialogIncluiAdubo;
import view.DialogIncluiSocio;
import view.PainelMudasCadastro;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelMudasCadastro {

    private int i;
    private boolean marcou;
    private DialogIncluiAdubo incluiAdubo;
    private DialogIncluiSocio incluiSocio;
    private PainelMudasCadastro mudas;
    private ArrayList<Adubo> adubo;
    private ArrayList<AduboGasto> gasto;
    private ArrayList<Socio> socio;
    private ArrayList<SocioTrabalhou> trabalhou;
    private ArrayList<String> adubosUsados;
    private ArrayList<String> sociosTrabalhou;

    public ControlerPainelMudasCadastro(ArrayList<Adubo> adubo, ArrayList<Socio> socio) {

        mudas = new PainelMudasCadastro(new tratadorMusdasCadastro());

        this.adubo = adubo;
        this.socio = socio;

        adubosUsados = new ArrayList();
        sociosTrabalhou = new ArrayList();
    }

    public class tratadorMusdasCadastro implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.ok:
                    if (mudas.getTextData().equals("")) {
                        JOptionPane.showMessageDialog(mudas, "Digite uma data!");
                    } else if (mudas.getTextEspecie().equals("")) {
                        JOptionPane.showMessageDialog(mudas, "Digite o nome da espécie!");
                    } else if (mudas.getTextQuantidade().equals("")) {
                        JOptionPane.showMessageDialog(mudas, "Digite a quantidade de mudas!");
                    } else if (adubosUsados.isEmpty()) {
                        JOptionPane.showMessageDialog(mudas, "Insira os adubos utilizados!");
                    } else if (sociosTrabalhou.isEmpty()) {
                        JOptionPane.showMessageDialog(mudas, "Insira os socio que trabalharam!");
                    } else {
                        gasto = new ArrayList();
                        marcou = true;
                        for (i = 0; i < adubosUsados.size(); i++) {
                            if (mudas.getTextQuantidadeAdubo(i + 1).equals("")) {
                                JOptionPane.showMessageDialog(mudas, "Digite a quantidade\nde adubo utilizada");
                                marcou = false;
                                break;
                            } else if (Float.parseFloat(mudas.getTextQuantidadeAdubo(i + 1)) > adubo.get(i).getQuant()) {
                                JOptionPane.showMessageDialog(mudas, "Adubo insuficiente!");
                                marcou = false;
                                break;
                            } else {
                                float quant = Float.parseFloat(mudas.getTextQuantidadeAdubo(i + 1));
                                String data = mudas.getTextData();
                                String especie = mudas.getTextEspecie();
                                String nomeAdubo = adubo.get(Integer.parseInt(adubosUsados.get(i))).getNome();
                                AduboGasto aux = new AduboGasto(quant, especie, nomeAdubo, data);
                                gasto.add(aux);
                            }
                        }
                        if (marcou) {
                            trabalhou = new ArrayList();
                            for (i = 0; i < sociosTrabalhou.size(); i++) {
                                if (mudas.getTextHorasSocio(i + 1).equals("")) {
                                    JOptionPane.showMessageDialog(mudas, "Digite a quantidade\nde hora trabalhadas!");
                                    marcou = false;
                                    break;
                                } else {
                                    String cpf = socio.get(Integer.parseInt(sociosTrabalhou.get(i))).getCpf();
                                    String especie = mudas.getTextEspecie();
                                    String data = mudas.getTextData();
                                    String horas = mudas.getTextHorasSocio(i + 1);
                                    SocioTrabalhou aux = new SocioTrabalhou(cpf, especie, data, horas);
                                    trabalhou.add(aux);
                                }
                            }
                        }

                        if (marcou) { //Tudo ok, podemos começar a inserir os dados na base
                            MudasDAO.insere(new Mudas(mudas.getTextEspecie(), Integer.parseInt(mudas.getTextQuantidade())));
                            MudasPlantadasDAO.insere(new MudasPlantadas(Integer.parseInt(mudas.getTextQuantidade()), mudas.getTextEspecie(), mudas.getTextData()));
                            for (i = 0; i < gasto.size(); i++) {
                                AduboGastoDAO.insere(gasto.get(i));
                            }
                            for (i = 0; i < trabalhou.size(); i++) {
                                SocioTrabalhouDAO.insere(trabalhou.get(i));
                            }
                            JOptionPane.showMessageDialog(incluiSocio, "Inserção realiza com sucesso!");
                            mudas.Limpa();
                            adubosUsados = new ArrayList();
                            sociosTrabalhou = new ArrayList();
                        }
                    }
                    break;
//##############################################################################
                case Constantes.clean:
                    mudas.Limpa();
                    adubosUsados = new ArrayList();
                    sociosTrabalhou = new ArrayList();
                    break;
//##############################################################################
                case "+ Adubo":
                    incluiAdubo = new DialogIncluiAdubo(adubo, new IncluiAdubo());
                    break;
//##############################################################################
                case "- Adubo":
                    mudas.removeAdubo();
                    adubosUsados.remove(adubosUsados.size() - 1);
                    break;
//##############################################################################
                case "+ Socio":
                    incluiSocio = new DialogIncluiSocio(socio, new IncluiSocio());
                    break;
//##############################################################################
                case "- Socio":
                    sociosTrabalhou.remove(sociosTrabalhou.size() - 1);
                    mudas.removeSocio();
                    break;
            }
        }

        private boolean verifica(ArrayList<String> lista, String num) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).equals(num)) {
                    return true;
                }
            }
            return false;
        }

        private class IncluiAdubo implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox j = (JCheckBox) event.getSource();
                j.setEnabled(false);
                if (!verifica(adubosUsados, j.getName())) {
                    adubosUsados.add(j.getName());
                    mudas.addAdubo(j.getText());
                } else {
                    JOptionPane.showMessageDialog(incluiAdubo, "Adubo já inserido!");
                }
            }
        }

        private class IncluiSocio implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox j = (JCheckBox) event.getSource();
                j.setEnabled(false);
                if (!verifica(sociosTrabalhou, j.getName())) {
                    sociosTrabalhou.add(j.getName());
                    mudas.addSocio(j.getText());
                } else {
                    JOptionPane.showMessageDialog(incluiSocio, "Socio já inserido!");
                }
            }
        }
    }

    /**
     * @return the mudas
     */
    public PainelMudasCadastro getMudas() {
        return mudas;
    }
}