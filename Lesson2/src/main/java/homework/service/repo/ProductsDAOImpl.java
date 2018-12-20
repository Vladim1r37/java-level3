package homework.service.repo;

import java.sql.*;

public class ProductsDAOImpl implements ProductsDAO {

    private Connection connection;

    public ProductsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createTable() {
        try {
            connection.createStatement().execute("CREATE TABLE IF NOT EXISTS Products " +
                    "( id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                    "prodid INTEGER NOT NULL," +
                    "title TEXT NOT NULL," +
                    "cost INTEGER NOT NULL )");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database", e);
        }
    }

    @Override
    public void clearAndFill() throws SQLException {
        try {
            connection.createStatement().execute("DELETE FROM Products");
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Products (prodid, title, cost) " +
                    "VALUES (?, ?, ?)");
            connection.setAutoCommit(false);

            for (int i = 1; i <= 10000; i++) {
                statement.setInt(1, i);
                statement.setString(2, "товар" + i);
                statement.setInt(3, (i * i) % 100000 + 1);
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
    }

    @Override
    public void showPriceByTitle(String title) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT cost FROM Products " +
                    "WHERE title = '%s'", title));
            if (resultSet.next()) {
                System.out.println(String.format("Цена товара %s: %d", title, resultSet.getInt(1)));
            } else
                System.out.println("Такого товара нет");
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public void setPrice(String title, int price) {
        try {
            PreparedStatement ps = connection.prepareStatement(String.format("UPDATE Products " +
                    "SET cost = %d WHERE title = '%s'", price, title));
            if (ps.executeUpdate() > 0) {
                System.out.println(String.format("Цена товара %s обновлена", title));
            } else {
                System.out.println(String.format("Товар с названием %s не обнаружен", title));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }

    @Override
    public void showProductsWithPrice(int min, int max) {
        try {
            PreparedStatement ps = connection.prepareStatement(String.format("SELECT title, cost FROM Products " +
                    "WHERE cost >= %d AND cost <= %d", min, max));
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println(String.format("%s: %d", resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute query", e);
        }
    }
}
