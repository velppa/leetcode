package _13_Roman_to_Integer;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RomanToInteger {

    private static final Map<Character, Integer> alfaMap = new HashMap<>();
    static {
        alfaMap.put('I', 1);
        alfaMap.put('V', 5);
        alfaMap.put('X', 10);
        alfaMap.put('L', 50);
        alfaMap.put('C', 100);
        alfaMap.put('D', 500);
        alfaMap.put('M', 1000);
    }

    @Test
    public void test(){
        assertEquals(3, romanToInt("III"));
        assertEquals(58, romanToInt("LVIII"));
        assertEquals(4, romanToInt("IV"));
        assertEquals(1994, romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        char[] chArr = s.toCharArray();
        Integer prevInt = null;
        Integer totalInt = 0;
        for(int i = chArr.length - 1; i >= 0; i--){
            Integer curInt = alfaMap.get(chArr[i]);
            if(prevInt != null && prevInt > curInt){
                totalInt = totalInt - curInt;
            } else {
                totalInt = totalInt + curInt;
            }
            prevInt = curInt;
        }
        return totalInt;
    }
}
