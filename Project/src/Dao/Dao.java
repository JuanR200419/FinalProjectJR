/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Connection.ConexionMySQL;
import Interface.InterfaceUser;
import Models.Hotel;
import Models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author jilssa
 */
public class Dao implements InterfaceUser{
    
    ConexionMySQL conexion;
    
    public Dao() {
        this.conexion = new ConexionMySQL();
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
    
    public User searchUser(int id ) {
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
    
       public void insertUser(User user) {
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
    public void deleteUser(int id) {
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

    public void updateUser(User user) {
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
    
        public Hotel searchHotel(int id ) {
        // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            /// We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
                String selectSQL = "SELECT * FROM hotels Where id=?";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    pstmt.setInt(1, id);                  
                    //We execute the query
                    ResultSet rs = pstmt.executeQuery();
                   
                    // We iterate all the results
                        
                    if( rs.next() ){
                        Hotel hotel = new Hotel(id, rs.getString("name_hotel"), rs.getString("address_hotel"), rs.getString("classification_hotel"), rs.getString("mob_cons_hotel"), rs.getString("pictures_hotel"));
                       return hotel;
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
    
       public void insertHotel(Hotel hotel) {
        //We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for insert data
                String insertSQL = "INSERT INTO hotel (name_hotel,address_hotel,classification_hotel , mob_cons_hotel,pictures_hotel) VALUES (?,?,?,?,?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, hotel.getNameHotel());
                    pstmt.setString(2, hotel.getAdress());
                    pstmt.setString(3, hotel.getClassification());
                    pstmt.setString(4, hotel.getModCons());
                    pstmt.setString(5, hotel.getPictures());
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
    public void deleteHotel(int id) {
        // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
                String deleteSQL = "DELETE FROM hotels WHERE id_hotel = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                   JOptionPane.showMessageDialog(null, "Se borro el Hotel");
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

    public void updateHotel(Hotel hotel) {
    // We stablish the connection with database
        try (Connection conn = conexion.conectarMySQL()) {
            // We check if the connection was successful
            if (conn != null) {
                // We prepare the consultation SQL for select data
                String updateSQL = "UPDATE hotels SET name_hotel =?, address_hotel=?, classification_hotel =?, mob_cons_hotel=?, pictures_hotel =? WHERE id_hotel=?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(1, hotel.getNameHotel());
                    pstmt.setString(2, hotel.getAdress());
                    pstmt.setString(3, hotel.getClassification());
                    pstmt.setString(4, hotel.getModCons());
                    pstmt.setString(5, hotel.getPictures());
                    pstmt.setInt(6, hotel.getId());
                    JOptionPane.showMessageDialog(null, "Su Hotel se ha actualizado  ");
                }
            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la actualización en la base de datos");
            e.printStackTrace();
        }
    }
    
    
        public User searchRoom(int id ) {
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
    
       public void insertRoom(User user) {
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
    public void deleteRoom(int id) {
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

    public void updateRoom(User user) {
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
           public Map<String, Object> selectUsers() {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = new HashMap<>();
        

        // Intentamos establecer una conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
                String selectSQL = "SELECT * FROM usuario";

                // Intentamos preparar y ejecutar la consulta SQL
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Ejecutamos la consulta y obtenemos los resultados en un ResultSet
                    ResultSet rs = pstmt.executeQuery();

                    // Obtenemos los metadatos del ResultSet. Los metadatos contienen información sobre la estructura de los resultados, como el número de columnas y los nombres de las columnas.
                    ResultSetMetaData rsmd = rs.getMetaData();

                    // Obtenemos el número de columnas de los metadatos
                    int numColumns = rsmd.getColumnCount();

                    // Creamos una lista para almacenar los nombres de las columnas
                    List<String> columnNames = new ArrayList<>();
                    for (int i = 1; i <= numColumns; i++) {
                        // Obtenemos el nombre de cada columna de los metadatos y lo agregamos a la lista
                        columnNames.add(rsmd.getColumnName(i));
                    }

                    // Creamos una lista para almacenar los datos de la tabla
                    List<List<Object>> tableData = new ArrayList<>();
                    while (rs.next()) {
                        // Creamos una lista para almacenar los datos de la fila actual
                        List<Object> rowData = new ArrayList<>();
                        for (int i = 1; i <= numColumns; i++) {
                            // Obtenemos el dato de cada columna de la fila actual y lo agregamos a la lista
                            rowData.add(rs.getObject(i));
                        }
                        // Agregamos la lista de datos de la fila a la lista de datos de la tabla
                        tableData.add(rowData);
                    }

                    // Agregamos el número de columnas, los nombres de las columnas y los datos de la tabla al mapa de resultados
                    result.put("numColumns", numColumns);
                    result.put("columnNames", columnNames);
                    result.put("tableData", tableData);
                }
            } else {
                // Si no se pudo establecer la conexión con la base de datos, imprimimos un mensaje de error
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            // Si ocurre un error al realizar la selección en la base de datos, imprimimos un mensaje de error y la traza de la pila del error
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }

        // Imprimimos el mapa de resultados para depuración
        System.out.println(result);

        // Retornamos el mapa de resultados
        return result;
    }
            public Map<String, Object> selectHotels() {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = new HashMap<>();
        

        // Intentamos establecer una conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
                String selectSQL = "SELECT * FROM hotels";

                // Intentamos preparar y ejecutar la consulta SQL
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Ejecutamos la consulta y obtenemos los resultados en un ResultSet
                    ResultSet rs = pstmt.executeQuery();

                    // Obtenemos los metadatos del ResultSet. Los metadatos contienen información sobre la estructura de los resultados, como el número de columnas y los nombres de las columnas.
                    ResultSetMetaData rsmd = rs.getMetaData();

                    // Obtenemos el número de columnas de los metadatos
                    int numColumns = rsmd.getColumnCount();

                    // Creamos una lista para almacenar los nombres de las columnas
                    List<String> columnNames = new ArrayList<>();
                    for (int i = 1; i <= numColumns; i++) {
                        // Obtenemos el nombre de cada columna de los metadatos y lo agregamos a la lista
                        columnNames.add(rsmd.getColumnName(i));
                    }

                    // Creamos una lista para almacenar los datos de la tabla
                    List<List<Object>> tableData = new ArrayList<>();
                    while (rs.next()) {
                        // Creamos una lista para almacenar los datos de la fila actual
                        List<Object> rowData = new ArrayList<>();
                        for (int i = 1; i <= numColumns; i++) {
                            // Obtenemos el dato de cada columna de la fila actual y lo agregamos a la lista
                            rowData.add(rs.getObject(i));
                        }
                        // Agregamos la lista de datos de la fila a la lista de datos de la tabla
                        tableData.add(rowData);
                    }

                    // Agregamos el número de columnas, los nombres de las columnas y los datos de la tabla al mapa de resultados
                    result.put("numColumns", numColumns);
                    result.put("columnNames", columnNames);
                    result.put("tableData", tableData);
                }
            } else {
                // Si no se pudo establecer la conexión con la base de datos, imprimimos un mensaje de error
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            // Si ocurre un error al realizar la selección en la base de datos, imprimimos un mensaje de error y la traza de la pila del error
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }

        // Imprimimos el mapa de resultados para depuración
        System.out.println(result);

        // Retornamos el mapa de resultados
        return result;
    }
            
    public Map<String, Object> selectRooms() {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = new HashMap<>();
        

        // Intentamos establecer una conexión con la base de datos
        try (Connection conn = conexion.conectarMySQL()) {
            // Verificamos si la conexión fue exitosa
            if (conn != null) {
                // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
                String selectSQL = "SELECT * FROM rooms";

                // Intentamos preparar y ejecutar la consulta SQL
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Ejecutamos la consulta y obtenemos los resultados en un ResultSet
                    ResultSet rs = pstmt.executeQuery();

                    // Obtenemos los metadatos del ResultSet. Los metadatos contienen información sobre la estructura de los resultados, como el número de columnas y los nombres de las columnas.
                    ResultSetMetaData rsmd = rs.getMetaData();

                    // Obtenemos el número de columnas de los metadatos
                    int numColumns = rsmd.getColumnCount();

                    // Creamos una lista para almacenar los nombres de las columnas
                    List<String> columnNames = new ArrayList<>();
                    for (int i = 1; i <= numColumns; i++) {
                        // Obtenemos el nombre de cada columna de los metadatos y lo agregamos a la lista
                        columnNames.add(rsmd.getColumnName(i));
                    }

                    // Creamos una lista para almacenar los datos de la tabla
                    List<List<Object>> tableData = new ArrayList<>();
                    while (rs.next()) {
                        // Creamos una lista para almacenar los datos de la fila actual
                        List<Object> rowData = new ArrayList<>();
                        for (int i = 1; i <= numColumns; i++) {
                            // Obtenemos el dato de cada columna de la fila actual y lo agregamos a la lista
                            rowData.add(rs.getObject(i));
                        }
                        // Agregamos la lista de datos de la fila a la lista de datos de la tabla
                        tableData.add(rowData);
                    }

                    // Agregamos el número de columnas, los nombres de las columnas y los datos de la tabla al mapa de resultados
                    result.put("numColumns", numColumns);
                    result.put("columnNames", columnNames);
                    result.put("tableData", tableData);
                }
            } else {
                // Si no se pudo establecer la conexión con la base de datos, imprimimos un mensaje de error
                System.out.println("No se pudo establecer la conexión con la base de datos");
            }
        } catch (SQLException e) {
            // Si ocurre un error al realizar la selección en la base de datos, imprimimos un mensaje de error y la traza de la pila del error
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }

        // Imprimimos el mapa de resultados para depuración
        System.out.println(result);

        // Retornamos el mapa de resultados
        return result;
    } 
}
