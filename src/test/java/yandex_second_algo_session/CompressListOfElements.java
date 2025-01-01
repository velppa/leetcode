package yandex_second_algo_session;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class CompressListOfElements {
    /*
        Дан список интов, повторяющихся элементов в списке нет.
        Нужно преобразовать это множество в строку, сворачивая соседние по числовому ряду числа в диапазоны.

        Примеры:
         [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
         [1,4,3,2] => "1-4"
         [1,4] => "1,4"
         [1,2,4] => "1-2,4"
         [1] => ""
         [] => ?
    */
    @Test
    public void someTest() {
        int[] arr = {1, 2, 4, 5, 6};
        assertEquals("1-2,4-6", compress(arr));
        assertEquals("1-2,4-6", compress2(arr));
        int[] arr2 = {1, 4};
        assertEquals("1,4", compress(arr2));
        assertEquals("1,4", compress2(arr2));
        int[] arr3 = {1, 4, 5};
        assertEquals("1,4-5", compress(arr3));
        assertEquals("1,4-5", compress2(arr3));
    }

    // My variant of implementation.
    // It works but looks like ridiculous:
    // - used redundant var "cur"
    // - used redundant "if\else" condition after "for loop"
    public String compress(int[] array) {
        if (array.length == 0) {
            return "";
        }

        Arrays.sort(array);
        Integer cur = array[0];
        Integer start = array[0];
        String returnStr = "";
        // 1,2,3,4
        for (int i = 1; i < array.length; i++) {

            if ((cur + 1) == array[i]) {

            } else {
                if (start == cur) {
                    returnStr = returnStr + start;
                } else {
                    returnStr = returnStr + start + "-" + cur;
                }

                returnStr = returnStr + ",";
                start = array[i];
            }
            cur = array[i];
        }

        if (start == cur) {
            returnStr = returnStr + start;
        } else {
            returnStr = returnStr + start + "-" + cur;
        }

        return returnStr;
    }

    // 1,2,4,5

    public String compress2(int[] array) {
        int prev = array[0];

        String retStr = "" + prev;
        boolean isBetween = false;

        for(int i = 1; i < array.length; i++){

            if(prev + 1 != array[i]){

                if(isBetween){
                    retStr = retStr + "-" + prev;
                    isBetween = false;
                }

                retStr = retStr + "," + array[i];
            } else {
                isBetween = true;

                // if end then add last elem
                if(i + 1 == array.length)
                    retStr = retStr + "-" + array[i];
            }

            prev = array[i];
        }

        return retStr;
    }
}
