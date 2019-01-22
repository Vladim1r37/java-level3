package dz;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayUtilsTestCase {

    private ArrayUtils arrayUtils;

    @Before
    public void prepare() {
        this.arrayUtils = new ArrayUtils();
    }

    @After
    public void tearDown() {
        this.arrayUtils = null;
    }

    @Test
    public void testCutArrayByMarker1() {
        int[] inputArr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] expectedArr = {1, 7};
        Assert.assertArrayEquals(expectedArr, arrayUtils.cutArrayByMarker(inputArr));
    }

    @Test
    public void testCutArrayByMarker2() {
        int[] inputArr = {4, 2, 5, 3, 2, 3, 2, 1, 7};
        int[] expectedArr = {2, 5, 3, 2, 3, 2, 1, 7};
        Assert.assertArrayEquals(expectedArr, arrayUtils.cutArrayByMarker(inputArr));
    }

    @Test
    public void testCutArrayByMarker3() {
        int[] inputArr = {1, 2, 4, 4, 2, 3, 4, 1, 4};
        int[] expectedArr = {};
        Assert.assertArrayEquals(expectedArr, arrayUtils.cutArrayByMarker(inputArr));
    }

    @Test(expected = RuntimeException.class)
    public void testCutArrayByMarker4() {
        int[] inputArr = {1, 2, 3, 5, 2, 3, 2, 1, 7};
        int[] expectedArr = {};
        Assert.assertArrayEquals(expectedArr, arrayUtils.cutArrayByMarker(inputArr));
    }

    @Test
    public void testCheckArray1() {
        int[] arr = {};
        Assert.assertEquals(false, arrayUtils.checkArray(arr));
    }

    @Test
    public void testCheckArray2() {
        int[] arr = {1};
        Assert.assertEquals(false, arrayUtils.checkArray(arr));
    }

    @Test
    public void testCheckArray3() {
        int[] arr = {4, 4, 4};
        Assert.assertEquals(false, arrayUtils.checkArray(arr));
    }

    @Test
    public void testCheckArray4() {
        int[] arr = {4, 4, 4, 1};
        Assert.assertEquals(true, arrayUtils.checkArray(arr));
    }
}
