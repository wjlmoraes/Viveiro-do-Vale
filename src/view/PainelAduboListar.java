/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import model.Adubo;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelAduboListar extends JPanel {

    private int height;
    private Dimension d;
    private JLabel labelAdubos;
    private JPanel painelAdubo;
    private JScrollPane scrollPane;
    private JLabel labelNome;
    private JLabel labelQuant;
    private JLabel labelPreco;
    private JTextField nome;
    private JTextField quant;
    private JTextField preco;

    public PainelAduboListar(ArrayList<Adubo> lista) {
        height = 28;
        labelAdubos = new JLabel("Lista de Adubos");
        scrollPane = new JScrollPane();
        painelAdubo = new JPanel();

        labelAdubos.setFont(new Font("Times New Roman", Font.ITALIC, 28)); // NOI18N
        labelAdubos.setHorizontalAlignment(SwingConstants.CENTER);

        d = new Dimension(210, 28);
        labelNome = new JLabel("Nome");
        labelNome.setFont(Constantes.font);
        labelNome.setPreferredSize(d);
        labelQuant = new JLabel("Quantidade");
        labelQuant.setFont(Constantes.font);
        labelQuant.setPreferredSize(d);
        labelPreco = new JLabel("Preço por Kg");
        labelPreco.setFont(Constantes.font);
        labelPreco.setPreferredSize(d);

        painelAdubo.add(labelNome);
        painelAdubo.add(labelQuant);
        painelAdubo.add(labelPreco);
        painelAdubo.setPreferredSize(new Dimension(660, height));

        for (int i = 0; i < lista.size(); i++) {
            height += 34;

            nome = new JTextField(lista.get(i).getNome());
            nome.setEditable(false);
            nome.setFont(Constantes.font);
            nome.setPreferredSize(d);

            quant = new JTextField(String.valueOf(lista.get(i).getQuant()));
            quant.setEditable(false);
            quant.setFont(Constantes.font);
            quant.setPreferredSize(d);

            preco = new JTextField(String.valueOf(lista.get(i).getPreco()));
            preco.setEditable(false);
            preco.setFont(Constantes.font);
            preco.setPreferredSize(d);

            painelAdubo.add(nome);
            painelAdubo.add(quant);
            painelAdubo.add(preco);
        }

        painelAdubo.setPreferredSize(new Dimension(660, height));

        scrollPane.setViewportView(painelAdubo);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(scrollPane)
                .addComponent(labelAdubos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelAdubos)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane)
                .addContainerGap()));

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }
}