package dz;

import dz.annotation.Test;

public class WorkToTestExtended extends WorkToTest {

    @Test(priority = 1)
    public void method6() {
        System.out.println("Метод-тест. Приоритет высокий");
    }

    @Test(priority = 10)
    public void method7() {
        System.out.println("Метод-тест. Приоритет низкий");
    }
}
