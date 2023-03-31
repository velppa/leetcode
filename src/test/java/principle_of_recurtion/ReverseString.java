package principle_of_recurtion;

import org.junit.Test;

import java.util.Arrays;

public class ReverseString {

    @Test
    public void test(){
        char[] s = {'h', 'e', 'l', 'l', '0','!'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    void reverseString(char[] s){
        char t;
        int f = 0;
        int l = s.length - 1;
        while (f < l){
            t = s[l];
            s[l] = s[f];
            s[f] = t;
            f++;
            l--;
        }
    }
}
