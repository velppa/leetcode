package principle_of_recurtion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PascalTriangle2 {

    @Test
    public void test(){
        assertEquals(Arrays.asList(1,1), getRow(1));
        assertEquals(Arrays.asList(1), getRow(0));
        assertEquals(Arrays.asList(1,3,3,1), getRow(3));

        System.out.println(getRow(31));
    }

    List<Integer> getRow(int rowIndex){
        return recursionTravers(rowIndex, 0, Arrays.asList(1));
    }

    List<Integer> recursionTravers(int rowIndex, int rowCounter, List<Integer> integers){
        if(rowIndex == rowCounter){
            return integers;
        } else {
            return recursionTravers(rowIndex, ++rowCounter, getNextLevel(integers));
        }
    }


    @Test
    public void testGetNextLevel(){
        assertEquals(Arrays.asList(1,2,1), getNextLevel(Arrays.asList(1,1)));
        assertEquals(Arrays.asList(1,3,3,1), getNextLevel(Arrays.asList(1,2,1)));
        assertEquals(Arrays.asList(1,1), getNextLevel(Arrays.asList(1)));
    }

    List<Integer> getNextLevel(List<Integer> integers){
        List<Integer> nl = new ArrayList<>(integers.size() + 1);
        nl.add(1);

        if(integers.size() > 1){
            Integer prevVal = null;
            for (Integer cur : integers){
                if(prevVal == null){
                    prevVal = cur;
                } else {
                    nl.add(cur + prevVal);
                    prevVal = cur;
                }
            }
        }
        nl.add(1);
        return nl;
    }

}
