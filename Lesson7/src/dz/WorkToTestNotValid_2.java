package dz;

import dz.annotation.AfterSuite;

public class WorkToTestNotValid_2 extends WorkToTest {

    @AfterSuite
    public void method6() {
        System.out.println("Метод завершающий");
    }
}
