package dz;

public class ArrayUtils {

    private static final int MARKER = 4;

    public int[] cutArrayByMarker(int[] arr) {
        int markerIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == MARKER) {
                markerIndex = i;
            }
        }
        if (markerIndex == -1) {
            throw new RuntimeException();
        } else {
            int[] newArr = new int[arr.length - 1 - markerIndex];
            for (int i = 0, j = markerIndex + 1; i < newArr.length; i++, j++) {
                newArr[i] = arr[j];
            }
            return newArr;
        }
    }

    public boolean checkArray(int[] arr) {
        boolean result = false;
        boolean contains_1 = false;
        boolean contains_4 = false;
        for (int i = 0; i < arr.length; i++) {
            if (!contains_1){
                if (arr[i] == 1) {
                    contains_1 = true;
                }
            }
            if (!contains_4){
                if (arr[i] == 4) {
                    contains_4 = true;
                }
            }
            if (contains_1 && contains_4) {
                result = true;
                break;
            }
        }
        return result;
    }
}
