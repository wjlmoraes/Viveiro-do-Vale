/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
import javax.swing.text.MaskFormatter;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelRelatorioSocio extends JPanel {

    private ButtonGroup buttonGroup;
    private JButton buttonLimpar;
    private JButton buttonOk;
    private JPanel painelDados;
    private JPanel painelPesquisas;
    private JRadioButton radioButtonPesq1;
    private JRadioButton radioButtonPesq2;
    private JRadioButton radioButtonPesq3;
    private JRadioButton radioButtonPesq4;

    public PainelRelatorioSocio(ActionListener al) {

        buttonGroup = new ButtonGroup();
        painelDados = new JPanel();
        painelPesquisas = new JPanel();
        radioButtonPesq1 = new JRadioButton("Socio que trabalharam no plantio de uma especie");
        radioButtonPesq2 = new JRadioButton("Socios que trabalharam em um perído de tempo");
        radioButtonPesq3 = new JRadioButton("Horas que um socio trabalhou em um período");
        radioButtonPesq4 = new JRadioButton("Horas total que um socio trabalhou");
        buttonLimpar = new JButton(Constantes.clean);
        buttonOk = new JButton(Constantes.ok);

        buttonLimpar.setFont(Constantes.font); // NOI18N
        buttonOk.setFont(Constantes.font); // NOI18N

        painelPesquisas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelDados.setPreferredSize(new Dimension(565, 40));

        buttonGroup.add(radioButtonPesq1);
        radioButtonPesq1.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq2);
        radioButtonPesq2.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq3);
        radioButtonPesq3.setFont(Constantes.font); // NOI18N

        buttonGroup.add(radioButtonPesq4);
        radioButtonPesq4.setFont(Constantes.font); // NOI18N

        GroupLayout painelPesquisasLayout = new GroupLayout(painelPesquisas);
        painelPesquisas.setLayout(painelPesquisasLayout);
        painelPesquisasLayout.setHorizontalGroup(
            painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelPesquisasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(painelPesquisasLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonPesq1, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButtonPesq2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelPesquisasLayout.createSequentialGroup()
                        .addGroup(painelPesquisasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(radioButtonPesq4, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioButtonPesq3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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

    public void limpa() {
        painelDados.removeAll();
        buttonGroup.clearSelection();
        painelDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelDados.setBorder(BorderFactory.createEtchedBorder());
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

    public void pesquisa3() {
        painelDados.removeAll();

        Dimension d = new Dimension(90, 28);

        JLabel l = new JLabel("CPF:");
        l.setFont(Constantes.font);

        JFormattedTextField t = new JFormattedTextField();
        t.setFont(Constantes.font);
        try {
            t.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        t.setPreferredSize(new Dimension(125, 28));

        painelDados.add(l);
        painelDados.add(t);

        l = new JLabel("Data Inicial:");
        l.setFont(Constantes.font);

        t = new JFormattedTextField();
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

    public void pesquisa4() {
        painelDados.removeAll();

        JLabel l = new JLabel("CPF do socio:");
        l.setFont(Constantes.font);

        JFormattedTextField t = new JFormattedTextField();
        t.setFont(Constantes.font);
        try {
            t.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        t.setPreferredSize(new Dimension(150, 28));

        painelDados.add(l);
        painelDados.add(t);

        painelDados.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        painelDados.setBorder(BorderFactory.createEtchedBorder());
    }

    public String getTextEspecie() {
        String aux = ((JTextField) painelDados.getComponent(1)).getText();
        if (aux.equals("")) {
            return null;
        } else {
            return aux;
        }
    }

    public String[] getTextDatas() {
        String a = ((JFormattedTextField) painelDados.getComponent(1)).getText();
        String b = ((JFormattedTextField) painelDados.getComponent(3)).getText();
        String d1, d2;
        if (a.equals("")) {
            return null;
        } else if (b.equals("")) {
            return null;
        }

        d1 = a.substring(6, 10);
        d1 += a.substring(3, 5);
        d1 += a.substring(0, 2);

        d2 = b.substring(6, 10);
        d2 += b.substring(3, 5);
        d2 += b.substring(0, 2);

        return new String[]{d1, d2};
    }

    public String[] getTextCpfDatas() {
        String a = ((JFormattedTextField) painelDados.getComponent(1)).getText();
        String b = ((JFormattedTextField) painelDados.getComponent(3)).getText();
        String c = ((JFormattedTextField) painelDados.getComponent(5)).getText();
        String d1, d2;
        if (a.equals("   .   .   -  ")) {
            return null;
        }
        if (b.equals("")) {
            return null;
        }
        if (c.equals("")) {
            return null;
        }

        d1 = b.substring(6, 10);
        d1 += b.substring(3, 5);
        d1 += b.substring(0, 2);

        d2 = c.substring(6, 10);
        d2 += c.substring(3, 5);
        d2 += c.substring(0, 2);

        return new String[]{a, d1, d2};
    }

    public String getTextCpf() {
        String a = ((JFormattedTextField) painelDados.getComponent(1)).getText();
        if (a.equals("   .   .   -  ")) {
            return null;
        }
        return a;
    }
}
