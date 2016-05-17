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
public class VendaIncluiDAO {

    private static boolean x;
    private static int y;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private VendaIncluiDAO() {
    }

    /**
     * Método que inseri uma nova tupla na base.
     *
     * @param novo objeto da classe VendaInclui contem todos atribudos válidos
     * @return
     */
    public static boolean insere(VendaInclui novo) {
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO venda_inclui (num_venda, especie, quantidade, preco) VALUES (?, ?, ?, ?)";
            try {
                stm = con.prepareStatement(sql);

                stm.setInt(1, novo.getNumero_venda());
                stm.setString(2, novo.getEspecie());
                stm.setInt(3, novo.getQuantidade());
                stm.setFloat(4, novo.getPreco());

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

    private static ArrayList<VendaInclui> realizaBusca(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);

                rs = stm.executeQuery();

                ArrayList<VendaInclui> novo = new ArrayList<>();

                while (rs.next()) {
                    String esp = rs.getString("especie_fk");
                    int numero = rs.getInt("numero_venda_fk");
                    int quanti = rs.getInt("quantidade");
                    float prec = rs.getFloat("preco");

                    VendaInclui aux = new VendaInclui(esp, numero, quanti, 0f);
                    novo.add(aux);
                }
                if (!novo.isEmpty()) {
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
     * Realiza a busca de um venda
     *
     * @param num - numero da venda a ser buscada
     * @return ArrayList contem o objeto com os dados buscados
     */
    public static ArrayList<VendaInclui> busca(int num) {
        sql = "SELECT * FROM VENDA_INCLUI WHERE numero_venda_fk = " + num + "";
        return realizaBusca(sql);
    }

    public static ArrayList<VendaInclui> busca(String nome) {
        sql = "SELECT * FROM VENDA_INCLUI WHERE especie like '" + nome + "'";
        return realizaBusca(sql);
    }
}