package Controller;

import Connection.ConexionMySQL;
import Models.User;
import com.sun.source.tree.BreakTree;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                String insertSQL = "INSERT INTO Usuarios (name,age ,username, password, email, countDetails,  typeUser, address) VALUES (?,?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, user.getName());
                    pstmt.setInt(2, user.getAge());
                    pstmt.setString(3, user.getUsername());
                    pstmt.setString(4, user.getPassword());
                    pstmt.setString(5, user.getEmail());
                    pstmt.setString(6, user.getCountDetails());
                    pstmt.setInt(7, user.getTypeUser());
                    pstmt.setString(8, user.getAddress());

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

    public int selectLogin(String email,String password) {
        int resultado=0;
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
                        
                    if( rs.next() ){
                    return resultado= rs.getInt("typeUser");
                        
                    }
                    
                    
//                    while (rs.next()) {
//                        System.out.println("Name: " + rs.getString("name") + ", Email: " + rs.getString("email") + ", Edad: " + rs.getInt("age"));
//                        return true;
//                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
       return -1;
    }
   public User buscarAdmin(int id ) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String selectSQL = "SELECT * FROM Usuarios Where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    pstmt.setInt(1, id);                  
                    // Ejecutamos la consulta
                    ResultSet rs = pstmt.executeQuery();
                   
                    // Iteramos sobre los resultados
                        
                    if( rs.next() ){
                        User user = new User(rs.getString("name"),rs.getInt("age"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("countDetails"), rs.getInt("typeUser"), rs.getString("address"));
                      return user;
                    }
                    
                    
//                    while (rs.next()) {
//                        System.out.println("Name: " + rs.getString("name") + ", Email: " + rs.getString("email") + ", Edad: " + rs.getInt("age"));
//                        return true;
//                    }
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }
    public void delete(int id) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String deleteSQL = "DELETE FROM Usuarios WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Se borro el usuario");
                   return;
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
         JOptionPane.showMessageDialog(null, "No se borro el usuario ");
      
    }

   public void update(User user) {
    // Establecemos la conexión con la base de datos
    try (Connection conn = conexion.conectarMySQL()) {
        // Verificamos si la conexión fue exitosa
        if (conn != null) {
            // Preparamos la consulta SQL para actualizar datos
            String updateSQL = "UPDATE Usuarios SET name=?, age=?, username=?, password=?, email=?, countDetails=?, typeUser=?, address=? WHERE id=?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setString(1, user.getName());
                pstmt.setInt(2, user.getAge());
                pstmt.setString(3, user.getUsername());
                pstmt.setString(4, user.getPassword());
                pstmt.setString(5, user.getEmail());
                pstmt.setString(6, user.getCountDetails());
                pstmt.setInt(7, user.getTypeUser());
                pstmt.setString(8, user.getAddress());
                pstmt.setInt(9, user.getId()); // Suponiendo que tienes un método getId() en la clase User para obtener el id del usuario
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Su perfil se ha actualizado  ");
            }
        } else {
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    } catch (SQLException e) {
        System.out.println("Ocurrió un error al realizar la actualización en la base de datos");
        e.printStackTrace();
    }
}


}
