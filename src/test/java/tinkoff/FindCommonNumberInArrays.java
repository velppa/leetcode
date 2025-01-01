package tinkoff;

import org.junit.Test;

import java.util.Objects;
import static org.junit.Assert.assertEquals;

public class FindCommonNumberInArrays {

    @Test
    public void testSolution(){
        Integer[] a1 = {1,2,3};
        Integer[] a2 = {4,5,6};
        Integer[] a3 = {7,8,9};
        assertEquals(getCommonNumber(a1,a2,a3), null);

        a2 = new Integer[]{3,4,5};
        assertEquals(getCommonNumber(a1,a2,a3), null);

        a3 = new Integer[]{3,40,50};
        assertEquals(getCommonNumber(a1,a2,a3), Integer.valueOf(3));
    }

    Integer getCommonNumber(Integer [] a1, Integer [] a2, Integer [] a3){

        for (Integer integer : a1) {
            for (Integer value : a2) {
                if (Objects.equals(integer, value)) {
                    for (Integer item : a3) {
                        if (Objects.equals(integer, item)) {
                            return integer;
                        }
                        // no consists same number
                        if (integer > item) {
                            return null;
                        }
                    }
                }

                // no consists same number
                if (integer > value) {
                    return null;
                }

            }
        }

        return null;
    }

}
