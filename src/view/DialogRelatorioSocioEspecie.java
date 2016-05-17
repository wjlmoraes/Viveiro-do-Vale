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
import model.SocioTrabalhou;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class DialogRelatorioSocioEspecie extends JDialog {

    private int height;
    private Dimension dNome;
    private Dimension dHoras;
    private Dimension dPreco;
    private JFormattedTextField textNome;
    private JFormattedTextField textData;
    private JFormattedTextField textHora;
    private JLabel textoTitulo;
    private JPanel painel;
    private JScrollPane scroll;
    private JScrollPane scrollDescricao;
    private JTextArea textDescricao;

    public DialogRelatorioSocioEspecie(ArrayList<SocioTrabalhou> lista, String especie) {

        height = 33;

        painel = new JPanel();
        scroll = new JScrollPane();
        scrollDescricao = new JScrollPane();

        textoTitulo = new JLabel("Socios que trabalho no plantio da especie " + especie + ".");
        textoTitulo.setFont(Constantes.font);
        painel.add(textoTitulo);

        textDescricao = new JTextArea("     Este relatório contém informações dos "
                + "socios que trabalharam na produção das mudas da espécie " + especie + " "
                + "bem como a data do plantio e as horas trabalhadas nesta data.");
        textDescricao.setEditable(false);
        textDescricao.setFont(Constantes.font);
        textDescricao.setLineWrap(true);
        textDescricao.setWrapStyleWord(true);

        scrollDescricao.setPreferredSize(new Dimension(385, 100));
        scrollDescricao.setViewportView(textDescricao);

        painel.add(scrollDescricao);

        dNome = new Dimension(250, 28);
        dHoras = new Dimension(125, 28);
        dPreco = new Dimension(125, 28);

        textNome = new JFormattedTextField("Nome");
        textNome.setEditable(false);
        textNome.setFont(Constantes.font);
        textNome.setHorizontalAlignment(SwingConstants.CENTER);
        textNome.setPreferredSize(dNome);

        textData = new JFormattedTextField("Data");
        textData.setEditable(false);
        textData.setFont(Constantes.font);
        textData.setHorizontalAlignment(SwingConstants.CENTER);
        textData.setPreferredSize(dPreco);

        textHora = new JFormattedTextField("Horas");
        textHora.setEditable(false);
        textHora.setFont(Constantes.font);
        textHora.setHorizontalAlignment(SwingConstants.CENTER);
        textHora.setPreferredSize(dHoras);

        painel.add(textNome);
        painel.add(textData);
        painel.add(textHora);

        height += 33;

        for (int i = 0; i < lista.size(); i++) {
            textNome = new JFormattedTextField(lista.get(i).getCpf());
            textNome.setEditable(false);
            textNome.setFont(Constantes.font);
            textNome.setPreferredSize(dNome);

            textData = new JFormattedTextField(Data(lista.get(i).getData()));
            textData.setEditable(false);
            textData.setFont(Constantes.font);
            textData.setHorizontalAlignment(SwingConstants.CENTER);
            textData.setPreferredSize(dPreco);

            textHora = new JFormattedTextField(lista.get(i).getHora());
            textHora.setEditable(false);
            textHora.setFont(Constantes.font);
            textHora.setHorizontalAlignment(SwingConstants.CENTER);
            textHora.setPreferredSize(dPreco);

            painel.add(textNome);
            painel.add(textData);
            painel.add(textHora);

            height += 33;
        }

        painel.setPreferredSize(new Dimension(600, height + 100));
        if(height > 528)
            scroll.setPreferredSize(new Dimension(700, 628));
        scroll.setViewportView(painel);

        this.add(scroll);

        this.pack();
        this.setDefaultCloseOperation(DialogRelatorioAdubo.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private static String Data(String aux) {
        return aux.substring(6, 8) + "/" + aux.substring(4, 6) + "/" + aux.substring(0, 4);
    }
}