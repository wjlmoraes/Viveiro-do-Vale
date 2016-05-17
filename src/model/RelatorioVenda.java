/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Walas Jhony
 */
public class RelatorioVenda {

    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    //public static 
    public static ArrayList<VendaInclui> relatorioVenda(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);

                rs = stm.executeQuery();

                ArrayList<VendaInclui> novo = new ArrayList();
                while (rs.next()) {
                    VendaInclui aux = new VendaInclui();
                    aux.setNumero_venda(rs.getInt("num_venda"));
                    aux.setEspecie(rs.getString("especie"));
                    aux.setQuantidade(rs.getInt("quantidade"));
                    aux.setPreco(rs.getFloat("preco"));
                    novo.add(aux);
                }
                if (novo.isEmpty()) {
                    novo = null;
                }

                stm.close();
                con.close();

                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na busca!" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static VendaInclui relatorioVendaMais() {
        sql = "SELECT num_venda, especie, sum(quantidade) as quantidade, sum(preco) as preco "
                + "FROM venda_inclui "
                + "GROUP BY especie "
                + "ORDER BY quantidade desc";
        ArrayList<VendaInclui> aux = relatorioVenda(sql);
        if (aux.isEmpty()) {
            return null;
        } else {
            return aux.get(0);
        }
    }

    public static VendaInclui relatorioVendaQuant(String especie) {
        sql = "SELECT num_venda, especie, sum(quantidade) as quantidade, sum(preco) as preco "
                + "FROM venda_inclui "
                + "WHERE especie = '" + especie + "' "
                + "GROUP BY especie";
        ArrayList<VendaInclui> aux = relatorioVenda(sql);
        if (aux == null) {
            return null;
        } else {
            return aux.get(0);
        }
    }

    public static ArrayList<VendaInclui> relatorioVendaData(String di, String df) {
        sql = "SELECT num_venda, especie, quantidade, preco "
                + "FROM venda_inclui, venda "
                + "WHERE data >= '" + di + "' AND data <= '" + df + "' AND numero = num_venda "
                + "ORDER BY num_venda, especie";
        return relatorioVenda(sql);
    }

    public static ArrayList<VendaInclui> relatorioVendaAll() {
        sql = "SELECT num_venda, especie, quantidade, preco "
                + "FROM venda_inclui, venda "
                + "WHERE numero = num_venda "
                + "ORDER BY num_venda, especie";
        return relatorioVenda(sql);
    }
}