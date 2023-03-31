package _6_ZigZag_Conversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;
import static _6_ZigZag_Conversion.ZigZagUtils.*;

public class _6_ZigZag_Conversion_2 {


    @Test
    public void test() {
        String s = "ABCD";
        int nRows = 4;
        int middleNRoms = nRows > 2 ? (nRows - 2) : 0;
        int stringUnitLength = nRows + middleNRoms;

        System.out.println("middleNRoms -> " + middleNRoms);

        final List<Token> middleArray = new ArrayList<>();
        for(int i = 0; i < s.length(); i = i + stringUnitLength){
            int endIdx = i + stringUnitLength > s.length() ? s.length() : i + stringUnitLength;
            middleArray.add(new Token(s.substring(i, endIdx), stringUnitLength, nRows));
        }

        printMatrix(middleArray);

        System.out.println("----");
        String totalString = IntStream.range(0, nRows).mapToObj(i -> middleArray.stream().map(token -> token.getNext()).collect(Collectors.joining())).collect(Collectors.joining());
        System.out.println(totalString);
        System.out.println("----");
    }

    @Test
    public void convertTest(){
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
        assertEquals("A", convert("A", 1));

        assertEquals("ABC", convert("ABC", 3));
        assertEquals("ABCD", convert("ABCD", 4));
        assertEquals("ABDC", convert("ABCD", 3));
        assertEquals("ABCDFGHJLK", convert("ABCDFGHJKL", 9));
    }

    public String convert(String s, int numRows) {

        int middleNRoms = numRows > 2 ? (numRows - 2) : 0;
        int stringUnitLength = numRows + middleNRoms;

        final List<Token> middleArray = new ArrayList<>();
        for(int i = 0; i < s.length(); i = i + stringUnitLength){
            int endIdx = i + stringUnitLength > s.length() ? s.length() : i + stringUnitLength;
            middleArray.add(new Token(s.substring(i, endIdx), stringUnitLength, numRows));
        }

        return IntStream.range(0, numRows).mapToObj(i -> middleArray.stream().map(token -> token.getNext()).collect(Collectors.joining())).collect(Collectors.joining());
    }

    @Test
    public void test2(){
        String s = "PAYPALISHIRING";
        int nRows = 4;
        int middleNRoms = nRows > 2 ? (nRows - 2) : 0;
        int stringUnitLength = nRows + middleNRoms;

        System.out.println("middleNRoms -> " + middleNRoms);

        final List<String> middleArray = new ArrayList<>();
        for(int i = 0; i < s.length(); i = i + stringUnitLength){
            int endIdx = i + stringUnitLength;
            middleArray.add(rPadding(s,'-', i, endIdx));
        }

        printMatrix(middleArray);

        TokenMatrix tokenMatrix = new TokenMatrix(middleArray, nRows);

        System.out.println("-----");
        System.out.println(tokenMatrix.allProcess());
    }
}
