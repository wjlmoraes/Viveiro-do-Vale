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
import model.Socio;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelSocioListar extends JPanel {

    private int height;
    private Dimension dNome;
    private Dimension dCptTel;
    private JLabel labelSocio;
    private JLabel labelCpf;
    private JLabel labelNome;
    private JLabel labelTelefone;
    private JPanel painelAdubo;
    private JScrollPane scrollPane;
    private JTextField cpf;
    private JTextField nome;
    private JTextField telefone;

    public PainelSocioListar(ArrayList<Socio> lista) {
        height = 28;
        labelSocio = new JLabel("Lista de socios");
        scrollPane = new JScrollPane();
        painelAdubo = new JPanel();

        labelSocio.setFont(new Font("Times New Roman", Font.ITALIC, 28)); // NOI18
        labelSocio.setHorizontalAlignment(SwingConstants.CENTER);

        dNome = new Dimension(420, 28);
        dCptTel = new Dimension(125, 28);

        labelCpf = new JLabel("CPF");
        labelCpf.setFont(Constantes.font);
        labelCpf.setHorizontalAlignment(SwingConstants.CENTER);
        labelCpf.setPreferredSize(dCptTel);
        labelNome = new JLabel("Nome");
        labelNome.setFont(Constantes.font);
        labelNome.setHorizontalAlignment(SwingConstants.CENTER);
        labelNome.setPreferredSize(dNome);
        labelTelefone = new JLabel("Telefone");
        labelTelefone.setFont(Constantes.font);
        labelTelefone.setHorizontalAlignment(SwingConstants.CENTER);
        labelTelefone.setPreferredSize(dCptTel);

        painelAdubo.add(labelCpf);
        painelAdubo.add(labelNome);
        painelAdubo.add(labelTelefone);
        painelAdubo.setPreferredSize(new Dimension(660, height));

        for (int i = 0; i < lista.size(); i++) {
            height += 34;

            cpf = new JTextField(lista.get(i).getCpf());
            cpf.setEditable(false);
            cpf.setFont(Constantes.font);
            cpf.setPreferredSize(dCptTel);

            nome = new JTextField(lista.get(i).getNome());
            nome.setEditable(false);
            nome.setFont(Constantes.font);
            nome.setPreferredSize(dNome);

            telefone = new JTextField(String.valueOf(lista.get(i).getTelefone()));
            telefone.setEditable(false);
            telefone.setFont(Constantes.font);
            telefone.setPreferredSize(dCptTel);

            painelAdubo.add(cpf);
            painelAdubo.add(nome);
            painelAdubo.add(telefone);
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
                    .addComponent(labelSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelSocio)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane)
                .addContainerGap())
        );

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }
}