package principle_of_recurtion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairs {

    @Test
    public void test(){

        System.out.println("resp: " + stairs(25));
        assertEquals(21, stairs(7));
    }

    int stairs(int numberOfSteps){
        int[] memo = new int[numberOfSteps];
        return stepIntern(0, numberOfSteps, memo);
    }

    int stepIntern(int i, int numberOfSteps, int[] memo){
        if(i > numberOfSteps)
            return 0;

        if(i == numberOfSteps)
            return 1;

        if(memo[i] > 0)
            return memo[i];

        memo[i] = stepIntern(i + 1, numberOfSteps, memo) + stepIntern(i + 2, numberOfSteps, memo);
        return memo[i];
    }
}
