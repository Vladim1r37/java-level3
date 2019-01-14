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
}
