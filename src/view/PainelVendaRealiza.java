/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelVendaRealiza extends JPanel {

    private int height;
    private float preco;
    private JButton buttonAdicionar;
    private JButton buttonLimpar;
    private JButton buttonOk;
    private JButton buttonRemover;
    private JLabel labelData;
    private JLabel labelEspécie;
    private JLabel labelQuantidade;
    private JLabel labelPreco;
    private JLabel labelValor;
    private JPanel painel;
    private JScrollPane scroll;
    private JSeparator separador;
    private JFormattedTextField textData;
    private JFormattedTextField textValor;

    public PainelVendaRealiza(ActionListener al) {

        height = 33;
        preco = 0;

        separador = new JSeparator();

        labelData = new JLabel("Data:");
        labelValor = new JLabel("Valor:");
        labelEspécie = new JLabel("Espécie:");
        labelQuantidade = new JLabel("Quantidade:");
        labelPreco = new JLabel("Preço:");

        textData = new JFormattedTextField();
        textValor = new JFormattedTextField();

        buttonLimpar = new JButton(Constantes.clean);
        buttonOk = new JButton(Constantes.ok);
        buttonRemover = new JButton(Constantes.remove);
        buttonAdicionar = new JButton(Constantes.add);

        scroll = new JScrollPane();

        painel = new JPanel();

        separador.setOrientation(SwingConstants.VERTICAL);

        labelData.setFont(Constantes.font); // NOI18N
        labelData.setHorizontalAlignment(SwingConstants.CENTER);

        labelValor.setFont(Constantes.font); // NOI18N
        labelValor.setHorizontalAlignment(SwingConstants.CENTER);

        labelEspécie.setFont(Constantes.font); // NOI18N
        labelEspécie.setHorizontalAlignment(SwingConstants.CENTER);

        labelQuantidade.setFont(Constantes.font); // NOI18N
        labelQuantidade.setHorizontalAlignment(SwingConstants.CENTER);

        labelPreco.setFont(Constantes.font); // NOI18N
        labelPreco.setHorizontalAlignment(SwingConstants.CENTER);

        textData.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        textData.setHorizontalAlignment(JTextField.CENTER);
        textData.setFont(Constantes.font); // NOI18N

        textValor.setEditable(false);
        textValor.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        textValor.setHorizontalAlignment(JTextField.CENTER);
        textValor.setFont(Constantes.font); // NOI18N

        buttonLimpar.setFont(Constantes.font); // NOI18N

        buttonOk.setFont(Constantes.font); // NOI18N

        buttonRemover.setEnabled(false);
        buttonRemover.setFont(Constantes.font); // NOI18N

        buttonAdicionar.setFont(Constantes.font); // NOI18N

        painel.setPreferredSize(new Dimension(435, 237));

        scroll.setViewportView(painel);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(buttonOk, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpar))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelData, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textData, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(labelValor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textValor, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelEspécie, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPreco, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRemover)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAdicionar)
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separador)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEspécie)
                            .addComponent(labelQuantidade)
                            .addComponent(labelPreco))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAdicionar)
                            .addComponent(buttonRemover)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labelData)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelValor)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonLimpar)
                            .addComponent(buttonOk))))
                .addContainerGap())
        );

        buttonLimpar.addActionListener(al);
        buttonOk.addActionListener(al);
        buttonRemover.addActionListener(al);
        buttonAdicionar.addActionListener(al);

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }

    public void Limpa() {
        textData.setValue(null);
        textValor.setValue(null);
        buttonRemover.setEnabled(false);
        painel.removeAll();
        scroll.setViewportView(painel);
    }

    public String getTextData() {
        return textData.getText();
    }

    public void addMudas(String especie, int quant, float valor) {
        if (height == 33) {
            buttonRemover.setEnabled(true);
        }
        int i;
        String res;
        String aux = String.valueOf(quant * valor);
        for (i = 0; i < aux.length(); i++) {
            if ('.' == aux.charAt(i)) {
                break;
            }
        }
        res = aux.substring(0, i);
        res += ",";
        if (aux.length() > i + 3) {
            res += aux.substring(i + 1, i + 3);
        } else {
            res += aux.substring(i+1, aux.length());
        }

        Dimension d = new Dimension(125, 28);

        JFormattedTextField text1 = new JFormattedTextField(especie);
        text1.setEditable(false);
        text1.setFont(Constantes.font);
        text1.setPreferredSize(d);

        JFormattedTextField text2 = new JFormattedTextField();
        text2.setEditable(false);
        text2.setFont(Constantes.font);
        text2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0"))));
        text2.setPreferredSize(d);
        text2.setText(String.valueOf(quant));

        JFormattedTextField text3 = new JFormattedTextField();
        text3.setEditable(false);
        text3.setFont(Constantes.font);
        text3.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#,##0.00"))));
        text3.setPreferredSize(d);
        text3.setText(res);

        painel.add(text1);
        painel.add(text2);
        painel.add(text3);

        painel.setPreferredSize(new Dimension(435, height));
        height += 33;

        scroll.setViewportView(painel);
    }

    public void remove() {
        if ((height -= 33) == 33) {
            buttonRemover.setEnabled(false);
        }
        painel.remove(painel.getComponentCount() - 1);
        painel.remove(painel.getComponentCount() - 1);
        painel.remove(painel.getComponentCount() - 1);

        painel.setPreferredSize(new Dimension(435, height));
        scroll.setViewportView(painel);
    }

    public String getTextQuantidade(int pos) {
        return ((JFormattedTextField) painel.getComponent(pos * 3 - 2)).getText();
    }

    public void somaPrecoTotal(float valor) {
        int i;
        preco += valor;
        String res;
        String aux = String.valueOf(preco);
        for (i = 0; i < aux.length(); i++) {
            if ('.' == aux.charAt(i)) {
                break;
            }
        }
        res = aux.substring(0, i);
        res += ",";
        if (aux.length() > i + 3) {
            res += aux.substring(i + 1, i + 3);
        } else {
            res += aux.substring(i+1, aux.length());
        }
        textValor.setText(res);
    }

    public void subPrecoTotal(float valor) {
        int i;
        preco -= valor;
        String res;
        String aux = String.valueOf(preco);
        for (i = 0; i < aux.length(); i++) {
            if ('.' == aux.charAt(i)) {
                break;
            }
        }
        res = aux.substring(0, i);
        res += ",";
        if (aux.length() > (i + 3)) {
            res += aux.substring(i + 1, i + 3);
        } else {
            res += aux.substring(i, aux.length());
        }
        if (preco == 0) {
            res = "0,0";
        }
        textValor.setText(res);
    }
}