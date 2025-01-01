package _3_2_Longest_Substring_Without_Repeating_Characters;

import org.junit.Test;

import java.util.HashSet;

import java.util.Set;
import static org.junit.Assert.*;
public class LongestSubstringWithoutRepeatingCharacters {

    @Test
    public void test(){
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(4, lengthOfLongestSubstring("abcd"));
        assertEquals(1, lengthOfLongestSubstring("a"));
        assertEquals(4, lengthOfLongestSubstring("aabcd"));
        assertEquals(4, lengthOfLongestSubstring("aabcddhg"));
        assertEquals(0, lengthOfLongestSubstring(""));
    }


    public int lengthOfLongestSubstring(String s){

        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        int i;
        int j;

        for(i = 0; i < s.length(); i++){
            for(j = i; j < s.length(); j++){

                char curChar = s.charAt(j);

                if(set.contains(curChar)){
                    maxLength = Math.max(maxLength, set.size());
                    set.clear();
                    break;
                } else {
                    set.add(curChar);
                    // check if j is last then return
                    if(j == s.length() - 1){
                        maxLength = Math.max(maxLength, set.size());
                        return maxLength;
                    }
                }


            }


        }

        return maxLength;
    }
}
