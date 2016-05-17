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
public class SocioDAO {

    private static boolean x;
    private static int y;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private SocioDAO() {
    }

    public static int insere(Socio novo) {
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO SOCIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) "
                    + "ON DUPLICATE KEY UPDATE "
                    + "cpf = ?, nome = ?, rua = ?, numero = ?, bairro = ?,  "
                    + "complemento = ?, cidade = ?, estado = ?, telefone = ?";
            try {
                stm = con.prepareStatement(sql);

                stm.setString(1, novo.getCpf());
                stm.setString(2, novo.getNome());
                stm.setString(3, novo.getRua());
                stm.setInt(4, novo.getNumero());
                stm.setString(5, novo.getComplemento());
                stm.setString(6, novo.getBairro());
                stm.setString(7, novo.getCidade());
                stm.setInt(8, novo.getEstado());
                stm.setString(9, novo.getTelefone());

                stm.setString(10, novo.getCpf());
                stm.setString(11, novo.getNome());
                stm.setString(12, novo.getRua());
                stm.setInt(13, novo.getNumero());
                stm.setString(14, novo.getComplemento());
                stm.setString(15, novo.getBairro());
                stm.setString(16, novo.getCidade());
                stm.setInt(17, novo.getEstado());
                stm.setString(18, novo.getTelefone());

                y = stm.executeUpdate();

                stm.close();
                con.close();

                return y;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na inserção!\n" + ex.getMessage());
                return 0;
            }
        } else {
            return 0;
        }
    }

    private static ArrayList<Socio> realizaBusca(String busca) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(busca);

                rs = stm.executeQuery();

                ArrayList<Socio> novo = new ArrayList();
                while (rs.next()) {
                    String cpf = rs.getString("cpf");
                    String nom = rs.getString("nome");
                    String rua = rs.getString("rua");
                    int numero = rs.getInt("numero");
                    String bai = rs.getString("bairro");
                    String cmp = rs.getString("complemento");
                    String cty = rs.getString("cidade");
                    int estado = rs.getInt("estado");
                    String tfl = rs.getString("telefone");
                    Socio aux = new Socio(numero, estado, cpf, nom, rua, bai, cmp, cty, tfl);
                    novo.add(aux);
                }

                if (novo.isEmpty()) {
                    novo = null;
                }

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

    public static ArrayList buscaAll() {
        sql = "SELECT * FROM SOCIO ORDER BY nome";
        return realizaBusca(sql);
    }

    public static ArrayList buscaPorCpf(String cpf) {
        sql = "SELECT * FROM SOCIO WHERE cpf = '" + cpf + "'";
        return realizaBusca(sql);
    }

    public static ArrayList buscaPorNome(String nome) {
        sql = "SELECT * FROM SOCIO WHERE nome like '%" + nome + "%'";
        return realizaBusca(sql);
    }

    public static boolean remove(String cpf) {
        if ((con = Conexao.getCon()) != null) {
            sql = "DELET FROM SOCIO WHERE cpf = '" + cpf + "'";
            try {
                stm = con.prepareStatement(sql);

                x = stm.execute();

                stm.close();
                con.close();

                return x;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na remoção!\n" + ex.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
}