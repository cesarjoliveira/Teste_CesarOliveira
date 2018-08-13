/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste_cesarjose;

import java.sql.*;

import javax.swing.JOptionPane;



/**
 *
 * @author Familia Oliveira
 */
public class Teste_cesarjose {

    static Connection conexao;
    
    /**
     * 
     * @param args the command line arguments
     * @throws java.sql.SQLException
    */
    public static void main(String[] args) throws SQLException {
                   
//Conecta com o banco de dados       
conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/db_cesarjose/" , "nbuser", "nbuser");

//Permite a execução de comandos sql no java
try {  
        //Declaraão do comando sql para entrada de dados na tabela  
        Statement stmt = conexao.createStatement();  
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (1700, 12345678901, 'Isaque Oliveira', true, 3460)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (1800, 23456789012, 'Celso Oliveira', true, 8760)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (1900, 34567890123, 'Cicero Oliveira', true, 2230)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2000, 45678902234, 'Aline Oliveira', true, 7680)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2100, 56789012345, 'Amanda Oliveira', true, 560)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2200, 67890123456, 'Alice Oliveira', true, 1280)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2400, 89012345678, 'Izaac Newton', true, 1030)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2500, 90123456789, 'Raul Seixas', true, 13000)");
    stmt.executeUpdate("INSERT INTO NBUSER.TB_CUSTOMER_ACCOUNT (ID_CUSTOMER, CPF_CNPJ, NM_CUSTOMER, IS_ACTIVE, VL_TOTAL)"
                + "VALUES (2600, 1234567890, 'Tom Jobim', true, 220)");    
        
 
}
//Informa se houver erro
    catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }

try {  
        //Dá a função de tirar a media ao Banco de dados
        Statement stmt = conexao.createStatement(); 
        ResultSet rs = stmt.executeQuery("select avg(vl_total) "
                + "from tb_customer_account "
                + "where vl_total >= 560 and id_customer between 1500 and 2700");
       

while (rs.next()) {
    //Imprime a media final
    System.out.println("Média Final:" + rs.getString(1)); //gets the first column's rows.
}
}
catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }

try {  
        /* Da instrução para conexão e seleção de dados para impressão 
        *e ordena por saldo do maior para o menor 
        */
        Statement stmt = conexao.createStatement(); 
        
        ResultSet rs = stmt.executeQuery("SELECT NM_CUSTOMER, vl_total "
                + "FROM tb_customer_account "
                + "WHERE vl_total >= 560 and ID_CUSTOMER BETWEEN 1500 AND 2700"
                + "ORDER BY VL_TOTAL DESC");
        
              
//imprime cada cliente
ResultSetMetaData rsmd = rs.getMetaData();
int numberOfColumns = rsmd.getColumnCount();

while (rs.next()) {
     for (int i = 1; i <= numberOfColumns; i++) {
          if (i > 1) System.out.print(",  ");
          String columnValue = rs.getString(i);
          System.out.print(columnValue);
        }
        System.out.println("");  
      }
}


catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: "+ex);
        }
    }                        
    }


