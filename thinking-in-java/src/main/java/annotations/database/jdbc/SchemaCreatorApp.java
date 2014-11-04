package annotations.database.jdbc;

import annotations.database.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Create an schema using DBTable annotations.
 *
 * @author Thomson Tang
 */
public class SchemaCreatorApp {
    private static final Logger logger = LoggerFactory.getLogger(SchemaCreatorApp.class);

    private static final String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost:3306/tt_example_practice";
    private static final String USER_NAME = "thomsontang";
    private static final String PASSWORD = "58.com123";

    public static void main(String[] args) {
        String createScript = SchemaStatementCreator.getCreateStatement(Member.class);
        try {
            createTable(getConnection(), createScript);
        } catch (SQLException e) {
            logger.error("error occur: {}", e.getMessage());
        }
    }

    private static Connection getConnection() throws SQLException {
        Connection connection;
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", USER_NAME);
        connectionProperties.put("password", PASSWORD);
        connection = DriverManager.getConnection(MYSQL_CONNECTION_URL, connectionProperties);
        return connection;
    }

    private static void createTable(Connection connection, String createScript) throws SQLException {
        Statement statement = null;
        try {
            statement= connection.createStatement();
            statement.executeUpdate(createScript);
        } catch (SQLException e) {
            logger.error("create table error: {}", e.getMessage());
        } finally {
            if (null != statement) {
                statement.close();
            }
        }
    }
}
