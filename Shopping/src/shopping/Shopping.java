/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;


/**
 *
 * @author Igor Lopes
 */
public class Shopping {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException{
        
       DAO dao = new DAO();
        //dao.getTicket("3588");
        // dao.createLoja("CENTAURO LTDA", "CENTAURO", "0000000", "000000000", "ESPORTES", "1");
       
    }
    
}
