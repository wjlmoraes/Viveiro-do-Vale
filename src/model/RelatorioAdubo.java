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
public class RelatorioAdubo {

    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private static ArrayList<Adubo> relatorioAdubo(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);

                rs = stm.executeQuery();

                ArrayList<Adubo> novo = new ArrayList();
                while (rs.next()) {
                    Adubo aux = new Adubo(rs.getString("nomeAdubo"), rs.getFloat("total"), rs.getFloat("preco"));
                    novo.add(aux);
                }
                if (novo.isEmpty()) {
                    novo = null;
                }

                stm.close();
                con.close();
                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no relatorio de adubo1!\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static ArrayList<Adubo> relatorioAduboEspecie(String especie) {
        sql = "SELECT nome_ad_fk as nomeAdubo, sum(quant_ad) AS total, "
                + "sum( ( (SELECT preco FROM adubo WHERE nome = nomeAdubo) * quant_ad) ) AS preco "
                + "FROM adubo_gasto "
                + "WHERE especie_fk = '" + especie + "' "
                + "GROUP BY nome_ad_fk";
        return relatorioAdubo(sql);
    }

    public static ArrayList<Adubo> relatorioAduboData(String di, String df) {
        sql = "SELECT nome_ad_fk as nomeAdubo, sum(quant_ad) AS total, "
                + "sum( ( (SELECT preco FROM adubo WHERE nome = nomeAdubo) * quant_ad) )AS preco "
                + "FROM adubo_gasto "
                + "WHERE data >= '" + di + "' and data <= '" + df + "'"
                + "GROUP BY nome_ad_fk";
        return relatorioAdubo(sql);
    }

    public static ArrayList<Adubo> relatorioAduboGasto() {
        sql = "SELECT nome_ad_fk as nomeAdubo, sum(quant_ad) AS total, "
                + "sum( ( (SELECT preco FROM adubo WHERE nome = nomeAdubo) * quant_ad) )AS preco "
                + "FROM adubo_gasto "
                + "WHERE especie_fk IN ("
                + "     SELECT nome "
                + "     FROM mudas "
                + "     WHERE quantidade <> 0 "
                + "     )"
                + "GROUP BY nome_ad_fk";
        return relatorioAdubo(sql);
    }

    public static ArrayList<Adubo> relatorioAduboAllUntilToday() {
        sql = "SELECT nome_ad_fk as nomeAdubo, sum(quant_ad) AS total, "
                + "sum( ( (SELECT preco FROM adubo WHERE nome = nomeAdubo) * quant_ad) )AS preco "
                + "FROM adubo_gasto "
                + "GROUP BY nome_ad_fk";
        return relatorioAdubo(sql);
    }
}