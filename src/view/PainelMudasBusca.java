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
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import model.Mudas;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelMudasBusca extends JPanel {
    
    private JButton buttonBuscar;
    private JButton buttonCancelar;
    private JButton buttonLimpar;
    private JButton buttonTodas;
    private JLabel labelNome;
    private JPanel painelResultado;
    private JScrollPane scrollPane;
    private JSeparator separador;
    private JFormattedTextField textNome;
    
    public PainelMudasBusca(ActionListener al) {
        
        labelNome = new JLabel("Nome:");
        
        textNome = new JFormattedTextField();
        
        buttonTodas = new JButton(Constantes.all);
        buttonBuscar = new JButton(Constantes.search);
        buttonLimpar = new JButton(Constantes.clean);
        buttonCancelar = new JButton(Constantes.cancel);
        
        separador = new JSeparator();
        
        scrollPane = new JScrollPane();
        
        painelResultado = new JPanel();
        
        labelNome.setFont(Constantes.font); // NOI18N

        textNome.setFont(Constantes.font); // NOI18N

        buttonTodas.setFont(Constantes.font); // NOI18N

        buttonBuscar.setFont(Constantes.font); // NOI18N

        buttonLimpar.setFont(Constantes.font); // NOI18N

        buttonCancelar.setFont(Constantes.font); // NOI18N

        scrollPane.setViewportView(painelResultado);
        
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNome)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textNome)
                .addGap(44, 44, 44)
                .addComponent(buttonTodas, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBuscar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimpar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancelar)
                .addContainerGap())
                .addComponent(separador, GroupLayout.Alignment.TRAILING)
                .addComponent(scrollPane, GroupLayout.Alignment.TRAILING));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(labelNome)
                .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(buttonCancelar)
                .addComponent(buttonLimpar)
                .addComponent(buttonBuscar)
                .addComponent(buttonTodas))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane)));
        
        buttonBuscar.addActionListener(al);
        buttonCancelar.addActionListener(al);
        buttonLimpar.addActionListener(al);
        buttonTodas.addActionListener(al);
        
        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }
    
    public JTextField label(String nome) {
        JTextField l = new JTextField(nome);
        l.setEditable(false);
        l.setFont(Constantes.font);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setPreferredSize(new Dimension(350, 28));
        l.setVisible(true);
        return l;
    }
    
    public void addMuda(ArrayList<Mudas> obj) {
        int height = 33;
        for (int i = 0; i < obj.size(); i++) {
            JTextField l = label(obj.get(i).getEspecie());
            painelResultado.add(l);
            
            l = label(String.valueOf(obj.get(i).getQuantidade()));
            painelResultado.add(l);
            
            height += 33;
        }
        
        painelResultado.setPreferredSize(new Dimension(610, height));
        scrollPane.setViewportView(painelResultado);
    }
    
    public void RemoveAll() {
        painelResultado.removeAll();
        scrollPane.setViewportView(painelResultado);
    }

    /**
     * @return the painelResultado
     */
    public JPanel getPainelResultado() {
        return painelResultado;
    }

    /**
     * @param painelResultado the painelResultado to set
     */
    public void setPainelResultado(JPanel painelResultado) {
        this.painelResultado = painelResultado;
        scrollPane.setViewportView(this.painelResultado);
    }
    
    public void setTextNome(boolean action) {
        textNome.setEditable(action);
    }

    /**
     * @return the textNome
     */
    public String getTextNome() {
        return textNome.getText();
    }

    /**
     * @param textNome the textNome to set
     */
    public void setTextNome(String textNome) {
        this.textNome.setText(textNome);
    }
}