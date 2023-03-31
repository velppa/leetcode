package _4_median_of_two_sorted_arrays;

import org.junit.Test;

public class MedianOfTwoSortedArrays {

    @Test
    public void test1() {
        int[] ar1 = {1,3,8,10};
        int[] ar2 = {4,5,9,13,15,20};


        joinArray2(ar1, ar2);
        //System.out.println(getMedianTwoArray(ar1, ar2));
    }

    @Test
    public void test2() {
        int[] ar1 = {1, 2, 5, 6, 9, 10};
        int[] ar2 = {3, 4, 7, 8, 11, 12, 13};

        joinArray2(ar1, ar2);
        //System.out.println(getMedianTwoArray(ar1, ar2));
    }

    @Test
    public void test3() {
        int[] ar1 = {1};
        int[] ar2 = {3, 4, 7, 8, 11, 12, 13};

        joinArray2(ar1, ar2);
        //System.out.println(getMedianTwoArray(ar1, ar2));
    }

    double getMedianTwoArray(int[] ar1, int[] ar2) {
        int sumSize = ar1.length > ar2.length ? ar1.length : ar2.length;
        int idx1 = sumSize / 2;
        int idx2 = 0;
        boolean isEven = false;

        if (sumSize % 2 == 0) {
            isEven = true;
            idx2 = idx1 + 1;
        }

        if (isEven) {
            int val1 = getVal(idx1, ar1, ar2);
            int val2 = getVal(idx2, ar1, ar2);
            return (val1 + val2) / 2;
        } else {
            return getVal(idx1, ar1, ar2);
        }
    }

    int getVal(int idx, int[] ar1, int[] ar2) {
        if (existsVal(idx, ar1)) {
            return ar1[idx];
        } else {
            return ar2[idx];
        }
    }

    boolean existsVal(int idx, int[] array) {
        return idx >= 0 && idx < array.length;
    }

    void joinArray(int[] ar1, int[] ar2) {
        int sumSize = ar1.length + ar2.length;


        int k = 0;

        for (int i = 0; i < ar1.length; i++) {
            int v1 = ar1[i];
            for (; k < ar2.length; k++) {
                int v2 = ar2[k];
                if (v1 < v2) {
                    System.out.println("=" + v1);
                    break;
                } else {
                    System.out.println("=" + v2);
                }
            }

        }
    }

    void joinArray2(int[] ar1, int[] ar2) {
        int sumSize = ar1.length + ar2.length;

        if(ar2.length > ar1.length){
            int[] tmp = ar1;
            ar1 = ar2;
            ar2 = tmp;
        }

        int idx1 = 0;
        int idx2 = 0;


        while (idx1 < ar1.length) {
            int v1 = ar1[idx1];
            while (idx2 < ar2.length) {
                int v2 = ar2[idx2];
                if (v1 < v2) {
                    break;
                } else {
                    System.out.println("2= " + v2);
                    idx2++;
                }
            }
            System.out.println("1= " + v1);
            idx1++;

        }
    }
}
