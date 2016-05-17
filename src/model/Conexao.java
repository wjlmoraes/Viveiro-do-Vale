/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Walas Jhony
 */
public class Conexao {

    public Conexao() {
    }

    public static Connection getCon() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/VIVEIRO", "root", "belezapura");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão!\n" + ex.getMessage());
            JOptionPane.showMessageDialog(null, "O programa sera fechado!");
            System.exit(1);
            return null;
        }
    }
}