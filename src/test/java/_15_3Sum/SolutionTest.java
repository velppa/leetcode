package _15_3Sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionTest {

    @Test
    public void test(){
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // sort array from small to big values
        Arrays.sort(nums);

        for(int i=0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k){
                int total = nums[i] + nums[j] + nums[k];

                if(total > 0){
                    k--;
                } else if (total < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;

                    while (nums[j] == nums[j - 1] && j < k){
                        j++;
                    }
                }

            }

        }

        return result;

    }
}
