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
public class VendaDAO {

    private static boolean x;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private VendaDAO() {
    }

    /**
     * Invere uma venda na base
     *
     * @param novo - objeto do tipo Venda
     * @return - true se inseriu; false se não inseriu
     */
    public static boolean insere(Venda novo) {
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO venda (numero, data) VALUES (?, ?)";
            try {
                stm = con.prepareStatement(sql);

                stm.setInt(1, novo.getNumero());
                stm.setString(2, novo.getData());

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

    private static ArrayList<Venda> realizaBusca(String busca) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(busca);

                rs = stm.executeQuery();

                ArrayList<Venda> novo = new ArrayList();
                while (rs.next()) {
                    int num = rs.getInt("numero");
                    String data = rs.getString("data");
                    Venda aux = new Venda(num, data);
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
     *
     * @param numero - codigo que identifica um venda
     * @return ArrayList do tipo Venda
     */
    public static ArrayList<Venda> buscaMudas(int numero) {
        sql = "SELECT * FROM VENDA WHERE numero = " + numero + "";
        return realizaBusca(sql);
    }

    //Criar busca por nome da especie;
    /**
     * Busca de venda realizadas em um intervalo de tempo.
     *
     * @param dataI data inicial
     * @param dataF data final
     * @return ArrayList do tipo Venda
     */
    public static ArrayList<Venda> buscaMudas(String dataI, String dataF) {
        sql = "SELECT * FROM VENDA WHERE data > '" + dataI + "' and data < '" + dataF + "'";
        return realizaBusca(sql);
    }

    public static int proxNumero() {
        if ((con = Conexao.getCon()) != null) {
            int i = 0, j;
            sql = "SELECT numero FROM venda";
            try {
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                while (rs.next()) {
                    j = rs.getInt("numero");
                    if (i + 1 != j) {
                        break;
                    }
                    i++;
                }

                stm.close();
                con.close();

                return i + 1;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na busca do numero!\n" + ex.getMessage());
                return 0;
            }
        } else {
            return 0;
        }
    }
}