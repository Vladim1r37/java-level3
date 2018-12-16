package Lesson1;

import java.util.ArrayList;

public class Main1 {

    public static void main(String[] args) {
        arrayModifierTest();
        fruitsTest();
    }

    private static void fruitsTest() {
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 5; i++) {
            appleBox1.add(new Apple());
        }
        for (int i = 0; i < 10; i++) {
            appleBox2.add(new Apple());
        }
        for (int i = 0; i < 5; i++) {
            orangeBox.add(new Orange());
        }

        System.out.println("вес коробок:");

        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println("сравнение коробок по весу:");

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(orangeBox));

        appleBox1.pourTo(appleBox2);

        System.out.println("вес коробки 2 после пересыпания:");

        System.out.println(appleBox2.getWeight());


    }

    private static void arrayModifierTest() {
        String[] strings = {"1", "2", "3", "4", "5"};
        Integer[] integers = {1, 2, 3, 4, 5};

        System.out.println("меняем местами элементы массива:");

        ArrayModifier.swapElements(strings, 2, 4);
        ArrayModifier.swapElements(integers, 2, 4);

        for (String i : strings) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (Integer i : integers) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("проверяем метод преобразования массива в коллекцию ArrayList:");

        ArrayList<String> arrayListSt = ArrayModifier.arrayToArrayList(strings);
        ArrayList<Integer> arrayListInt = ArrayModifier.arrayToArrayList(integers);

        for (String s : arrayListSt) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (Integer i : arrayListInt) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
