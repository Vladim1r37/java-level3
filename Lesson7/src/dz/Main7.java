package dz;

public class Main7 {
    public static void main(String[] args) {

        TestingClass.start(WorkToTest.class);

        try {
            TestingClass.start("dz.WorkToTestExtended");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TestingClass.start(WorkToTestNotValid.class);


        TestingClass.start(WorkToTestNotValid_2.class);

    }
}
