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
public class AduboDAO {

    private static boolean x;
    private static int y;
    private static Connection con;
    private static PreparedStatement stm;
    private static ResultSet rs;
    private static String sql;

    private AduboDAO() {
    }

    /**
     * Método responsáves por inserir uma nova tupla na base. Caso uma tupla com
     * a mesma chave primária já exista, seus valores são atualizado, somando-se
     * a quantidade de adubo, e atualizando-se o preco.
     *
     * @param novo Objeto da Classe Adubo
     * @return 1 se inserido, 2 se atualizado, 0 em qualquer outro caso
     */
    public static int insere(Adubo novo) {
        if ((con = Conexao.getCon()) != null) { //Criar a conexão com a base de dados
            sql = "INSERT INTO ADUBO (nome, quantidade, preco) VALUES (?, ?, ?)" //String que será executada no SGBD
                    + "ON DUPLICATE KEY UPDATE nome = ?, quantidade = quantidade + ?, preco = ?";
            try {
                stm = con.prepareStatement(sql); //Cria o statement para executa o comando

                stm.setString(1, novo.getNome()); //Seta os parametro da String que sera execurada
                stm.setFloat(2, novo.getQuant());
                stm.setFloat(3, novo.getPreco());

                stm.setString(4, novo.getNome());
                stm.setFloat(5, novo.getQuant());
                stm.setFloat(6, novo.getPreco());

                y = stm.executeUpdate(); //Executa o comando no SGBD

                stm.close(); //Fecha o statement
                con.close(); //Fecha a conexão

                return y; //Retorna o resultado da execução
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na inserção!\n" + ex.getMessage());
                return 0; //Indica erro
            }
        } else {
            return 0; //Indica erro
        }
    }

    /**
     * Método responsável pro realiza uma buscar na base de dados. Pode executar
     * varios comandos, desde que as colunas da busca sejam "nome", "quantidade"
     * e "preco".
     *
     * @param comando é a string que será executada no SGBD
     * @return ArrayList contendo todos resultadados da busca, ou nulo casa não
     * haja resultados
     */
    private static ArrayList<Adubo> realizaBusca(String comando) {
        if ((con = Conexao.getCon()) != null) {
            try {
                stm = con.prepareStatement(comando);  //Cria o statement para executa o comando

                rs = stm.executeQuery(); //Executa o comando no SGBD

                ArrayList<Adubo> novo = new ArrayList(); // Cria o ArrayList

                while (rs.next()) { //Enquanto houver resutados
                    //Cria-se um novo objeto passando o resultado da busca...
                    Adubo aux = new Adubo();
                    aux.setNome(rs.getString("nome"));
                    aux.setQuant(rs.getFloat("quantidade"));
                    aux.setPreco(rs.getFloat("preco"));
                    novo.add(aux); //... e o adionamos no ArrayList
                }

                if(novo.isEmpty()){ //Caso o ArrayList não contenha elementos...
                    novo = null; //... o setamos para nulo.
                }
                
                stm.close(); //Fecha statement
                con.close(); //Fecha conexão

                return novo; //Retornamos o ArrayList
            } catch (SQLException ex) { //Caso haja problemas na preparação do statement ou na execução do comando sql
                JOptionPane.showMessageDialog(null, "Erro na busca!\n" + ex.getMessage());
                return null;
            }
        } else { //Caso haja problemas na criação da conexão com a base
            return null;
        }
    }

    /**
     * Busca por todos adubos cadastrados na base de dados
     * @return ArrayList com todos dos adubos, ou nulo caso não haja adubos 
     * cadastrados ou não ocorra algum problema.
     */
    public static ArrayList<Adubo> busca() {
        sql = "SELECT * FROM ADUBO";
        return realizaBusca(sql);
    }

    /**
     * Busca por adubo com o nome passado
     * @param nome pode ser o nome do adubo, ou parte do nome
     * @return ArrayList com todos dos adubos, ou nulo caso não haja adubos 
     * cadastrados ou não ocorra algum problema.
     */
    public static ArrayList<Adubo> busca(String nome) {
        sql = "SELECT * FROM ADUBO WHERE nome like '%" + nome + "%'";
        return realizaBusca(sql);
    }

    /**
     * Busca a quantidade de todos adubos gastos na produção do um determinada espécie.
     * Cada objeto contem o nome do adubo, a quantidade utiliza e o preço por quilograma
     * @param nome da espécie que deseja busca as informações
     * @return ArrayList com todos dos adubos gastos, ou nulo caso não haja a espécie
     * passada, ou nome estaja incorreto ou não ocorra algum problema.
     */
    public static ArrayList<Adubo> buscaPreco(String nome) {
        sql = "SELECT nome_ad_fk as nome, sum(quant_ad) as quantidade, preco "
                + "FROM adubo_gasto, adubo "
                + "WHERE especie_fk = '" + nome + "' AND nome = nome_ad_fk "
                + "GROUP BY nome_ad_fk "
                + "ORDER BY data";
        return realizaBusca(sql);
    }

    /**
     * Remove uma tupla na base de dados.
     * @param nome do adubo que deseja deseja-se remove
     * @return true caso remova, false em qualquer ou caso 
     */
    public static boolean remove(String nome) {
        if ((con = Conexao.getCon()) != null) {
            sql = "DELETE FROM ADUBO WHERE nome = '" + nome + "'";
            try {
                stm = con.prepareStatement(sql);  //Prepara o statement

                x = stm.execute(); //Executa o comando

                stm.close(); //Fecha o statement
                con.close(); //Fecha a conexão

                return x; //Retorna o resultado da execução
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na deleção!\n" + ex.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }
}