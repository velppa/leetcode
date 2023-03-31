package principle_of_recurtion;

import org.junit.Test;


/**
 * Wrong way to count level of binary tree
 */
public class MaximumDepthOfBinaryTree {

    private static final int MAXIMUM_CAPACITY = 2147483647;

    @Test
    public void test(){
        TreeNode root1 = new TreeNode(3,new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode root2 = new TreeNode(1,null, new TreeNode(2));

        TreeNode root3 = new TreeNode(1,new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5), null), null), null), null);

        //[1,2,null,3,null,4,null,5]
        System.out.println(maxDepth(root3));

//        assertEquals(3, getPowerFor(8));
//        assertEquals(2, getPowerFor(4));
//        assertEquals(1, getPowerFor(2));
//        assertEquals(0, getPowerFor(1));
//
//        assertEquals(3, maxDepth(root1));
//        assertEquals(2, maxDepth(root2));
    }

    public int maxDepth(TreeNode root) {
        int i = countNode(root);
        System.out.println("i=" + i);
        i++;
        int power = tableSizeFor(i);
        System.out.println("power=" + power);

        final int powerFor = getPowerFor(power);
        System.out.println("powerFor=" + powerFor);

        return powerFor;

    }

    public boolean degreeOfTwo(int n){
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    /**
     * Округление числа до верхней границы степени двойки, вариант с логарифмами
     * @param x
     * @return
     */
    public static int powerTwo(int x){
        if (x <= 0){
            // Если x <= 0, напрямую возвращаем 2 в степень 0
            return 1;
        } else if ((x & (x - 1)) == 0) {
            // Судя по операции "поразрядное И", если x является степенью 2, напрямую возвращаем x
            return x;
        } else {
            // Вычислить наименьшее целое число, большее логарифма x с основанием 2
            // Например, x = 25, логарифм 25 с основанием 2 равен 4,643 ..., результат принудительного преобразования в int и добавления 1 равен 5
            int n = (int)(Math.log(x) / Math.log(2)) + 1;
            return (int) Math.pow(2, n);
        }
    }

    /**
     * Округление числа до верхней границы степени двойки
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * @param power степень в которую нужно возвести число "2"
     * @return результат возведения степени
     */
    public static int getPowerOfTwo(int power) {
        return 1 << power;
    }

    /**
     * @param number получение степени двойки для числа
     * @return возвращение степени
     */
    public static int getPowerFor(int number){
        int i = 0;
        for(;;){
            if(number <= 1){
                return i;
            }

            number = number >> 1;
            i++;
        }
    }

    public int countNode(TreeNode root) {
        if(root == null){
            return 1;
        }
        return 1 + countNode(root.left) + countNode(root.right);
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
