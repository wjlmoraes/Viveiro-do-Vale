/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelAduboCadastro extends JPanel {

    private JButton buttonCancelar;
    private JButton buttonLimpar;
    private JButton buttonSalvar;
    private JLabel labelNome;
    private JLabel labelPreco;
    private JLabel labelQuantidade;
    private JFormattedTextField textNome;
    private JFormattedTextField textPreco;
    private JFormattedTextField textQuantidade;

    public PainelAduboCadastro(ActionListener al) {
        labelNome = new JLabel("Nome:");
        labelQuantidade = new JLabel("Quantidade (em kg):");
        labelPreco = new JLabel("Preço (por kg):");

        textNome = new JFormattedTextField();
        textQuantidade = new JFormattedTextField();
        textPreco = new JFormattedTextField();

        buttonCancelar = new JButton(Constantes.cancel);
        buttonLimpar = new JButton(Constantes.clean);
        buttonSalvar = new JButton(Constantes.save);

        labelNome.setFont(Constantes.font); // NOI18N
        labelQuantidade.setFont(Constantes.font); // NOI18N
        labelPreco.setFont(Constantes.font); // NOI18N

        textNome.setFont(Constantes.font); // NOI18N

        textQuantidade.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        textQuantidade.setHorizontalAlignment(JTextField.CENTER);
        textQuantidade.setFont(Constantes.font); // NOI18N

        textPreco.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.00"))));
        textPreco.setHorizontalAlignment(JTextField.CENTER);
        textPreco.setFont(Constantes.font); // NOI18N

        buttonCancelar.setFont(Constantes.font); // NOI18N
        buttonLimpar.setFont(Constantes.font); // NOI18N
        buttonSalvar.setFont(Constantes.font); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(labelPreco)
                            .addComponent(labelQuantidade)
                            .addComponent(labelNome))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(textNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPreco, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidade)
                    .addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPreco)
                    .addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonCancelar))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        buttonCancelar.addActionListener(al);
        buttonLimpar.addActionListener(al);
        buttonSalvar.addActionListener(al);

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }

    public void Limpa() {
        this.textNome.setText("");
        this.textPreco.setValue(null);
        this.textQuantidade.setValue(null);
    }

    public void focusTextNome() {
        this.textNome.requestFocus();
    }

    public void focusTextQuant() {
        this.textQuantidade.requestFocus();
    }

    public void focusTextPreco() {
        this.textPreco.requestFocus();
    }

    public String getTextNome() {
        return textNome.getText();
    }

    public void setTextNome(String textNome) {
        this.textNome.setText(textNome);
    }

    public String getTextPreco() {
        int i;
        String quant = textPreco.getText();
        String res;
        for(i = 0; i < quant.length(); i++){
            if(',' == quant.charAt(i))
                break;
        }
        res = quant.substring(0, i);
        res += ".";
        res += quant.substring(i+1, quant.length());
        
        return res;
    }

    public void setTextPreco(String textPreco) {
        int i;
        String res;
        for(i = 0; i < textPreco.length(); i++){
            if('.' == textPreco.charAt(i))
                break;
        }
        res = textPreco.substring(0, i);
        res += ",";
        res += textPreco.substring(i+1, textPreco.length());
        
        this.textPreco.setText(res);
    }

    public String getTextQuantidade() {
        int i;
        String quant = textQuantidade.getText();
        String res;
        for(i = 0; i < quant.length(); i++){
            if(',' == quant.charAt(i)) //Encontra a virgula dentro a string
                break;
        }
        res = quant.substring(0, i); //Pega a parte antes do ponto
        res += "."; //Coloca um ponto no lugar do virgula
        res += quant.substring(i+1, quant.length()); //Pega a parte depois do virgula
        
        return res;
    }

    public void setTextQuantidade(String textQuantidade) {
        int i;
        String res;
        for(i = 0; i < textQuantidade.length(); i++){
            if('.' == textQuantidade.charAt(i)) //Encontra o ponto dentro a string
                break;
        }
        res = textQuantidade.substring(0, i); //Pega a parte antes do ponto
        res += ","; //Coloca um virgula no lugar do ponto
        res += textQuantidade.substring(i+1, textQuantidade.length()); //Pega a parte depois do ponto
        
        this.textQuantidade.setText(res);
    }
}