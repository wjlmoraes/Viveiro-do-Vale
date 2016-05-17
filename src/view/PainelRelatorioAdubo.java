/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelRelatorioAdubo extends JPanel {

    private ButtonGroup buttonGroup;
    private JButton buttonLimpar;
    private JButton buttonOk;
    private JPanel painelDados;
    private JPanel painelPesquisas;
    private JRadioButton radioButtonPesq1;
    private JRadioButton radioButtonPesq2;
    private JRadioButton radioButtonPesq3;
    private JRadioButton radioButtonPesq4;

    public PainelRelatorioAdubo(ActionListener al) {
        buttonGroup = new ButtonGroup();
        radioButtonPesq1 = new JRadioButton("Adubos gastos na plantação de uma espécie");
        radioButtonPesq2 = new JRadioButton("Adubos gastos durante um perído de tempo");
        radioButtonPesq3 = new JRadioButton("Adubos gastos na plantação das mudas disponíveis");
        radioButtonPesq4 = new JRadioButton("Todos adubos gastos até hoje");
        painelDados = new JPanel();
        painelPesquisas = new JPanel();
        buttonOk = new JButton(Constantes.ok);
        buttonLimpar = new JButton(Constantes.clean);

        buttonGroup.add(radioButtonPesq1);
        radioButtonPesq1.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq2);
        radioButtonPesq2.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq3);
        radioButtonPesq3.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq4);
        radioButtonPesq4.setFont(Constantes.font); // NOI18N

        buttonOk.setFont(Constantes.font); // NOI18N
        buttonLimpar.setFont(Constantes.font); // NOI18N

        painelPesquisas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelDados.setPreferredSize(new Dimension(565, 40));

        GroupLayout painelPesquisasLayout = new GroupLayout(painelPesquisas);
        painelPesquisas.setLayout(painelPesquisasLayout);
        painelPesquisasLayout.setHorizontalGroup(
            painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisasLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonPesq1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonPesq2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioButtonPesq3, GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(painelPesquisasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioButtonPesq4, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelPesquisasLayout.setVerticalGroup(
            painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioButtonPesq1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonPesq2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonPesq3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonPesq4)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelPesquisas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonLimpar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelDados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(painelPesquisas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonOk))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        radioButtonPesq1.addActionListener(al);
        radioButtonPesq2.addActionListener(al);
        radioButtonPesq3.addActionListener(al);
        radioButtonPesq4.addActionListener(al);
        buttonOk.addActionListener(al);
        buttonLimpar.addActionListener(al);

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }

    public void limpa(){
        painelDados.removeAll();
        painelDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelDados.setBorder(BorderFactory.createEtchedBorder());
    }
    
    public void limpaButtonGroup(){
        buttonGroup.clearSelection();
    }
    
    public void pesquisa1() {
        painelDados.removeAll();
        
        JLabel l = new JLabel("Nome da espécie:");
        l.setFont(Constantes.font);

        JTextField t = new JTextField();
        t.setFont(Constantes.font);
        t.setPreferredSize(new Dimension(150, 28));

        painelDados.add(l);
        painelDados.add(t);

        painelDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelDados.setBorder(BorderFactory.createEtchedBorder());
    }

    public void pesquisa2() {
        painelDados.removeAll();

        Dimension d = new Dimension(90, 28);

        JLabel l = new JLabel("Data Inicial:");
        l.setFont(Constantes.font);

        JFormattedTextField t = new JFormattedTextField();
        t.setFont(Constantes.font);
        t.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        t.setPreferredSize(d);

        painelDados.add(l);
        painelDados.add(t);

        l = new JLabel("Data Final:");
        l.setFont(Constantes.font);

        t = new JFormattedTextField();
        t.setFont(Constantes.font);
        t.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        t.setPreferredSize(d);

        painelDados.add(l);
        painelDados.add(t);

        painelDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelDados.setBorder(BorderFactory.createEtchedBorder());
    }
    
    public String getTextEspecie(){
        String aux = ((JTextField)painelDados.getComponent(1)).getText();
        if(aux.equals(""))
            return null;
        else
            return aux;
    }
    
    /**
     * The dates are in the formatted yyyymmdd
     * @return String[] wich first date and last date, or null, case there aren't date in the one field
     */
    public String[] getTextDatas(){
        String a = ((JFormattedTextField)painelDados.getComponent(1)).getText();
        String b = ((JFormattedTextField)painelDados.getComponent(3)).getText();
        
        String d1;
        String d2;
        
        if(a.equals(""))
            return null;
        else if(b.equals(""))
            return null;
        
        d1 = a.substring(6, 10);
        d1 += a.substring(3, 5);
        d1 += a.substring(0, 2);
        
        d2 = b.substring(6, 10);
        d2 += b.substring(3, 5);
        d2 += b.substring(0, 2);
        
        return new String[] {d1, d2};
    }
}
