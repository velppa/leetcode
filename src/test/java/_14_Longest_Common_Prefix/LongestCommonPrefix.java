package _14_Longest_Common_Prefix;

import org.junit.Test;


import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefix {

    @Test
    public void someTest() {
        String[] strs = {"flower","flow","flight"};
        assertEquals("fl", longestCommonSubstring(strs));

        strs = new String[]{"FF", "cdab123cdFF", "ggghhcdab123cdFF", "FF"};
        assertEquals("FF", longestCommonSubstring(strs));
    }


    public String longestCommonSubstring(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char[] firstLine = strs[0].toCharArray();

        int iCol=0;

        String retStr = "";
        while (iCol < firstLine.length){
            sb.append(firstLine[iCol]);

            for(int iRow=1; iRow < strs.length; iRow++){
                if(strs[iRow].contains(sb)) {
                    continue;
                } else {
                    sb.setLength(sb.length()-1);
                    if(sb.length() > retStr.length())
                        retStr = sb.toString();
                    sb.setLength(0);
                    break;
                }
            }
            iCol++;
        }

        if(sb.length() > retStr.length())
            retStr = sb.toString();

        return retStr;
    }


    @Test
    public void test2(){
        assertEquals("ab123", longestSubstring("cdab123cdFF", "ab123ghjFF"));
        assertEquals("ab123", longestSubstring("Ccdab123cd", "Cab123ghj"));
        assertEquals("FF", longestSubstring("cdab123cdFF", "FF"));
        assertEquals("F", longestSubstring("F", "F"));
    }

    String longestSubstring(String str1, String str2){

        char[] ar1 = str1.toCharArray();
        StringBuilder sb = new StringBuilder();
        String retStr = "";
        for(int i=0; i < ar1.length; i++){

            if(str2.contains(sb + String.valueOf(ar1[i]))){
                sb.append(ar1[i]);
                if(sb.length() > retStr.length()){
                    retStr = sb.toString();
                }
                continue;
            } else {
                sb.setLength(0);
            }
;        }

        return retStr;
    }

    @Test
    public void longestPrefixTest(){
        String[] stAr = {"abn","am"};
        assertEquals("a", longestCommonPrefix(stAr));
        String[] st2 = {"xabn","am"};
        assertEquals("", longestCommonPrefix(st2));
        String[] st3 = {"ab","a"};
        assertEquals("a", longestCommonPrefix(st3));
        String[] st4 = {"a"};
        assertEquals("a", longestCommonPrefix(st3));
    }

    public String longestCommonPrefix(String[] stAr) {
        if(stAr.length == 0)
            return "";
        if(stAr.length == 1)
            return stAr[0];

        Arrays.sort(stAr);
        String first = stAr[0];
        String last = stAr[stAr.length - 1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < first.length(); i++){

            if(last.length() > i && first.charAt(i) == last.charAt(i)){
                sb.append(first.charAt(i));
            } else {
                return sb.toString();
            }
        }

        return sb.toString();
    }

    @Test
    public void input(){


    }

}
