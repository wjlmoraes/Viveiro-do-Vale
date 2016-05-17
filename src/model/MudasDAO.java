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
public class MudasDAO {

    private static boolean x;
    private static int y;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private MudasDAO() {
    }

    /**
     * Realiza a inserção de uma nova muda na base.
     * @param novo Objeto do tipo Mudas
     * @return 1 - Se for inserido; 2 - Se for atualizado; 0 - Se ocorrer erro.
     * 
     */
    public static int insere(Mudas novo) {
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO mudas (nome) VALUES (?) "
                    + "ON DUPLICATE KEY UPDATE nome = ? ";
            try {
                stm = con.prepareStatement(sql);

                stm.setString(1, novo.getEspecie());
                stm.setString(2, novo.getEspecie());

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

    private static ArrayList<Mudas> realizaBusca(String busca) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(busca);

                rs = stm.executeQuery();

                ArrayList<Mudas> novo = new ArrayList();
                while (rs.next()) {
                    String esp = rs.getString("nome");
                    int qtd = rs.getInt("quantidade");
                    Mudas aux = new Mudas(esp, qtd);
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

    /**
     * Retorna todas as mudas registradas na base.
     * @return 
     */
    public static ArrayList<Mudas> busca() {
        sql = "SELECT * FROM MUDAS";
        return realizaBusca(sql);
    }

    /**
     * Busca por mudas na base de dados
     * @param nome Pode ser o nome da especie ou parte do nome.
     * @return ArrayList do tipo Mudas
     */
    public static ArrayList<Mudas> busca(String nome) {
        sql = "SELECT * FROM MUDAS WHERE nome like '%" + nome + "%'";
        return realizaBusca(sql);
    }
}