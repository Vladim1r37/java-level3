package homework;

import homework.service.SQLiteService;
import homework.service.repo.ProductsDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductsManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SQLiteService service = new SQLiteService("NewSample.db");
        ProductsDAOImpl dao = new ProductsDAOImpl(service.getConnection());

        //создаём таблицу Products, если её нет
        dao.createTable();

        //очищаем таблицу и заполняем дефолтными данными
        try {
            dao.clearAndFill();
        } catch (SQLException e) {
            throw new RuntimeException("Во время инициализации таблицы товаров произошла ошибка.", e);
        }

        //запускаем прослушивание стандартного ввода

        while (true) {
            System.out.println("Введите команду:");
            String str = sc.nextLine();
            if (str.startsWith("/цена")) {
                String[] tokens = str.split(" ");
                dao.showPriceByTitle(tokens[1]);
            }
            if (str.startsWith("/сменитьцену")) {
                String[] tokens = str.split(" ");
                dao.setPrice(tokens[1], Integer.valueOf(tokens[2]));
            }
            if (str.startsWith("/товарыпоцене")) {
                String[] tokens = str.split(" ");
                dao.showProductsWithPrice(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]));
            }
            if (str.startsWith("/quit"))
                break;
        }
    }

}
