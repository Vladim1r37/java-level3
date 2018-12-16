package Lesson1;

import java.util.ArrayList;

public class ArrayModifier {

    public static <T> void swapElements(T[] arr, int index1, int index2) {
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static <T> ArrayList<T> arrayToArrayList(T[] arr) {
        ArrayList<T> arrayList = new ArrayList<>();
        for (T value : arr) {
            arrayList.add(value);
        }
        return arrayList;
    }
}
