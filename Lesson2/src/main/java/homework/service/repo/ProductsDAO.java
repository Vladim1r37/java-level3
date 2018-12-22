package homework.service.repo;

import java.sql.SQLException;

public interface ProductsDAO {

void createTable();

void clearAndFill() throws SQLException;

void showPriceByTitle(String title);

void setPrice(String title, int price);

void showProductsWithPrice(int min, int max);

}
