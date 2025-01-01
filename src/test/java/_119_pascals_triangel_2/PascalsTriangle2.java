package _119_pascals_triangel_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle2 {

    @Test
    public void calcListOfSumTest(){
        System.out.println(calcListOfSum(0));
    }


    List<Integer> calcListOfSum(int rowIndex){
        List<List<Integer>> rows = new ArrayList<>();

        for(int i = 0; i <= rowIndex ; i++){

            int sizeOfRow = i + 1;
            List<Integer> curList = new ArrayList<>();

            for(int j = 0; j < sizeOfRow; j++){

                if(j == 0 || j == (sizeOfRow - 1)){
                    curList.add(j, 1); // set 1 to first and last elem
                } else {
                    List<Integer> prevRow = rows.get(i - 1);
                    curList.add(j, (prevRow.get(j -1) + prevRow.get(j)));
                }
            }

            rows.add(i, curList);
        }

        return !rows.isEmpty() ? rows.get(rows.size() - 1) : null;
    }
}
