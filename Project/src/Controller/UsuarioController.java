package Controller;

import Connection.ConexionMySQL;
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

    public void insert(String nombre, int edad, String correo) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para insertar datos
                String insertSQL = "INSERT INTO Usuarios (nombre, edad, correo) VALUES (?, ?,  ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, nombre);
                    pstmt.setInt(2, edad);
                    pstmt.setString(3, correo);

                    // Ejecutamos la consulta
                    int rowsAffected = pstmt.executeUpdate();

                    // Verificamos si la inserción fue exitosa
                    if (rowsAffected > 0) {
                        System.out.println("Inserción exitosa");
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

    public void select() {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String selectSQL = "SELECT * FROM Usuarios";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Ejecutamos la consulta
                    ResultSet rs = pstmt.executeQuery();

                    // Iteramos sobre los resultados
                    while (rs.next()) {
                        System.out.println("Name: " + rs.getString("nombre") + ", Email: " + rs.getString("correo") + ", Edad: " + rs.getInt("edad"));
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

    public void delete(int id) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String deleteSQL = "DELETE FROM Usuarios WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setString(1, Integer.toString(id));
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

    public void update(String nombre, int id, String correo, int edad) {
        // Establecemos la conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String updateSQL = "UPDATE Usuarios SET nombre = ?,correo = ?,edad=?  WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(4, Integer.toString(id));
                    pstmt.setString(1, nombre);
                    pstmt.setString(2, correo);
                    pstmt.setString(3, Integer.toString(edad));
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
