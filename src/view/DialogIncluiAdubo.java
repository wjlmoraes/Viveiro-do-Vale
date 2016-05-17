/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Adubo;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class DialogIncluiAdubo extends JDialog {

    private int height;
    private Dimension d;
    private JCheckBox nome;
    private JLabel labelNome;
    private JLabel labelQuant;
    private JPanel painel;
    private JTextField quantidade;
    private JScrollPane scroll;

    public DialogIncluiAdubo(ArrayList<Adubo> lista, ActionListener al) {
        height = 28;
        d = new Dimension(150, 28);

        labelNome = new JLabel("Nome");
        labelNome.setFont(Constantes.font);
        labelNome.setPreferredSize(d);
        labelQuant = new JLabel("Quantidade");
        labelQuant.setFont(Constantes.font);
        labelQuant.setPreferredSize(d);

        painel = new JPanel();

        painel.add(labelNome);
        painel.add(labelQuant);
        painel.setPreferredSize(new Dimension(320, height));
        
        for(int i = 0; i < lista.size(); i++){
            height += 33;
            nome = new JCheckBox(lista.get(i).getNome());
            nome.setFont(Constantes.font);
            nome.setName(String.valueOf(i));
            nome.setPreferredSize(d);
            nome.addActionListener(al);
            
            quantidade = new JTextField(String.valueOf(lista.get(i).getQuant()));
            quantidade.setEditable(false);
            quantidade.setFont(Constantes.font);
            quantidade.setPreferredSize(d);
            
            painel.add(nome);
            painel.add(quantidade);
            
            painel.setPreferredSize(new Dimension(320, height));
        }
        
        scroll = new JScrollPane();

        scroll.setViewportView(painel);

        this.add(scroll);

        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}