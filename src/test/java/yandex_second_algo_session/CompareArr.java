package yandex_second_algo_session;

import org.junit.Test;

import java.util.*;

public class CompareArr {

    @Test
    public void testArrayCompare(){
        List<Integer> l1 = Arrays.asList(1,2,3);
        List<Integer> l2 = Arrays.asList(1,2,3,4);

        System.out.println(l1.equals(l2));

        Map<String, String> m1 = new HashMap() {{
            put("1","1");
            put(new String("2"),new String("2"));
        }};
        Map<String, String> m2 = new HashMap() {{
            put("1","1");
            put(new String("2"),new String("3"));
        }};
        System.out.println(m1.equals(m2));

    }


}
