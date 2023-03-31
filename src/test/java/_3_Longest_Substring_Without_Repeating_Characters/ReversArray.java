package _3_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReversArray {

    @Test
    public void reverseOddArrayTest(){
        assertArrayEquals(new char[]{'3', '2', '1' }, reverseArray(new char[]{'1', '2', '3'}));
    }

    @Test
    public void reverseEventArrayTest(){
        assertArrayEquals(new char[]{'4', '3', '2', '1' }, reverseArray(new char[]{'1', '2', '3', '4'}));
    }

    @Test
    public void tt(){
        int a = 2;
        int b = 5;
        System.out.println((b / a));

    }

    char[] reverseArray(char[] startState){
        int length = startState.length;

        for(int i = 0; i < length/2; i++){
            char t = startState[i];
            startState[i] = startState[length - i - 1];
            startState[length - i - 1] = t;
        }
        return startState;
    }
}
