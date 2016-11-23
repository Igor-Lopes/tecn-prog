/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 *
 * @author Igor Lopes
 */
public class DAO {

    Connection conn = null;

    public void createLoja(String razao_social, String nome_fantasia, String cnpj, String num_alvara, String segmento, String piso) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_shopping?" + "user=root&password=root&");

        Statement statement = conn.createStatement();

        statement.executeUpdate("INSERT INTO lojas (razao_social,nome_fantasia,cnpj,num_alvara,segmento,piso)"
                + "VALUES (" + "'" + razao_social + "'" + "," + "'" + nome_fantasia + "'" + "," + "'" + cnpj + "'" + ","
                + "'" + num_alvara + "'" + "," + "'" + segmento + "'" + "," + "'" + piso + "')");

        conn.close();

    }

    public ResultSet consultaLoja(String razao_social) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_shopping?" + "user=root&password=root&");

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("SELECT razao_social, nome_fantasia, cnpj, num_alvara, segmento, piso FROM lojas WHERE razao_social LIKE " + "'" + razao_social + "'");

        // conn.close();
        return rs;
    }

    public int createTicket() throws ClassNotFoundException, SQLException, ParseException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   //System.out.println(dateFormat.format(date));
        
        Random rnd = new Random();
        int id_ticket = 1000 + rnd.nextInt(9000);

        conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_shopping?" + "user=root&password=root&");

        Statement statement = conn.createStatement();

        

        statement.executeUpdate("INSERT INTO tickets (id_ticket, data_entrada)"
                + "VALUES (" + "'" + id_ticket + "'"  + "," + "'" + dateFormat.format(date) + "')");
        
        conn.close();
        
        return id_ticket;
    }
    
    public ResultSet consultaTicket(String key) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;

        conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_shopping?" + "user=root&password=root&");

        Statement statement = conn.createStatement();

        ResultSet rs = statement.executeQuery("SELECT id_ticket,data_entrada FROM tickets WHERE id_ticket =  " + "'" + key + "'");

        // conn.close();
        return rs;
    }

}
