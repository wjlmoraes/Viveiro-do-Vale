/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import model.VendaInclui;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioVenda extends JDialog {

    private boolean p;
    private int venda;
    private int height;
    private float preco;
    private Dimension dEspecie;
    private Dimension dQuant;
    private Dimension dPreco;
    private JFormattedTextField textEspecie;
    private JFormattedTextField textQuant;
    private JFormattedTextField textPreco;
    private JLabel labelVenda;
    private JLabel labelValor;
    private JLabel labelTitulo;
    private JPanel painel;
    private JScrollPane scroll;
    private VendaInclui aux;

    public DialogRelatorioVenda() {
    }

    public DialogRelatorioVenda(ArrayList<VendaInclui> lista) {

        height = 33;

        labelTitulo = new JLabel();
        labelTitulo.setFont(Constantes.font);
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setPreferredSize(new Dimension(450, 28));

        painel = new JPanel();
        painel.add(labelTitulo);

        scroll = new JScrollPane();

        dEspecie = new Dimension(250, 28);
        dPreco = new Dimension(125, 28);
        dQuant = new Dimension(125, 28);

        venda = 0;
        preco = 0;
        p = false;

        for (int i = 0; i < lista.size(); i++) {

            aux = lista.get(i);

            if (aux.getNumero_venda() != venda) {
                labelVenda = new JLabel("Número da venda: " + aux.getNumero_venda() + ".");
                labelVenda.setFont(Constantes.font);
                labelVenda.setPreferredSize(dEspecie);

                if (labelValor != null) {
                    labelValor.setText("Valor total: " + PontoPorVirgula(String.valueOf(preco)) + ".");
                preco = 0;
                }
                labelValor = new JLabel();
                labelValor.setFont(Constantes.font);
                labelValor.setPreferredSize(dEspecie);

                painel.add(labelVenda);
                painel.add(labelValor);

                height += 33;
                venda = aux.getNumero_venda();
            }

            preco += (aux.getPreco() * aux.getQuantidade());

            textEspecie = new JFormattedTextField(aux.getEspecie());
            textEspecie.setEditable(false);
            textEspecie.setFont(Constantes.font);
            textEspecie.setPreferredSize(dEspecie);

            textQuant = new JFormattedTextField(String.valueOf(aux.getQuantidade()));
            textQuant.setEditable(false);
            textQuant.setFont(Constantes.font);
            textQuant.setPreferredSize(dQuant);

            textPreco = new JFormattedTextField(PontoPorVirgula(String.valueOf(aux.getPreco() * aux.getQuantidade())));
            textPreco.setEditable(false);
            textPreco.setFont(Constantes.font);
            textPreco.setPreferredSize(dPreco);

            painel.add(textEspecie);
            painel.add(textQuant);
            painel.add(textPreco);

            height += 33;
        }
        labelValor.setText("Valor total: " + PontoPorVirgula(String.valueOf(preco)) + ".");

        painel.setPreferredSize(new Dimension(600, height));
        if(height > 528)
            scroll.setPreferredSize(new Dimension(700, 628));
        scroll.setViewportView(painel);

        this.add(scroll);

        this.pack();
        this.setDefaultCloseOperation(DialogRelatorioAdubo.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private static String PontoPorVirgula(String aux) {
        String res;
        int i;
        for (i = 0; i < aux.length(); i++) {
            if (aux.substring(i, i + 1).equals(".")) {
                break;
            }
        }
        res = aux.substring(0, i);
        res += ",";
        if (aux.length() > (i + 3)) {
            res += aux.substring(i + 1, i + 3);
        } else {
            res += aux.substring(i + 1, aux.length());
        }
        return res;
    }

    public void setTextoTitulo(String text) {
        labelTitulo.setText(text);
    }
}