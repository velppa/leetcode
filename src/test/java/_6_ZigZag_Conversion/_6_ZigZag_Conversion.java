package _6_ZigZag_Conversion;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static _6_ZigZag_Conversion.ZigZagUtils.*;

public class _6_ZigZag_Conversion {
    // "PAYPALISHIRING"
    // "PINALSIGYAHRPI"

    @Test
    public void test(){

        //"PAYP AL ISHI RI NG"
        String s = "PAYPALISHIRING";
        int nRows = 4;
        int middleNRoms = (nRows - 2) <= 0 ? 0 : (nRows - 2);
        double nColumn = Math.ceil((s.length() * 2/(double)(nRows + middleNRoms)));

        System.out.println("length -> " + s.length());
        System.out.println("nColumn -> " + nColumn);


        int sumLargeColumns = 0;
        int sumShortColumns = 0;
        int charCounter = 0;


        int counterChar = 0;
        while (true){
            charCounter = charCounter + nRows;
            sumLargeColumns++;

            if(charCounter >= s.length())
                break;

            charCounter = charCounter + middleNRoms;
            sumShortColumns++;
            if(charCounter >= s.length())
                break;
        }

        System.out.println("charCounter -> " + charCounter);
        System.out.println("sumLargeColumns -> " + sumLargeColumns);
        System.out.println("sumShortColumns -> " + sumShortColumns);



    }

    void addFullColumn(char[][] matrix, int colNum, String columnValue){
        for(int r = 0; r < matrix.length; r++){
            matrix[r][colNum] = columnValue.charAt(r);
        }
    }

    void addShortColumn(char[][] matrix, int startRow, int starColumn, String columnValue){
        AtomicInteger sc = new AtomicInteger();

        for(; startRow > 0; startRow--){
            matrix[startRow][starColumn++] = columnValue.charAt(sc.getAndIncrement());
        }
    }

    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to).map(i -> to - i + from - 1);
    }

    @Test
    public void addFullColumnTest(){
        char[][] matrix = new char[3][2];
        initEmptyValues(matrix);
        String s = "abc";
        addFullColumn(matrix, 0, s);
        printMatrix(matrix);
    }
}
