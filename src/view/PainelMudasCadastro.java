/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
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
public class PainelMudasCadastro extends JPanel {

    private int heightAdubo;
    private int heightSocio;
    private JButton buttonAddAdubo;
    private JButton buttonAddSocio;
    private JButton buttonLimpar;
    private JButton buttonOk;
    private JButton buttonRemoveAdubo;
    private JButton buttonRemoveSocio;
    private JLabel labelAdubo;
    private JLabel labelData;
    private JLabel labelEspecie;
    private JLabel labelQuantidade;
    private JLabel labelSocio;
    private JPanel painelAdubo;
    private JPanel painelDadosAdubo;
    private JPanel painelDadosMudas;
    private JPanel painelDadosSocio;
    private JPanel painelSocio;
    private JScrollPane scrollAdubo;
    private JScrollPane scrollSocio;
    private JSeparator separadorDados;
    private JSeparator separadorHalf;
    private JFormattedTextField textData;
    private JFormattedTextField textEspecie;
    private JFormattedTextField textQuantidade;

    public PainelMudasCadastro(ActionListener al) {

        heightAdubo = 33;
        heightSocio = 33;

        labelData = new JLabel("Data");
        labelEspecie = new JLabel("Espécie");
        labelQuantidade = new JLabel("Quantidade:");
        labelAdubo = new JLabel("Adubo / Quantidade");
        labelSocio = new JLabel("Socio / Horas trabalhadas");

        textData = new JFormattedTextField();
        textEspecie = new JFormattedTextField();
        textQuantidade = new JFormattedTextField();

        buttonLimpar = new JButton(Constantes.clean);
        buttonOk = new JButton(Constantes.ok);
        buttonAddAdubo = new JButton("+ Adubo");
        buttonRemoveAdubo = new JButton("- Adubo");
        buttonAddSocio = new JButton("+ Socio");
        buttonRemoveSocio = new JButton("- Socio");

        separadorHalf = new JSeparator();
        separadorDados = new JSeparator();

        painelDadosMudas = new JPanel();
        painelDadosAdubo = new JPanel();
        painelAdubo = new JPanel();
        painelDadosSocio = new JPanel();
        painelSocio = new JPanel();

        scrollAdubo = new JScrollPane();
        scrollSocio = new JScrollPane();

        labelData.setFont(Constantes.font); // NOI18N
        labelEspecie.setFont(Constantes.font); // NOI18N
        labelQuantidade.setFont(Constantes.font); // NOI18N
        labelAdubo.setFont(Constantes.font); // NOI18N
        labelAdubo.setHorizontalAlignment(SwingConstants.CENTER);
        labelSocio.setFont(Constantes.font); // NOI18N
        labelSocio.setHorizontalAlignment(SwingConstants.CENTER);

        textData.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter()));
        textData.setHorizontalAlignment(JTextField.CENTER);
        textData.setFont(Constantes.font); // NOI18N

        textEspecie.setFont(Constantes.font); // NOI18N

        textQuantidade.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0"))));
        textQuantidade.setHorizontalAlignment(JTextField.CENTER);
        textQuantidade.setFont(Constantes.font); // NOI18N

        buttonLimpar.setFont(Constantes.font); // NOI18N
        buttonOk.setFont(Constantes.font); // NOI18N
        buttonAddAdubo.setFont(Constantes.font); // NOI18N
        buttonRemoveAdubo.setFont(Constantes.font); // NOI18N
        buttonRemoveAdubo.setEnabled(false);
        buttonAddSocio.setFont(Constantes.font); // NOI18N
        buttonRemoveSocio.setFont(Constantes.font); // NOI18N
        buttonRemoveSocio.setEnabled(false);

        separadorHalf.setOrientation(SwingConstants.VERTICAL);

        scrollAdubo.setPreferredSize(new Dimension(277, 100));
        scrollSocio.setPreferredSize(new Dimension(350, 304));

        painelDadosMudas.setBorder(BorderFactory.createEtchedBorder());
        painelDadosMudas.setPreferredSize(new Dimension(320, 128));
        painelDadosAdubo.setBorder(BorderFactory.createEtchedBorder());
        painelDadosSocio.setBorder(BorderFactory.createEtchedBorder());

        scrollAdubo.setViewportView(painelAdubo);
        scrollSocio.setViewportView(painelSocio);

        GroupLayout painelDadosMudasLayout = new GroupLayout(painelDadosMudas);
        painelDadosMudas.setLayout(painelDadosMudasLayout);
        painelDadosMudasLayout.setHorizontalGroup(
            painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosMudasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(labelData)
                    .addComponent(labelEspecie)
                    .addComponent(labelQuantidade))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDadosMudasLayout.createSequentialGroup()
                        .addComponent(textData, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(textEspecie, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelDadosMudasLayout.createSequentialGroup()
                        .addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOk, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        painelDadosMudasLayout.setVerticalGroup(
            painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosMudasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData)
                    .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimpar))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEspecie)
                    .addComponent(textEspecie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosMudasLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidade)
                    .addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOk))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout painelDadosAduboLayout = new GroupLayout(painelDadosAdubo);
        painelDadosAdubo.setLayout(painelDadosAduboLayout);
        painelDadosAduboLayout.setHorizontalGroup(
            painelDadosAduboLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(labelAdubo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, painelDadosAduboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosAduboLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollAdubo)
                    .addGroup(painelDadosAduboLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonRemoveAdubo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddAdubo)))
                .addContainerGap())
        );
        painelDadosAduboLayout.setVerticalGroup(
            painelDadosAduboLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosAduboLayout.createSequentialGroup()
                .addComponent(labelAdubo)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollAdubo, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosAduboLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddAdubo)
                    .addComponent(buttonRemoveAdubo))
                .addContainerGap())
        );

        GroupLayout painelDadosSocioLayout = new GroupLayout(painelDadosSocio);
        painelDadosSocio.setLayout(painelDadosSocioLayout);
        painelDadosSocioLayout.setHorizontalGroup(
            painelDadosSocioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(labelSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(GroupLayout.Alignment.TRAILING, painelDadosSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosSocioLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollSocio)
                    .addGroup(painelDadosSocioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonRemoveSocio)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddSocio)))
                .addContainerGap())
        );
        painelDadosSocioLayout.setVerticalGroup(
            painelDadosSocioLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosSocioLayout.createSequentialGroup()
                .addComponent(labelSocio)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollSocio)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosSocioLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAddSocio)
                    .addComponent(buttonRemoveSocio))
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosMudas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(separadorDados)
                    .addComponent(painelDadosAdubo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separadorHalf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDadosSocio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(separadorHalf)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(painelDadosSocio, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelDadosMudas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separadorDados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(painelDadosAdubo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        buttonOk.addActionListener(al);
        buttonLimpar.addActionListener(al);
        buttonAddAdubo.addActionListener(al);
        buttonRemoveAdubo.addActionListener(al);
        buttonAddSocio.addActionListener(al);
        buttonRemoveSocio.addActionListener(al);

        this.setPreferredSize(Constantes.dim);
        this.setSize(Constantes.dim);
    }

    public void Limpa() {
        heightAdubo = 33;
        heightSocio = 33;
        textData.setValue(null);
        textEspecie.setText("");
        textQuantidade.setValue(null);
        painelAdubo.removeAll();
        painelAdubo.setPreferredSize(new Dimension(290, 33));
        painelSocio.removeAll();
        painelSocio.setPreferredSize(new Dimension(290, 33));
        buttonRemoveAdubo.setEnabled(false);
        buttonRemoveSocio.setEnabled(false);

        scrollAdubo.setViewportView(painelAdubo);
        scrollSocio.setViewportView(painelSocio);
    }

    public void addAdubo(String nome) {
        if (heightAdubo == 33) {
            buttonRemoveAdubo.setEnabled(true);
        }

        Dimension d = new Dimension(120, 28);
        JFormattedTextField text1 = new JFormattedTextField(nome);
        JFormattedTextField text2 = new JFormattedTextField();

        text1.setEditable(false);
        text1.setFont(Constantes.font);
        text1.setPreferredSize(d);
        
        text2.setFont(Constantes.font);
        text2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("#0.000"))));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setPreferredSize(d);

        painelAdubo.add(text1);
        painelAdubo.add(text2);
        painelAdubo.setPreferredSize(new Dimension(290, heightAdubo));
        scrollAdubo.setViewportView(painelAdubo);
        heightAdubo += 33;
    }

    public void addSocio(String nome) {
        if (heightSocio == 33) {
            buttonRemoveSocio.setEnabled(true);
        }
        Dimension d1 = new Dimension(250, 28);
        Dimension d2 = new Dimension(50, 28);
        JFormattedTextField text1 = new JFormattedTextField(nome);
        JFormattedTextField text2 = new JFormattedTextField();

        text1.setEditable(false);
        text1.setFont(Constantes.font);
        text1.setPreferredSize(d1);
        
        text2.setFont(Constantes.font);
        text2.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(DateFormat.getTimeInstance(DateFormat.SHORT))));
        text2.setHorizontalAlignment(SwingConstants.CENTER);
        text2.setPreferredSize(d2);

        painelSocio.add(text1);
        painelSocio.add(text2);
        painelSocio.setPreferredSize(new Dimension(300, heightSocio));
        scrollSocio.setViewportView(painelSocio);
        heightSocio += 33;
    }

    public void removeAdubo() {
        heightAdubo -= 33;
        painelAdubo.remove(painelAdubo.getComponentCount() - 1);
        painelAdubo.remove(painelAdubo.getComponentCount() - 1);
        painelAdubo.setPreferredSize(new Dimension(290, heightAdubo));
        scrollAdubo.setViewportView(painelAdubo);

        if (heightAdubo == 33) {
            buttonRemoveAdubo.setEnabled(false);
        }
    }

    public void removeSocio() {
        heightSocio -= 33;
        painelSocio.remove(painelSocio.getComponentCount() - 1);
        painelSocio.remove(painelSocio.getComponentCount() - 1);
        painelSocio.setPreferredSize(new Dimension(300, heightSocio));
        scrollSocio.setViewportView(painelSocio);

        if (heightSocio == 33) {
            buttonRemoveSocio.setEnabled(false);
        }
    }

    public String getTextQuantidadeAdubo(int pos) {
        JFormattedTextField j = (JFormattedTextField) painelAdubo.getComponent(pos * 2 - 1);
        int i;
        String quant = j.getText();
        if (!quant.equals("")) {
            String res;
            for (i = 0; i < quant.length(); i++) {
                if (',' == quant.charAt(i)) //Encontra a virgula dentro a string
                {
                    break;
                }
            }
            res = quant.substring(0, i); //Pega a parte antes do ponto
            res += "."; //Coloca um ponto no lugar do virgula
            res += quant.substring(i + 1, quant.length()); //Pega a parte depois do virgula

            return res;
        } else {
            return quant;
        }
    }

    public String getTextHorasSocio(int pos) {
        return ((JFormattedTextField) painelSocio.getComponent(pos * 2 - 1)).getText();
    }

    /**
     * @return the textNome
     */
    public String getTextEspecie() {
        return textEspecie.getText();
    }

    /**
     * @param textNome the textNome to set
     */
    public void setTextEspecie(String textNome) {
        this.textEspecie.setText(textNome);
    }

    /**
     * @return the textQuantidade
     */
    public String getTextQuantidade() {
        return textQuantidade.getText();
    }

    /**
     * @param textQuantidade the textQuantidade to set
     */
    public void setTextQuantidade(String textQuantidade) {

        int i;
        String res;
        for (i = 0; i < textQuantidade.length(); i++) {
            if ('.' == textQuantidade.charAt(i)) //Encontra a virgula dentro a string
            {
                break;
            }
        }
        res = textQuantidade.substring(0, i); //Pega a parte antes do ponto
        res += ","; //Coloca um ponto no lugar do virgula
        res += textQuantidade.substring(i + 1, textQuantidade.length()); //Pega a parte depois do virgula
        this.textQuantidade.setText(res);
    }

    /**
     * @return the textData
     */
    public String getTextData() {
        return textData.getText();
    }

    /**
     * @param textData the textData to set
     */
    public void setTextData(String textData) {
        this.textData.setText(textData);
    }
}