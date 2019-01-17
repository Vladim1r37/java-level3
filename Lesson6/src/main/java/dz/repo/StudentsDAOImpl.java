package dz.repo;

import java.sql.Connection;
import java.sql.SQLException;

public class StudentsDAOImpl implements StudentsDAO {

    private Connection connection;

    public StudentsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addRecord(String name, int score) {
        try {
            return connection.createStatement().executeUpdate(String.format("INSERT INTO students (name, score) " +
                    "VALUES ('%s', %d)", name, score));
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateScore(String name, int score) {
        try {
            return connection.createStatement().executeUpdate(String.format("UPDATE students " +
                    "SET score = %d WHERE name = '%s'", score, name));
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int readScore(String name) {
        try {
            return connection.createStatement().executeQuery(String.format("SELECT score " +
                    "FROM students WHERE name = '%s'", name)).getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
