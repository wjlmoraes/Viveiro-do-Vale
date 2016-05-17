/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controler.ControlerFramePrincipal.tratadorFramePrincipal;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import viveiro.Constantes;

/**
 *
 * @author Walas Jhony
 */
public class FramePrincipal extends JFrame {

    private JMenu menuAdubo;
    private JMenu menuMudas;
    private JMenu menuSocio;
    private JMenu menuVendas;
    private JMenu menuRelatorios;
    private JMenuBar barraMenus;
    private JMenuItem menuItemAduboListar;
    private JMenuItem menuItemAduboCadastrar;
    private JMenuItem menuItemMudasBuscar;
    private JMenuItem menuItemMudasCadastrar;
    private JMenuItem menuItemSocio;
    private JMenuItem menuItemSocioListar;
    private JMenuItem menuItemVendaRealizar;
    private JMenuItem menuItemRelatorioAdubo;
    private JMenuItem menuItemRelatorioMudas;
    private JMenuItem menuItemRelatorioSocio;
    private JMenuItem menuItemRelatorioVenda;
    private JPanel painel;
    private JPanel painelPrincipal;

    public FramePrincipal(tratadorFramePrincipal tfp) {

        painelPrincipal = new JPanel();
        painel = new JPanel();

        barraMenus = new JMenuBar();
        barraMenus.setPreferredSize(new Dimension(705, 24));
        barraMenus.setSize(705, 25);

        menuAdubo = new JMenu("Adubo");
        menuMudas = new JMenu("Mudas");
        menuSocio = new JMenu("Socio");
        menuVendas = new JMenu("Vendas");
        menuRelatorios = new JMenu("Relatórios");

        menuItemAduboListar = new JMenuItem(Constantes.adubolis);
        menuItemAduboListar.setFont(Constantes.font);
        menuItemAduboCadastrar = new JMenuItem(Constantes.adubocad);
        menuItemAduboCadastrar.setFont(Constantes.font);

        menuItemMudasBuscar = new JMenuItem(Constantes.mudasbus);
        menuItemMudasBuscar.setFont(Constantes.font);
        menuItemMudasCadastrar = new JMenuItem(Constantes.mudascad);
        menuItemMudasCadastrar.setFont(Constantes.font);

        menuItemSocio = new JMenuItem(Constantes.sociocad);
        menuItemSocio.setFont(Constantes.font);
        menuItemSocioListar = new JMenuItem(Constantes.sociobus);
        menuItemSocioListar.setFont(Constantes.font);

        menuItemVendaRealizar = new JMenuItem(Constantes.vendarlz);
        menuItemVendaRealizar.setFont(Constantes.font);

        menuItemRelatorioAdubo = new JMenuItem(Constantes.relatadu);
        menuItemRelatorioAdubo.setFont(Constantes.font);
        menuItemRelatorioMudas = new JMenuItem(Constantes.relatmud);
        menuItemRelatorioMudas.setFont(Constantes.font);
        menuItemRelatorioSocio = new JMenuItem(Constantes.relatsoc);
        menuItemRelatorioSocio.setFont(Constantes.font);
        menuItemRelatorioVenda = new JMenuItem(Constantes.relatven);
        menuItemRelatorioVenda.setFont(Constantes.font);

        painelPrincipal.setLayout(new CardLayout());
        painelPrincipal.add(painel, Constantes.inicial);

        getContentPane().add(painelPrincipal, BorderLayout.CENTER);

        menuAdubo.setFont(Constantes.font); // NOI18N
        menuAdubo.add(menuItemAduboCadastrar);
        menuAdubo.add(menuItemAduboListar);

        menuMudas.setFont(Constantes.font); // NOI18N
        menuMudas.add(menuItemMudasBuscar);
        menuMudas.add(menuItemMudasCadastrar);

        menuSocio.setFont(Constantes.font); // NOI18N
        menuSocio.add(menuItemSocio);
        menuSocio.add(menuItemSocioListar);

        menuVendas.setFont(Constantes.font); // NOI18N
        menuVendas.add(menuItemVendaRealizar);

        menuRelatorios.setFont(Constantes.font);
        menuRelatorios.add(menuItemRelatorioAdubo);
        menuRelatorios.add(menuItemRelatorioMudas);
        menuRelatorios.add(menuItemRelatorioSocio);
        menuRelatorios.add(menuItemRelatorioVenda);

        barraMenus.add(menuAdubo);
        barraMenus.add(menuMudas);
        barraMenus.add(menuSocio);
        barraMenus.add(menuVendas);
        barraMenus.add(menuRelatorios);

        setJMenuBar(barraMenus);

        menuItemAduboListar.addActionListener(tfp);
        menuItemAduboCadastrar.addActionListener(tfp);
        menuItemMudasBuscar.addActionListener(tfp);
        menuItemMudasCadastrar.addActionListener(tfp);
        menuItemSocio.addActionListener(tfp);
        menuItemSocioListar.addActionListener(tfp);
        menuItemRelatorioAdubo.addActionListener(tfp);
        menuItemRelatorioMudas.addActionListener(tfp);
        menuItemRelatorioSocio.addActionListener(tfp);
        menuItemRelatorioVenda.addActionListener(tfp);

        menuItemVendaRealizar.addActionListener(tfp);

        this.addKeyListener(tfp);
        this.pack();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocation(300, 70);
        this.setResizable(false);
        this.setSize(735, 385);
        this.setTitle("Viveiro do Vale");
        this.setVisible(true);
    }

    public void show(String nome) {
        CardLayout cl = (CardLayout) painelPrincipal.getLayout();
        cl.show(painelPrincipal, nome);
    }

    public void addPainel(JPanel p, String nome) {
        if (painelPrincipal.getComponentCount() > 1) {
            painelPrincipal.remove(1); //Remove o painel anterior
        }
        painelPrincipal.add(nome, p); //Adiciona o novo painel 
    }
}