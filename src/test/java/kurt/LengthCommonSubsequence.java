package kurt;

import org.junit.Test;

public class LengthCommonSubsequence {

    @Test
    public void test(){
        String str1 = "";
        String str2 = "";
        int[][] lcsTable = computeLengthCommonSubsequenceTable(str1, str2);
        System.out.println(lcsTable[lcsTable.length - 1][lcsTable[0].length - 1]);

        for(int i = 0; i < lcsTable.length; i++){
            for(int j = 0; j < lcsTable[0].length; j++){
                if(j != lcsTable[0].length - 1){
                    System.out.print(" " + lcsTable[i][j]);
                } else {
                    System.out.println(" " + lcsTable[i][j]);
                }
            }
        }

        System.out.println("LCS: " + computeLengthCommonSubsequence(str1, str2, lcsTable, lcsTable.length - 1, lcsTable[0].length - 1));
    }

    String computeLengthCommonSubsequence(String strI,
                                          String strJ,
                                          int[][] mtrx,
                                          int i,
                                          int j){

        if(mtrx[i][j] == 0)
            return "";

        char chI = strI.charAt(i - 1);
        char chJ = strJ.charAt(j - 1);

        if(chI == chJ){
            return computeLengthCommonSubsequence(strI, strJ, mtrx, i - 1, j - 1) + chI;
        } else {
            if(mtrx[i][j - 1] > mtrx[i - 1][j]){
                return computeLengthCommonSubsequence(strI, strJ, mtrx, i, j - 1);
            } else {
                return computeLengthCommonSubsequence(strI, strJ, mtrx, i - 1, j);
            }
        }
    }

    int[][] computeLengthCommonSubsequenceTable(String strI, String strJ){
        int[][] mtrx = new int[strI.length() + 1][strJ.length() + 1];

        //init first line and column to zero
        for(int i = 0; i < mtrx[0].length; i++)
            mtrx[0][i] = 0;
        for(int i = 0; i < mtrx.length; i++)
            mtrx[i][0] = 0;

        for(int i = 1; i < mtrx.length; i++){
            for(int j = 1; j < mtrx[0].length; j++){
                char chI = strI.charAt(i - 1);
                char chJ = strJ.charAt(j - 1);

                if(chI == chJ){
                    mtrx[i][j] = mtrx[i - 1][j - 1] + 1;
                } else {
                    mtrx[i][j] = Math.max(mtrx[i - 1][j], mtrx[i][j - 1]);
                }
            }
        }

        return mtrx;
    }
}
