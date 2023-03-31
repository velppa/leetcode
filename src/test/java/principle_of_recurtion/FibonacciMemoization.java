package principle_of_recurtion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciMemoization {

    @Test
    public void test(){
        assertEquals(0, fib(0));
        assertEquals(1, fib(1));
        assertEquals(1, fib(2));
        assertEquals(2, fib(3));
        assertEquals(3, fib(4));
        assertEquals(55, fib(10));
    }

    int fib(int n){
        if(n == 0)
            return 0;

        return recursionFib(n, 1, 0, 1);
    }

    private int recursionFib(int nOrder, int i, int prevSum, int current){
        if(i == nOrder)
            return current;

        return recursionFib(nOrder, ++i, current, current + prevSum);
    }

}
