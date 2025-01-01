package yandex_second_algo_session;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Timlid {
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("number of task- ");
        int numTask= sc.nextInt();
        sc.nextLine();
        System.out.print("List of Complexity tasks (use \",\" delimeter)- ");
        String taskStr= sc.nextLine();
        sc.close();

        List<Integer> taskArr = Arrays.stream(taskStr.split(",")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(findCommonSum(numTask, taskArr));

    }


    // (3,9),(7,5) и(1,11)
    // 12
    @Test
    public void test(){
        String tasklist = "1,3,5,7,9,11";
        List<Integer> taskArr = Arrays.stream(tasklist.split(",")).map(Integer::valueOf).collect(Collectors.toList());
        System.out.println(findCommonSum(6, taskArr));


        String tasklist2 = "2,4,5,6,6,7,10,17";
        List<Integer> taskArr2 = Arrays.stream(tasklist2.split(",")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(findCommonSum(8, taskArr2));

        String tasklist3 = "";
        List<Integer> taskArr3 = Arrays.stream(tasklist3.split(",")).map(Integer::valueOf).collect(Collectors.toList());

        System.out.println(findCommonSum(0, taskArr3));

    }

    static Integer findCommonSum(int lengthArr, List<Integer> taskArr){
        if(lengthArr == 1)
            return Integer.valueOf(taskArr.get(0));

        Integer max = Collections.max(taskArr);

        Map<Integer, Integer> sumCounter = new HashMap<>();

        for(int i = 0; i < lengthArr; i++){
            List<Integer> oneNumSum = new ArrayList<>();
            Integer c1 = taskArr.get(i);
            for(int j = 0; j < lengthArr; j++){
                Integer c2 = taskArr.get(j);
                if(i != j){
                    int sum = c1 + c2;
                    if(sum > max){
                        sumCounter.merge(sum, 1,Integer::sum);
                    }
                }
            }
        }

        Map.Entry<Integer, Integer> max1 = Collections.max(sumCounter.entrySet(), Map.Entry.comparingByValue());
        return max1 != null && max1.getValue() == lengthArr ? max1.getKey() : -1;
    }

}
