/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControlerPainelSocio.tratadorSocio;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class PainelSocio extends JPanel {

    private JButton buttonCancelar;
    private JButton buttonLimpar;
    private JButton buttonSalvar;
    private JCheckBox checkBoxNumero;
    private JComboBox comboBoxEstados;
    private JLabel labelBairro;
    private JLabel labelCidade;
    private JLabel labelComplemento;
    private JLabel labelCpf;
    private JLabel labelEstado;
    private JLabel labelNome;
    private JLabel labelNumero;
    private JLabel labelRuaAvenida;
    private JLabel labelTelefone;
    private JFormattedTextField textBairro;
    private JFormattedTextField textCidade;
    private JFormattedTextField textComplemento;
    private JFormattedTextField textCpf;
    private JFormattedTextField textNome;
    private JFormattedTextField textNumero;
    private JFormattedTextField textRuaAvenida;
    private JFormattedTextField textTelefone;

    public PainelSocio(tratadorSocio ts) {

        labelCpf = new JLabel("CPF:");
        labelNome = new JLabel("Nome:");
        labelRuaAvenida = new JLabel("Endereço:");
        labelBairro = new JLabel("Bairro:");
        labelComplemento = new JLabel("Complemento:");
        labelNumero = new JLabel("Numero:");
        labelCidade = new JLabel("Cidade:");
        labelTelefone = new JLabel("Telefone:");
        labelEstado = new JLabel("Estado:");

        textCpf = new JFormattedTextField();
        textNome = new JFormattedTextField();
        textRuaAvenida = new JFormattedTextField();
        textBairro = new JFormattedTextField();
        textComplemento = new JFormattedTextField();
        textNumero = new JFormattedTextField();
        textCidade = new JFormattedTextField();
        textTelefone = new JFormattedTextField();

        checkBoxNumero = new JCheckBox(Constantes.snum);

        comboBoxEstados = new JComboBox();

        buttonCancelar = new JButton(Constantes.cancel);
        buttonLimpar = new JButton(Constantes.clean);
        buttonSalvar = new JButton(Constantes.save);

        labelCpf.setFont(Constantes.font); // NOI18N
        labelNome.setFont(Constantes.font); // NOI18N
        labelRuaAvenida.setFont(Constantes.font); // NOI18N
        labelBairro.setFont(Constantes.font); // NOI18N
        labelComplemento.setFont(Constantes.font); // NOI18N
        labelNumero.setFont(Constantes.font); // NOI18N
        labelCidade.setFont(Constantes.font); // NOI18N
        labelTelefone.setFont(Constantes.font); // NOI18N
        labelEstado.setFont(Constantes.font); // NOI18N

        try {
            textCpf.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        textCpf.setFont(Constantes.font); // NOI18N
        textCpf.setName(Constantes.cpfdoispontos);
        

        textNome.setFont(Constantes.font); // NOI18N

        textRuaAvenida.setFont(Constantes.font); // NOI18N

        textBairro.setFont(Constantes.font); // NOI18N

        textComplemento.setFont(Constantes.font); // NOI18N

        textNumero.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        textNumero.setFont(Constantes.font); // NOI18N

        textCidade.setFont(Constantes.font); // NOI18N

        try {
            textTelefone.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("(##) ####-####")));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        textTelefone.setFont(Constantes.font); // NOI18N

        checkBoxNumero.setFont(Constantes.font); // NOI18N

        comboBoxEstados.setFont(Constantes.font); // NOI18N
        comboBoxEstados.setModel(new DefaultComboBoxModel(new String[]{"Selecione um estado", "Acre", "Alagoas", "Amapá", "Amozonas", "Bahia", "Ceará", "Espirito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Rorraina", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));

        buttonCancelar.setFont(Constantes.font); // NOI18N
        buttonLimpar.setFont(Constantes.font); // NOI18N
        buttonSalvar.setFont(Constantes.font); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labelEstado)
                    .addComponent(labelCidade)
                    .addComponent(labelComplemento)
                    .addComponent(labelBairro)
                    .addComponent(labelRuaAvenida)
                    .addComponent(labelNome)
                    .addComponent(labelCpf))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNome)
                    .addComponent(textRuaAvenida)
                    .addComponent(textBairro)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(textComplemento)
                            .addComponent(textCidade))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelTelefone)
                            .addComponent(labelNumero))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textNumero, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxNumero))
                            .addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(buttonSalvar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpar, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCpf)
                    .addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRuaAvenida)
                    .addComponent(textRuaAvenida, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBairro)
                    .addComponent(textBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComplemento)
                    .addComponent(checkBoxNumero)
                    .addComponent(textComplemento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade)
                    .addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefone)
                    .addComponent(textCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado)
                    .addComponent(comboBoxEstados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonLimpar)
                    .addComponent(buttonSalvar))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        buttonCancelar.addActionListener(ts);
        buttonLimpar.addActionListener(ts);
        buttonSalvar.addActionListener(ts);

        checkBoxNumero.addActionListener(ts);

        textBairro.addFocusListener(ts);
        textCpf.addFocusListener(ts);
        textNome.addFocusListener(ts);
        textNumero.addFocusListener(ts);
        textRuaAvenida.addFocusListener(ts);
        textTelefone.addFocusListener(ts);

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }

    public void Limpar() {
        textCpf.setValue("");
        textNome.setText("");
        textRuaAvenida.setText("");
        textBairro.setText("");
        textComplemento.setText("");
        textNumero.setText("");
        textCidade.setText("");
        textTelefone.setValue("");

        checkBoxNumero.setSelected(false);
        comboBoxEstados.setSelectedIndex(0);
    }

    public void CamposTexto(boolean op) {
        textNome.setEditable(op);
        textRuaAvenida.setEditable(op);
        textBairro.setEditable(op);
        textComplemento.setEditable(op);
        textNumero.setEditable(op);
        textCidade.setEditable(op);
        textTelefone.setEditable(op);

        checkBoxNumero.setEnabled(op);
        comboBoxEstados.setEnabled(op);

        buttonSalvar.setEnabled(op);
    }

    public void focusTextCpf() {
        this.textCpf.requestFocus();
    }

    public void focusTextNome() {
        this.textNome.requestFocus();
    }

    public void focusTextNumero() {
        this.textNumero.requestFocus();
    }

    public void focusTextCidade() {
        this.textCidade.requestFocus();
    }

    public boolean numberState(){
        return this.checkBoxNumero.isSelected();
    }

    /**
     * @return the textBairro
     */
    public String getTextBairro() {
        return textBairro.getText();
    }

    /**
     * @param textBairro the textBairro to set
     */
    public void setTextBairro(String textBairro) {
        this.textBairro.setText(textBairro);
    }

    /**
     * @return the textCidade
     */
    public String getTextCidade() {
        return textCidade.getText();
    }

    /**
     * @param textCidade the textCidade to set
     */
    public void setTextCidade(String textCidade) {
        this.textCidade.setText(textCidade);
    }

    /**
     * @return the textComplemento
     */
    public String getTextComplemento() {
        return textComplemento.getText();
    }

    /**
     * @param textComplemento the textComplemento to set
     */
    public void setTextComplemento(String textComplemento) {
        this.textComplemento.setText(textComplemento);
    }

    /**
     * @return the textCpf
     */
    public String getTextCpf() {
        return textCpf.getText();
    }

    /**
     * @param textCpf the textCpf to set
     */
    public void setTextCpf(String textCpf) {
        this.textCpf.setText(textCpf);
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

    /**
     * @return the textNumero
     */
    public String getTextNumero() {
        return textNumero.getText();
    }

    /**
     * @param textNumero the textNumero to set
     */
    public void setTextNumero(String textNumero) {
        this.textNumero.setText(textNumero);
    }

    /**
     * @return the textRuaAvenida
     */
    public String getTextRuaAvenida() {
        return textRuaAvenida.getText();
    }

    /**
     * @param textRuaAvenida the textRuaAvenida to set
     */
    public void setTextRuaAvenida(String textRuaAvenida) {
        this.textRuaAvenida.setText(textRuaAvenida);
    }

    /**
     * @return the textTelefone
     */
    public String getTextTelefone() {
        return textTelefone.getText();
    }

    /**
     * @param textTelefone the textTelefone to set
     */
    public void setTextTelefone(String textTelefone) {
        this.textTelefone.setText(textTelefone);
    }

    /**
     * @return the comboBoxEstados
     */
    public int getComboBoxEstados() {
        return comboBoxEstados.getSelectedIndex();
    }

    /**
     * @param comboBoxEstados the comboBoxEstados to set
     */
    public void setComboBoxEstados(int comboBoxEstados) {
        this.comboBoxEstados.setSelectedIndex(comboBoxEstados);
    }
}