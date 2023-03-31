package _1_Two_Sum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSum {

    @Test
    public void test(){
        assertArrayEquals(new int[]{0,1}, twoSum(new int[]{2,7,11,15}, 9));
        assertArrayEquals(new int[]{1,2}, twoSum(new int[]{3,2,4}, 6));
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for (int j= i + 1; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    System.out.println(i+ "-" + j);
                    return new int[]{i, j};

                }
            }
        }
        return new int[]{};
    }

    @Test
    public void test2(){
        int i = 15 / 10;
        int i2 = 15 % 10;
        System.out.println(i);
        System.out.println(i2);
    }
}
