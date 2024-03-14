/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Maria Fernanda B
 */
public class DataBaseConection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // We create an object of the ConexionMySQL class
        ConexionMySQL conexion = new ConexionMySQL();

        //We stablish the connection with database
        Connection conn = conexion.conectarMySQL();

        // We create the consultation SQL
        String consulta = "SELECT * FROM users";

        try {
            // We create a Statement object to send SQL queries to the database
            Statement stmt = conn.createStatement();

            // We execute the query and obtain the result set
            ResultSet rs = stmt.executeQuery(consulta);

            // We process the result set
            while (rs.next()) {
                // Here you can process each row of your query result
                // For example, you can print each column in the row
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));


            }
            

            // We close the resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

