package sharingobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/6/13
 */
public class ConnectionDispener {
    static String DB_URL = "jdbc:mysql://localhost/database";

    private ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            try {
                return DriverManager.getConnection(DB_URL);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to acquire connection, ", e);
            }
        }
    };

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
