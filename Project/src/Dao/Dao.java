/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Interface.InterfaceHotel;
import Interface.InterfaceRoom;
import Interface.InterfaceUser;
import Models.City;
import Models.Hotel;
import Models.Room;
import Models.User;
import Singleton.DataBaseSingleton;
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
public class Dao implements InterfaceUser, InterfaceHotel, InterfaceRoom {

    Connection connection;

    public Dao() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }

// Login function
    public int selectLogin(String email, String password) {
        int resultado = 0;
        // We prepare the consultation SQL for select data
        String selectSQL = "SELECT * FROM users Where email=? AND password_user=?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setString(2, password);
            pstmt.setString(1, email);

            //We execute the query
            ResultSet rs = pstmt.executeQuery();

            // We iterate all the results
            if (rs.next()) {
                return resultado = rs.getInt("user_rol");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return -1;
    }

    // CRUD FOR USERS 
    public User searchUser(int id) {
        // We prepare the consultation SQL for select data
        String selectSQL = "SELECT * FROM users Where id_user=?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            //We execute the query
            ResultSet rs = pstmt.executeQuery();

            // We iterate all the results
            if (rs.next()) {
                User user = new User(rs.getInt("id_user"), rs.getString("full_name"), rs.getInt("age"), rs.getString("username"), rs.getString("password_user"), rs.getString("email"), rs.getString("phone_number"), rs.getInt("user_rol"), rs.getString("address"));
                return user;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public void insertUser(User user) {
        // We prepare the consultation SQL for insert data
        String insertSQL = "INSERT INTO users(full_name, age, username, password_user, email, phone_number, user_rol, address) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
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
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        // We prepare the consultation SQL for select data
        String deleteSQL = "DELETE FROM users WHERE id_user= ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se borro el usuario");
            return;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "No se borro el usuario ");
    }

    public void updateUser(User user) {
        // We prepare the consultation SQL for select data
        String updateSQL = "UPDATE users SET full_name=?, age=?, username=?, password_user=?, email=?, phone_number=?, user_rol=?, address=? WHERE id_user=?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
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
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la actualización en la base de datos");
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------
    // CRUD FOR HOTELS
    public Hotel searchHotel(int id) {
        // We prepare the consultation SQL for select data
        String selectSQL = "SELECT * FROM hotels Where id_hotel=?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            //We execute the query
            ResultSet rs = pstmt.executeQuery();

            // We iterate all the results
            if (rs.next()) {
                Hotel hotel = new Hotel(id, rs.getString("name_hotel"), rs.getString("address_hotel"), rs.getString("classification_hotel"), rs.getString("mob_cons_hotel"), rs.getString("pictures_hotel"), rs.getInt("id_city"));
                return hotel;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public Hotel searchHotelbyName(String name) {
        // We prepare the consultation SQL for select data
        String selectSQL = "SELECT * FROM hotels Where name_hotel=?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setString(1, name);
            //We execute the query
            ResultSet rs = pstmt.executeQuery();

            // We iterate all the results
            if (rs.next()) {
                Hotel hotel = new Hotel(rs.getInt("id_hotel"), rs.getString("name_hotel"), rs.getString("address_hotel"), rs.getString("classification_hotel"), rs.getString("mob_cons_hotel"), rs.getString("pictures_hotel"), rs.getInt("id_city"));
                return hotel;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public void insertHotel(Hotel hotel) {
        System.out.println("holass");
        // We prepare the consultation SQL for insert data
        String insertSQL = "INSERT INTO hotels (name_hotel, id_city, address_hotel,classification_hotel, mob_cons_hotel, pictures_hotel) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setString(1, hotel.getNameHotel());
            pstmt.setInt(2, hotel.getIdCity());
            pstmt.setString(3, hotel.getAdress());
            pstmt.setString(4, hotel.getClassification());
            pstmt.setString(5, hotel.getModCons());
            pstmt.setString(6, hotel.getPictures());

            //We execute the query
            int rowsAffected = pstmt.executeUpdate();

            // We check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa");
                JOptionPane.showMessageDialog(null, "Se ha registrado con exito ");
            } else {
                System.out.println("No se pudo insertar los datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    }

    //lFUll comoboxHotel
    public ArrayList<Hotel> fullComboHotel() {
        ArrayList<Hotel> listHotels = new ArrayList<>();
        // Se prepara la consulta SQL para seleccionar todos los datos de la tabla hotels
        String selectSQL = "SELECT * FROM hotels";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            // Se ejecuta la consulta y se obtiene el conjunto de resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el conjunto de resultados
            while (rs.next()) {
                // Se crea un nuevo objeto Hotel con los datos de la fila actual
                Hotel hotelEntry = new Hotel(rs.getInt("id_hotel"), rs.getString("name_hotel"), rs.getString("address_hotel"), rs.getString("classification_hotel"), rs.getString("mob_cons_hotel"), rs.getString("pictures_hotel"), rs.getInt("id_city"));
                // Se añade el objeto Hotel a la lista
                listHotels.add(hotelEntry);
            }
        } catch (SQLException e) {
            // Si ocurre un error, se imprime un mensaje de error y se muestra la pila de errores
            System.out.println("Ocurrió un error al realizar la consulta en la base de datos");
            e.printStackTrace();
        }
        // Se devuelve la lista de hoteles
        return listHotels;
    }

    public ArrayList<City> fullComboCity() {
        ArrayList<City> listCities = new ArrayList<>();
        // Se prepara la consulta SQL para seleccionar todos los datos de la tabla hotels
        String selectSQL = "SELECT * FROM cities";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            // Se ejecuta la consulta y se obtiene el conjunto de resultados
            ResultSet rs = pstmt.executeQuery();
            // Se recorre el conjunto de resultados
            while (rs.next()) {
                // Se crea un nuevo objeto Hotel con los datos de la fila actual
                City citi = new City(rs.getInt("id_city"), rs.getString("name_city"));
// Se añade el objeto Hotel a la lista
                listCities.add(citi);
            }
        } catch (SQLException e) {
            // Si ocurre un error, se imprime un mensaje de error y se muestra la pila de errores
            System.out.println("Ocurrió un error al realizar la consulta en la base de datos");
            e.printStackTrace();
        }
        // Se devuelve la lista de hoteles
        return listCities;
    }

    public void deleteHotel(int id) {
        // We prepare the consultation SQL for select data
        String deleteSQL = "DELETE FROM hotels WHERE id_hotel = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se borro el Hotel");
            return;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "No se borro el usuario ");
    }

    public void updateHotel(Hotel hotel) {
        // We prepare the consultation SQL for select data
        String updateSQL = "UPDATE hotels SET name_hotel =?, address_hotel=?, classification_hotel =?, mob_cons_hotel=?, pictures_hotel =? WHERE id_hotel=?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
            pstmt.setString(1, hotel.getNameHotel());
            pstmt.setString(2, hotel.getAdress());
            pstmt.setString(3, hotel.getClassification());
            pstmt.setString(4, hotel.getModCons());
            pstmt.setString(5, hotel.getPictures());
            pstmt.setInt(6, hotel.getId());

            // Execute the update
            int rowsUpdated = pstmt.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "El hotel se ha actualizado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha realizado ninguna actualización en la base de datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la actualización en la base de datos");
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------------------------------------------------------------------------------------
    // CRUD FOR ROOM
    public Room searchRoom(int id) {
        // We prepare the consultation SQL for select data
        String selectSQL = "SELECT * FROM rooms Where id_rooom=?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
            pstmt.setInt(1, id);
            //We execute the query
            ResultSet rs = pstmt.executeQuery();

            // We iterate all the results
            if (rs.next()) {
                Room room = new Room(rs.getInt("id_rooom"), rs.getInt("id_stade_room"), rs.getInt("number_guests"),rs.getInt("id_type_room"), rs.getInt("id_hotel"), rs.getInt("number_rooom"), rs.getInt("price_nigth"), rs.getString("room_amenities"));
                return room;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        return null;
    }

    public void insertRoom(Room room) {
        // We prepare the consultation SQL for insert data
        String insertSQL = "INSERT INTO rooms( id_stade_room, id_type_room, id_hotel, number_rooom, price_nigth, room_amenities, number_guests) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            pstmt.setInt(1, room.getId_stade_room());
            pstmt.setInt(2, room.getId_type_room());
            pstmt.setInt(3, room.getId_hotel());
            pstmt.setInt(4, room.getNumber_rooom());
            pstmt.setDouble(5, room.getPriceNigth());
            pstmt.setString(6, room.getAmenitiesDetails());
            pstmt.setInt(7, room.getNumberGuests());
            //We execute the query
            int rowsAffected = pstmt.executeUpdate();

            // We check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("Inserción exitosa");
                JOptionPane.showMessageDialog(null, "Se ha registrado con exito ");
            } else {
                System.out.println("No se pudo insertar los datos");
            }
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la inserción en la base de datos");
            e.printStackTrace();
        }
    }

    public void deleteRoom(int id) {
        // We prepare the consultation SQL for select data
        String deleteSQL = "DELETE FROM rooms WHERE id_rooom = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se borro la habitación");
            return;
        } catch (SQLException e) {
            System.out.println("Ocurrió un error al realizar la selección en la base de datos");
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "No se borro la habitación ");
    }

    public void updateRoom(Room room) {
    // We prepare the consultation SQL for select data
    String updateSQL = "UPDATE rooms SET id_stade_room=?, id_type_room=?, id_hotel=?, number_rooom=?, price_nigth=?, room_amenities=?, number_guests=? WHERE id_rooom=?";
    try (PreparedStatement pstmt = connection.prepareStatement(updateSQL)) {
        pstmt.setInt(1, room.getId_stade_room());
        pstmt.setInt(2, room.getId_type_room());
        pstmt.setInt(3, room.getId_hotel());
        pstmt.setInt(4, room.getNumber_rooom());
        pstmt.setDouble(5, room.getPriceNigth());
        pstmt.setString(6, room.getAmenitiesDetails());
        pstmt.setInt(7, room.getNumberGuests());
        pstmt.setInt(8, room.getId_room());

        pstmt.executeUpdate();

        JOptionPane.showMessageDialog(null, "Se ha actualizado");
    } catch (SQLException e) {
        System.out.println("Ocurrió un error al realizar la actualización en la base de datos");
        e.printStackTrace();
    }
}


// JSON FOR TABLES 
    public Map<String, Object> selectUsers() {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = new HashMap<>();

        // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
        String selectSQL = "SELECT * FROM users";

        // Intentamos preparar y ejecutar la consulta SQL
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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

    // JSON FOR TABLES 
    public Map<String, Object> selectFIltro(String consul) {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        Map<String, Object> result = new HashMap<>();

        // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
        String selectSQL = "SELECT * FROM users " + consul;

        // Intentamos preparar y ejecutar la consulta SQL
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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

        // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
        String selectSQL = "SELECT * FROM hotels  ";

        // Intentamos preparar y ejecutar la consulta SQL
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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

        // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
        String selectSQL = "SELECT * FROM rooms";

        // Intentamos preparar y ejecutar la consulta SQL
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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
    
    // llenar tabla de rooms 
    
      public Map<String, Object> selectHotelsInRooms(int id) {
        // Inicializamos el mapa de resultados. Este mapa almacenará los nombres de las columnas, el número de columnas y los datos de la tabla.
        
        Map<String, Object> result = new HashMap<>();
        // Preparamos la consulta SQL para seleccionar datos de la tabla 'usuario'
         String selectSQL = "SELECT * FROM rooms WHERE id_hotel = "+String.valueOf(id);

        // Intentamos preparar y ejecutar la consulta SQL
        try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)) {
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
    
    
    
    //-----------------------------------------------------------------
}
