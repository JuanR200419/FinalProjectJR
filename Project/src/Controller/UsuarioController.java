package Controller;

import Connection.ConexionMySQL;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.interfaces.RSAKey;
import javax.swing.JOptionPane;

public class UsuarioController {

    // Creamos un objeto de la clase ConexionMySQL
    ConexionMySQL conexion;

    public UsuarioController() {
        this.conexion = new ConexionMySQL();
    }

    public void insert(User user) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para insertar datos
                String insertSQL = "INSERT INTO Usuarios (name,age ,username, password, email, countDetails,  typeUser, adress) VALUES (?,?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, user.getName());
                    pstmt.setInt(2, user.getAge());
                    pstmt.setString(3, user.getUsername());
                    pstmt.setString(4, user.getPassword());
                    pstmt.setString(5, user.getEmail());
                    pstmt.setString(6, user.getCountDetails());
                    pstmt.setInt(7, user.getTypeUser());
                    pstmt.setString(8, user.getAdress());

                    // Ejecutamos la consulta
                    int rowsAffected = pstmt.executeUpdate();

                    // Verificamos si la inserción fue exitosa
                    if (rowsAffected > 0) {
                        System.out.println("Inserción exitosa");
                        JOptionPane.showMessageDialog(null, "Se ha registrado con exito ");
                    } else {
                        System.out.println("No se pudo insertar los datos");
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    }

    public void selectLogin(String email,String password) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String selectSQL = "SELECT * FROM Usuarios Where email=? AND password=?";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    pstmt.setString(2, password);
                    pstmt.setString(1, email);
                     
                    // Ejecutamos la consulta
                    ResultSet rs = pstmt.executeQuery();
                   
                    // Iteramos sobre los resultados
                        
//                    if( rs.next() ){
//                        System.out.println("inicio sesion");
//                        
//                    }
                    
                    
                    while (rs.next()) {
                        System.out.println("Name: " + rs.getString("name") + ", Email: " + rs.getString("email") + ", Edad: " + rs.getInt("age"));
                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
       
    }

    public void delete(String correo) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String deleteSQL = "DELETE FROM Usuarios WHERE correo = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setString(1, correo);
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha eliminado");
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
    }

    public void update(User user) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String updateSQL = "UPDATE Usuarios (name ,username, password, email, countDetails,  typeUser, adress) VALUES (?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(1, user.getName());
                    pstmt.setString(2, user.getUsername());
                    pstmt.setString(4, user.getEmail());
                    pstmt.setString(5, user.getCountDetails());
                    pstmt.setInt(6, user.getTypeUser());
                    pstmt.setString(7, user.getAdress());
                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Su perfil se ha actualizado  ");
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
    }

}
