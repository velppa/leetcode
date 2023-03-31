package _6_ZigZag_Conversion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ZigZagUtils {
    private ZigZagUtils(){}


    @Test
    public void printMatrixTest(){
        char[] l1 = {'a','b','c'};
        char[] l2 = {'1','2','3'};
        char[][] matrix = {l1, l2};
        printMatrix(matrix);
    }

    public static void initEmptyValues(final char[][] matrix){
        IntStream.range(0 , matrix.length).forEach(r -> IntStream.range(0, matrix[r].length).forEach(c -> matrix[r][c] = '-'));
    }

    public static void printMatrix(char[][] matrix){
        Arrays.asList(matrix).stream().map(chars -> String.valueOf(chars)).forEach(System.out::println);
    }

    public static void printMatrix(List<?> matrix){
        matrix.stream().map(t -> String.valueOf(t.toString())).forEach(System.out::println);
    }


    @Test
    public void rPaddingTest(){
        String s = "1234";

        assertEquals(s, rPadding(s, '-', 0, 4));
        assertEquals(s + "--", rPadding(s,'-', 0, 6));
        assertEquals("-", rPadding(s,'-', 4, 5));
        assertEquals("4-", rPadding(s,'-', 3, 5));
        assertEquals("3", rPadding(s,'-', 2, 3));
        assertEquals("3", s.substring(2, 3));
    }

    public static String rPadding(String s, char padLiteral, int startIdx, int endIdx){
        StringBuilder sb = new StringBuilder(s);

        if(s.length() <= startIdx){
            for(int i = startIdx;i < endIdx; i++ ){
                sb.append(padLiteral);
            }
            return sb.substring(startIdx, endIdx);
        }

        if(s.length() > startIdx && s.length() < endIdx){
            int l = s.length();
            for(;l < endIdx; l++){
                sb.append(padLiteral);
            }

            return sb.substring(startIdx, endIdx);
        }
        return sb.substring(startIdx, endIdx);
    }
}
