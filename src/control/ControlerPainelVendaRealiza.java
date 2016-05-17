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
import model.AduboDAO;
import model.Mudas;
import model.MudasPlantadas;
import model.MudasPlantadasDAO;
import model.Venda;
import model.VendaDAO;
import model.VendaInclui;
import model.VendaIncluiDAO;
import view.DialogIncluiVenda;
import view.PainelVendaRealiza;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class ControlerPainelVendaRealiza {

    private float preco;
    private ArrayList<Float> valores;
    private ArrayList<Adubo> gasto;
    private ArrayList<Mudas> mudas;
    private ArrayList<MudasPlantadas> plantadas;
    private ArrayList<VendaInclui> vendas;
    private ArrayList<String> usados;
    private DialogIncluiVenda incluiVenda;
    private PainelVendaRealiza painel;

    public ControlerPainelVendaRealiza(ArrayList<Mudas> lista) {
        painel = new PainelVendaRealiza(new tratadorVendaRealiza());
        this.mudas = lista;
        usados = new ArrayList();
        vendas = new ArrayList();
        valores = new ArrayList();
    }

    private class tratadorVendaRealiza implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            switch (event.getActionCommand()) {
//##############################################################################
                case Constantes.add:
                    incluiVenda = new DialogIncluiVenda(new IncluiVenda(), mudas);
                    break;
//##############################################################################
                case Constantes.clean:
                    painel.Limpa();
                    usados = new ArrayList();
                    vendas = new ArrayList();
                    valores = new ArrayList();
                    break;
//##############################################################################
                case Constantes.ok:
                    if (painel.getTextData().equals("")) {
                        JOptionPane.showMessageDialog(painel, "Digite um data!");
                    } else if (usados.isEmpty()) {
                        JOptionPane.showMessageDialog(painel, "Adicione uma especie!");
                    } else {
                        int pos = VendaDAO.proxNumero();
                        if (pos != 0) {
                            VendaDAO.insere(new Venda(pos, painel.getTextData()));
                            for (int i = 0; i < vendas.size(); i++) {
                                vendas.get(i).setNumero_venda(pos);
                                VendaIncluiDAO.insere(vendas.get(i));
                            }
                            JOptionPane.showMessageDialog(painel, "Venda cadastra com sucesso!");
                        }
                    }
                    break;
//##############################################################################
                case Constantes.remove:
                    painel.remove(); //Remove do painel a ultima especie adicionada
                    usados.remove(usados.size() - 1); //Remove do array a ultima especie adicionada
                    vendas.remove(vendas.size() - 1); //Remove do array objeto VendaInclui da ultima especie adicionada
                    painel.subPrecoTotal(valores.get(valores.size() - 1)); //Subtrai o valor da ultima especie adicionada
                    valores.remove(valores.size() - 1); //Remove do array o valor da ultima especie adicionada
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

        private class IncluiVenda implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent event) {
                JCheckBox j = (JCheckBox) event.getSource();
                j.setEnabled(false);
                if (!verifica(usados, j.getName())) {
                    String aux = null;
                    while (aux == null) {
                        aux = JOptionPane.showInputDialog("Digita a quanitdade:");
                        try {
                            for (int i = 0; i < aux.length(); i++) {
                                if ('0' != aux.charAt(i)
                                        && '1' != aux.charAt(i)
                                        && '2' != aux.charAt(i)
                                        && '3' != aux.charAt(i)
                                        && '4' != aux.charAt(i)
                                        && '5' != aux.charAt(i)
                                        && '6' != aux.charAt(i)
                                        && '7' != aux.charAt(i)
                                        && '8' != aux.charAt(i)
                                        && '9' != aux.charAt(i)) {
                                    aux = null;
                                    break;
                                }
                            }
                        } catch (NullPointerException ex) {
                            aux = null;
                        }
                        try {
                            if (Integer.parseInt(aux) > mudas.get(Integer.parseInt(j.getName()) - 1).getQuantidade()) {
                                JOptionPane.showMessageDialog(painel, "Quantidade inválida!");
                                aux = null;
                            }
                        } catch (NumberFormatException e) {
                            aux = null;
                        }
                    }

                    gasto = AduboDAO.buscaPreco(mudas.get(Integer.parseInt(j.getName()) - 1).getEspecie());
                    plantadas = MudasPlantadasDAO.buscaTotal(mudas.get(Integer.parseInt(j.getName()) - 1).getEspecie());
                    preco = 0;
                    for (int i = 0; i < gasto.size(); i++) {
                        preco += (gasto.get(i).getQuant() * gasto.get(i).getPreco() / plantadas.get(0).getQuant());
                    }
                    preco += 2;
                    valores.add(Integer.parseInt(aux) * preco);
                    painel.somaPrecoTotal(Integer.parseInt(aux) * preco);
                    painel.addMudas(j.getText(), Integer.parseInt(aux), preco);
                    usados.add(j.getName());
                    vendas.add(new VendaInclui(j.getText(), 0, Integer.parseInt(aux), preco));
                } else {
                    JOptionPane.showMessageDialog(incluiVenda, "Adubo já inserido!");
                }
            }
        }
    }

    public String calcular(int quant, float valor) {
        int i;
        String aux = String.valueOf(quant * valor);
        for (i = 0; i < aux.length(); i++) {
            if ('.' == aux.charAt(i)) {
                break;
            }
        }
        if (aux.length() > i + 2) {
            return aux.substring(0, i + 3);
        } else {
            return aux.substring(0, aux.length());
        }
    }

    /**
     * @return the painel
     */
    public PainelVendaRealiza getPainel() {
        return painel;
    }
}