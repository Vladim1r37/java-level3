package dz;

import dz.annotation.AfterSuite;
import dz.annotation.BeforeSuite;
import dz.annotation.Test;

public class WorkToTest {

    @BeforeSuite
    public void method0() {
        System.out.println("Метод подготовительный");
    }

    @Test
    public void method1() {
        System.out.println("Метод-тест. Приоритет средний");
    }

    @Test
    public void method2() {
        System.out.println("Метод-тест. Приоритет средний");
    }

    @Test(priority = 7)
    public void method3() {
        System.out.println("Метод-тест. Приоритет низкий");
    }

    @Test(priority = 3)
    public void method4() {
        System.out.println("Метод-тест. Приоритет высокий");
    }

    @AfterSuite
    public void method5() {
        System.out.println("Метод завершающий");
    }
}
