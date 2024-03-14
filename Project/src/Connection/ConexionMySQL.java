package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    // Library de MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // name database
    private static final String DATABASE = "dataBase";

    // Host
    private static final String HOSTNAME = "localhost";

    // Port
    private static final String PORT = "3306";

    // Rute of our datebase (we desactive the use of SSL with "?useSSL=false")
    private static final String URL = "jdbc:mysql://" + HOSTNAME + ":" + PORT + "/" + DATABASE + "?useSSL=false";

    // username
    private static final String USERNAME = "root";

    // password user
    private static final String PASSWORD = "123";

    /**
     * This method is responsible for establishing the connection with the database
     * @return Connection a la base de datos.
     */
    public static Connection conectarMySQL() {
        Connection conn = null;

        try {
            // We load the MySQL driver
            Class.forName(DRIVER);
            //We stablish the connection with database
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // We print the error if the connection cannot be established
            e.printStackTrace();
        }

        // Devolvemos la conexión
        return conn;
    }
}

