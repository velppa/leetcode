package principle_of_recurtion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Pow1 {

    @Test
    public void test(){
        assertEquals(9.0, myPow(3,2), 0);
        assertEquals(0.125, myPow(2,-3), 0);
        assertEquals(-8.0, myPow(-2,3), 0);
        assertEquals(0.04, myPow(0.2,2), 0.00000000000000001);
        assertEquals(0.0, myPow(2.0,-2147483648), 0.00000000000000001);

    }

    double myPow(double num, int pow){
        long P = pow;
        if(pow < 0){
            num = 1 / num;
            P = -P;
        }
        return powIntern(num, P);
    }

    double powIntern(double num, long pow){
        if(pow == 0){
            return 1;
        }

        double res = powIntern(num, pow/2);
        if(pow%2 != 0){
            res = res * res * num;
        } else {
            res = res * res;
        }

        return res;
    }
}
