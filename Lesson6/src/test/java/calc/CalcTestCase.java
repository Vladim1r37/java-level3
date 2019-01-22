package calc;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTestCase {

    private ICalc calc;

    @Before
    public void prepare() {
        this.calc = new Calc();
    }

    @After
    public void tearDown() {
        this.calc = null;
    }

    @Test
    public void test_sum1() {
        Assert.assertEquals(4, calc.add(2, 2));
    }


    @Test
    public void test_sum2() {
        Assert.assertEquals(16, calc.add(7, 9));
    }

    @Test
    public void test_sub() {
        Assert.assertEquals(-15, calc.sub(-5, 10));
    }

    @Test
    public void test_mul() {
        Assert.assertThat(calc.mul(-5, 10), Is.is(-50));
    }

    @Test
    public void test_div() {
        Assert.assertThat(calc.div(15, 3), Is.is(5));
    }

    @Test(expected = ArithmeticException.class)
    public void test_div_by_zero() {
        Assert.assertThat(calc.div(15, 0), Is.is(0));
    }
}
