/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import model.Mudas;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class DialogIncluiVenda extends JDialog {

    private int height;
    private JLabel labelTitulo;
    private JButton buttonCancelar;
    private JButton buttonOk;
    private JCheckBox checkBox;
    private JPanel painelListaMudas;
    private JScrollPane scrollPaneListaMudas;
    private JTextField textEspecie;

    public DialogIncluiVenda(ActionListener al, ArrayList<Mudas> lista) {

        height = 34;
        labelTitulo = new JLabel();
        scrollPaneListaMudas = new JScrollPane();
        painelListaMudas = new JPanel();

        labelTitulo.setFont(Constantes.font); // NOI18N
        labelTitulo.setText("Relação de mudas do viveiro");

        buttonCancelar = new JButton(Constantes.cancel);
        buttonOk = new JButton(Constantes.ok);

        painelListaMudas.setPreferredSize(new Dimension(300, 33));

        for (int i = 0; i < lista.size(); i++) {
            checkBox = new JCheckBox(lista.get(i).getEspecie());
            checkBox.addActionListener(al);
            checkBox.setFont(Constantes.font);
            checkBox.setName(String.valueOf(i + 1));
            checkBox.setPreferredSize(new Dimension(140, 28));

            textEspecie = new JTextField();
            textEspecie.setEditable(false);
            textEspecie.setFont(Constantes.font);
            textEspecie.setHorizontalAlignment(SwingConstants.CENTER);
            textEspecie.setPreferredSize(new Dimension(140, 28));
            textEspecie.setText(String.valueOf(lista.get(i).getQuantidade()));

            painelListaMudas.add(checkBox);
            painelListaMudas.add(textEspecie);
            
            height += 33;
        }
        
        painelListaMudas.setPreferredSize(new Dimension(398, height));

        scrollPaneListaMudas.setViewportView(painelListaMudas);

        buttonCancelar.setFont(Constantes.font); // NOI18N

        buttonOk.setFont(Constantes.font); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(labelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scrollPaneListaMudas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPaneListaMudas))
        );

        pack();

        buttonCancelar.addActionListener(al);
        buttonOk.addActionListener(al);

        this.setModal(true);
        this.setDefaultCloseOperation(DialogIncluiVenda.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(400, 500));
        this.setResizable(false);
        this.setTitle("Incluir mudas");
        this.setVisible(true);
    }

    /**
     * @return the painelListaMudas
     */
    public JPanel getPainelListaMudas() {
        return painelListaMudas;
    }

    /**
     * @param painelListaMudas the painelListaMudas to set
     */
    public void setPainelListaMudas(JPanel painelListaMudas) {
        this.painelListaMudas = painelListaMudas;
        scrollPaneListaMudas.setViewportView(this.painelListaMudas);
    }
}