package _6_ZigZag_Conversion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static _6_ZigZag_Conversion.ZigZagUtils.*;
import static org.junit.Assert.assertEquals;

public class _6_ZigZag_Conversion_3 {

    @Test
    public void convertTest(){
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));

    }

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        printMatrix(rows);

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

}
