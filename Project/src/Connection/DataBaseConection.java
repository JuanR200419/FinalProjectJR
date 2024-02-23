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
        // Creamos un objeto de la clase ConexionMySQL
        ConexionMySQL conexion = new ConexionMySQL();

        // Establecemos la conexión con la base de datos
        Connection conn = conexion.conectarMySQL();

        // Creamos la consulta SQL
        String consulta = "SELECT * FROM users";

        try {
            // Creamos un objeto Statement para enviar consultas SQL a la base de datos
            Statement stmt = conn.createStatement();

            // Ejecutamos la consulta y obtenemos el conjunto de resultados
            ResultSet rs = stmt.executeQuery(consulta);

            // Procesamos el conjunto de resultados
            while (rs.next()) {
                // Aquí puedes procesar cada fila del resultado de tu consulta
                // Por ejemplo, puedes imprimir cada columna de la fila
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));


            }
            

            // Cerramos los recursos
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

