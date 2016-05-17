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
public class RelatorioMudas {

    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private static ArrayList<Mudas> relatorioMudas(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);

                rs = stm.executeQuery();

                ArrayList<Mudas> novo = new ArrayList();
                while (rs.next()) {
                    Mudas aux = new Mudas(rs.getString("data"), rs.getString("especie_fk"), rs.getInt("quant"));
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

    public static ArrayList<Mudas> relatorioMudasEspecie(String especie) {
        sql = "SELECT ag.especie_fk, ag.data, quant "
                + "FROM adubo_gasto AS ag, mudas_plantadas AS mp "
                + "WHERE ag.especie_fk = '" + especie + "' "
                + "GROUP BY ag.data "
                + "ORDER BY ag.data";
        return relatorioMudas(sql);
    }

    public static ArrayList<Mudas> relatorioMudasData(String di, String df) {
        sql = "SELECT ag.especie_fk, ag.data, quant "
                + "FROM adubo_gasto AS ag, mudas_plantadas AS mp "
                + "WHERE ag.data >= '" + di + "' AND ag.data <= '" + df + "' "
                + "GROUP BY ag.data, ag.especie_fk "
                + "ORDER BY ag.data";
        return relatorioMudas(sql);
    }

    public static ArrayList<Mudas> relatorioMudasSocio(String cpf) {
        sql = "SELECT especie_fk, st.data, quant "
                + "FROM socio_trabalhou as st, mudas_plantadas as mp "
                + "WHERE cpf_fk = '" + cpf + "' AND st.data = mp.data AND st.especie_fk = mp.especie "
                + "ORDER BY data, especie_fk;";
        return relatorioMudas(sql);
    }

    public static ArrayList<Mudas> relatorioMudasAllUntilToday() {
        sql = "SELECT DISTINCT especie_fk, ag.data, quant "
                + "FROM adubo_gasto AS ag, mudas_plantadas AS mp "
                + "WHERE ag.data = mp.data AND especie_fk = especie "
                + "ORDER BY ag.data, especie";
        return relatorioMudas(sql);
    }
}