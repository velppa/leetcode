package _6_ZigZag_Conversion;

import org.junit.Test;
import static org.junit.Assert.*;

public class DivideTest {


    @Test
    public void intDivide(){
        int a = 2;
        int b = 5;
        assertEquals(2, b / a);
    }

    @Test
    public void doubleTest(){
        double a = 2.0;
        double b = 5.0;
        assertEquals(2.5, b / a, 0);
    }

    @Test
    public void floatTest(){
        float a = 2.0F;
        float b = 5.0F;
        assertEquals(2.5F, b / a, 0);
    }

    @Test
    public void infinityTest(){
        double dd = Double.MAX_VALUE + Double.MAX_VALUE;
        assertTrue(Double.POSITIVE_INFINITY == dd);
        assertTrue(dd > Double.MAX_VALUE);
        assertTrue(Double.isInfinite(dd));

        double dd2 = Double.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY;
        assertTrue(Double.isNaN(dd2));

        double dd3 = Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY;
        assertTrue(Double.isNaN(dd3));
    }

    @Test
    public void longToIntCastingTest(){
        int aa = (int) Long.MAX_VALUE;
        assertTrue(-1 == aa);
    }

    @Test
    public void typeInferenceTest(){
        assertEquals("int", new TypeInferenceInOverrideMethod().methodWithIntegerParam(Integer.MAX_VALUE));

        int ii = Integer.MAX_VALUE + Integer.MAX_VALUE;
        assertEquals("int", new TypeInferenceInOverrideMethod().methodWithIntegerParam(ii));

        assertEquals(-2, ii);

    }

    static class TypeInferenceInOverrideMethod{
        String methodWithIntegerParam(int a){
            return "int";
        }

        String methodWithIntegerParam(long a){
            return "long";
        }
    }

    @Test
    public void roundTest(){
        System.out.println(6.0022e23 < Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Math.round(Double.MAX_VALUE));
        System.out.println(Math.round(6.0022e23));
        System.out.println(6.0022e23 / 200);
        System.out.println(Math.round(1.0022e10));
    }
}
