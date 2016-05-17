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
public class SocioTrabalhouDAO {

    private static boolean x;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private SocioTrabalhouDAO() {
    }

    public static boolean insere(SocioTrabalhou novo) {
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO socio_trabalhou VALUES (?, ?, ?, ?)";
            try {
                stm = con.prepareStatement(sql);

                stm.setString(1, novo.getCpf());
                stm.setString(2, novo.getEspecie());
                stm.setString(3, novo.getData());
                stm.setString(4, novo.getHora());

                x = stm.execute();

                stm.close();
                con.close();

                return x;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na inserção!\n" + ex.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    private static ArrayList<SocioTrabalhou> realizaBusca(String busca) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(busca);

                rs = stm.executeQuery();

                ArrayList<SocioTrabalhou> novo = new ArrayList();

                while (rs.next()) {
                    String esp = rs.getString("especie_fk");
                    String cpf = rs.getString("cpf_fk");
                    String dat = rs.getString("data");
                    String hrs = rs.getString("hora");
                    SocioTrabalhou aux = new SocioTrabalhou(esp, cpf, dat, hrs);
                    novo.add(aux);
                }

                if (!novo.isEmpty())
                    novo = null;

                stm.close();
                con.close();

                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na busca!\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static ArrayList<SocioTrabalhou> buscaLote(int lote) {
        sql = "SELECT * FROM SOCIO_TRABALHOU WHERE lote = " + lote + "";
        return realizaBusca(sql);
    }

    public static ArrayList<SocioTrabalhou> buscaCpf(String cpf) {
        sql = "SELECT * FROM SOCIO_TRABALHOU WHERE cpf = '" + cpf + "'";
        return realizaBusca(sql);
    }
}