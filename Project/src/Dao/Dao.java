/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConexionMySQL;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jilssa
 */
public class Dao {
    
    ConexionMySQL conexion;
    
    public Dao() {
        this.conexion = new ConexionMySQL();
    }
    
        public void insert(User user) {
        //We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for insert data
                String insertSQL = "INSERT INTO Usuarios (name, age, username, password, email, countDetails, typeUser, address) VALUES (?,?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, user.getName());
                    pstmt.setInt(2, user.getAge());
                    pstmt.setString(3, user.getUsername());
                    pstmt.setString(4, user.getPassword());
                    pstmt.setString(5, user.getEmail());
                    pstmt.setString(6, user.getCountDetails());
                    pstmt.setInt(7, user.getTypeUser());
                    pstmt.setString(8, user.getAddress());

                    //We execute the query
                    int rowsAffected = pstmt.executeUpdate();

                    // We check if the insert was successful
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
        // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos
                String selectSQL = "SELECT * FROM Usuarios Where email=? AND password=?";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    pstmt.setString(2, password);
                    pstmt.setString(1, email);
                     
                    //We execute the query
                    ResultSet rs = pstmt.executeQuery();
                   
                    // We iterate all the results
                        
                    if( rs.next() ){
                    return resultado= rs.getInt("typeUser");
                        
                    }
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
    
    public User searchAdmin(int id ) {
        // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            /// We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
                String selectSQL = "SELECT * FROM Usuarios Where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    pstmt.setInt(1, id);                  
                    //We execute the query
                    ResultSet rs = pstmt.executeQuery();
                   
                    // We iterate all the results
                        
                    if( rs.next() ){
                        User user = new User(rs.getString("name"),rs.getInt("age"), rs.getString("username"), rs.getString("password"), rs.getString("email"), rs.getString("countDetails"), rs.getInt("typeUser"), rs.getString("address"));
                      return user;
                    }
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
        // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
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
    // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
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
                    pstmt.setInt(9, user.getId());
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
