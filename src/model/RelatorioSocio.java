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
public class RelatorioSocio {

    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    public static ArrayList<SocioTrabalhou> relatorioSocioEspecie(String especie) {
        if ((con = Conexao.getCon()) != null) {
            sql = "SELECT nome, data, horas "
                    + "FROM socio_trabalhou, socio "
                    + "WHERE especie_fk = '" + especie + "' AND cpf = cpf_fk "
                    + "ORDER BY data, nome;";
            try {
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                ArrayList<SocioTrabalhou> novo = new ArrayList();
                String data;
                while (rs.next()) {
                    SocioTrabalhou aux;
                    data = rs.getString("data").substring(8, 10) + "/" + rs.getString("data").substring(5, 7) + "/" + rs.getString("data").substring(0, 4);
                    aux = new SocioTrabalhou(rs.getString("nome"), null, data, rs.getString("horas").substring(0, 5));
                    novo.add(aux);
                }

                if (novo.isEmpty()) {
                    novo = null;
                }

                stm.close();
                con.close();

                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no relatorio socio 1.\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }

    }

    public static ArrayList<SocioTrabalhou> relatorioSocioData(String di, String df) {
        if ((con = Conexao.getCon()) != null) {
            sql = "SELECT nome, especie_fk, horas, data "
                    + "FROM socio, socio_trabalhou "
                    + "WHERE data >= '" + di + "' AND data <= '" + df + "' AND cpf = cpf_fk "
                    + "ORDER BY data, especie_fk, nome;";
            try {
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                ArrayList<SocioTrabalhou> novo = new ArrayList();
                String data;
                while (rs.next()) {
                    SocioTrabalhou aux;
                    data = rs.getString("data").substring(8, 10) + "/" + rs.getString("data").substring(5, 7) + "/" + rs.getString("data").substring(0, 4);
                    aux = new SocioTrabalhou(rs.getString("nome"), rs.getString("especie_fk"), data, rs.getString("horas"));
                    novo.add(aux);
                }

                if (novo.isEmpty()) {
                    novo = null;
                }

                stm.close();
                con.close();

                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no relatorio socio 2.\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static ArrayList<SocioTrabalhou> relatorioSocioHorasData(String cpf, String di, String df) {
        if ((con = Conexao.getCon()) != null) {
            sql = "SELECT especie_fk, horas, data "
                    + "FROM socio, socio_trabalhou "
                    + "WHERE cpf_fk = '" + cpf + "' AND data >= '" + di + "' AND data <= '" + df + "' AND cpf = cpf_fk "
                    + "ORDER BY data, especie_fk;";
            try {
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                ArrayList<SocioTrabalhou> novo = new ArrayList();
                String data;
                while (rs.next()) {
                    SocioTrabalhou aux;
                    data = rs.getString("data").substring(8, 10) + "/" + rs.getString("data").substring(5, 7) + "/" + rs.getString("data").substring(0, 4);
                    aux = new SocioTrabalhou(null, rs.getString("especie_fk"), data, rs.getString("horas"));
                    novo.add(aux);
                }

                if (novo.isEmpty()) {
                    novo = null;
                }

                stm.close();
                con.close();

                return novo;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no relatorio socio 1.\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }

    public static String relatorioSocioTotalHoras(String cpf) {
        int horas = 0, min = 0;
        String total;
        if ((con = Conexao.getCon()) != null) {
            sql = "SELECT (sum(hour(horas))) as horas, sum(minute(horas)) as minutos "
                    + "FROM socio_trabalhou "
                    + "WHERE cpf_fk = '" + cpf + "';";
            try {
                stm = con.prepareStatement(sql);

                rs = stm.executeQuery();

                while (rs.next()) {
                    horas = rs.getInt("horas");
                    min = rs.getInt("minutos");
                }

                stm.close();
                con.close();

                if ((min % 60) > 9) {
                    total = String.valueOf(horas + ((int) min / 60)) + ":" + String.valueOf(min % 60);
                } else {
                    total = String.valueOf(horas + ((int) min / 60)) + ":0" + String.valueOf(min % 60);
                }
                return total;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro no relatorio socio 1.\n" + ex.getMessage());
                return null;
            }
        } else {
            return null;
        }
    }
}