package dz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteService implements AutoCloseable{

    private final Connection connection;

    public SQLiteService(String dbUrl) {
        connectDriver();
        this.connection = createConnection(dbUrl);
    }

    public Connection getConnection() {
        return connection;
    }

    private Connection createConnection(String dbUrl) {
        try {
            return DriverManager.getConnection("jdbc:sqlite:" + dbUrl);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Invalid database URL: " + dbUrl);
        }
    }

    private void connectDriver() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to find JDBC driver", e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
