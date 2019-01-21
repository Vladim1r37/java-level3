package dz;

import dz.annotation.BeforeSuite;

public class WorkToTestNotValid extends WorkToTest {

    @BeforeSuite
    public void method6() {
        System.out.println("Метод подготовительный");
    }
}
