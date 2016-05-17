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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import model.Mudas;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioMudas extends JDialog {
    
    private int height;
    private Dimension dNome;
    private Dimension dQuant;
    private Dimension dPreco;
    private JFormattedTextField textNome;
    private JFormattedTextField textQuant;
    private JFormattedTextField textData;
    private JLabel textoTitulo;
    private JPanel painel;
    private JScrollPane scroll;
    private JScrollPane scrollDescricao;
    private JTextArea textDescricao;

    public DialogRelatorioMudas() { }

    public DialogRelatorioMudas(ArrayList<Mudas> lista) {

        height = 33;

        painel = new JPanel();
        scroll = new JScrollPane();
        scrollDescricao = new JScrollPane();

        textoTitulo = new JLabel();
        textoTitulo.setFont(Constantes.font);
        painel.add(textoTitulo);

        textDescricao = new JTextArea();
        textDescricao.setEditable(false);
        textDescricao.setFont(Constantes.font);
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);
        
        scrollDescricao.setPreferredSize(new Dimension(385, 100));
        scrollDescricao.setViewportView(textDescricao);

        painel.add(scrollDescricao);

        dNome = new Dimension(125, 28);
        dQuant = new Dimension(125, 28);
        dPreco = new Dimension(125, 28);

        textNome = new JFormattedTextField("Nome");
        textNome.setEditable(false);
        textNome.setFont(Constantes.font);
        textNome.setHorizontalAlignment(SwingConstants.CENTER);
        textNome.setPreferredSize(dNome);

        textQuant = new JFormattedTextField("Quantidade");
        textQuant.setEditable(false);
        textQuant.setFont(Constantes.font);
        textQuant.setHorizontalAlignment(SwingConstants.CENTER);
        textQuant.setPreferredSize(dQuant);

        textData = new JFormattedTextField("Data");
        textData.setEditable(false);
        textData.setFont(Constantes.font);
        textData.setHorizontalAlignment(SwingConstants.CENTER);
        textData.setPreferredSize(dPreco);

        painel.add(textNome);
        painel.add(textQuant);
        painel.add(textData);

        height += 33;

        for (int i = 0; i < lista.size(); i++) {
            textNome = new JFormattedTextField(lista.get(i).getEspecie());
            textNome.setEditable(false);
            textNome.setFont(Constantes.font);
            textNome.setPreferredSize(dNome);

            textQuant = new JFormattedTextField(String.valueOf(lista.get(i).getQuantidade()));
            textQuant.setEditable(false);
            textQuant.setFont(Constantes.font);
            textQuant.setHorizontalAlignment(SwingConstants.CENTER);
            textQuant.setPreferredSize(dQuant);

            textData = new JFormattedTextField(lista.get(i).getData());
            textData.setEditable(false);
            textData.setFont(Constantes.font);
            textData.setHorizontalAlignment(SwingConstants.CENTER);
            textData.setPreferredSize(dPreco);

            painel.add(textNome);
            painel.add(textQuant);
            painel.add(textData);

            height += 33;
        }

        painel.setPreferredSize(new Dimension(500, height + 100));
        if(height > 528)
            scroll.setPreferredSize(new Dimension(600, 628));
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
    
    public void setTextoTitulo(String text){
        textoTitulo.setText(text);
    }
    
    public void setTextoDescricao(String text){
        textDescricao.setText(text);
        scrollDescricao.setViewportView(textDescricao);
    }
}