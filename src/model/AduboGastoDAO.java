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
public class AduboGastoDAO {

    private static boolean x;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private AduboGastoDAO() {
    }

    public static boolean insere(AduboGasto novo) {
        x = true;
        if ((con = Conexao.getCon()) != null) {
            sql = "INSERT INTO ADUBO_GASTO (especie_fk, nome_ad_fk, quant_ad, data) VALUES (?, ?, ?, ?)";
            try {
                stm = con.prepareStatement(sql);

                stm.setString(1, novo.getEspecie());
                stm.setString(2, novo.getNome_ad());
                stm.setFloat(3, novo.getQuant_ad());
                stm.setString(4, novo.getData());

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

    public static ArrayList<AduboGasto> realizaBusca(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);

                rs = stm.executeQuery();

                ArrayList<AduboGasto> novo = new ArrayList();
                while (rs.next()) {
                    float qt = rs.getFloat("quant_ad"); //Quantidade de adubo utilizado
                    String esp = rs.getString("especie_fk"); //Nome da especie em que foi plantado
                    String nad = rs.getString("nome_ad_fk"); //Nome do adubo que foi utilizado
                    String dat = rs.getString("data"); //Data no formato MySQL
                    AduboGasto aux = new AduboGasto(qt, esp, nad, dat); //Cria objeto
                    novo.add(aux); //Adiciona o objeto no array
                }

                if (novo.isEmpty()) { //A busca não encontrou resultados
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
}