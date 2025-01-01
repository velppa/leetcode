package _9_Palindrome_Number;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PalindromeNumber {

    @Test
    public void testStr(){
        assertEquals(isPalindrome(0), true);
        assertEquals(isPalindrome(-22), false);
        assertEquals(isPalindrome(123321), true);
        assertEquals(isPalindrome(123), false);
        assertEquals(isPalindrome(454), true);
        assertEquals(isPalindrome(5), true);
    }

    public boolean isPalindrome(int num){
        char[] arr = String.valueOf(num).toCharArray();
        if(arr.length == 1){
            return true;
        }

        for (int i = 0; i < arr.length/2; i++){
            if (arr[i] != arr[arr.length - 1 - i]){
                return false;
            }
        }

        return true;
    }
    
}
