package _2_add_two_numbers;

import org.junit.Test;

import javax.naming.Name;

public class AddTwoNumbers {

    /**
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */

    @Test
    public void solutionTest(){
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        showListNode(addTwoNumbers(l1, l2));

        l1 = new ListNode(0);
        l2 = new ListNode(0);
        showListNode(addTwoNumbers(l1, l2));

        l1 = new ListNode(9,
                new ListNode(9,
                        new ListNode(9,
                                new ListNode(9,
                                        new ListNode(9,
                                                new ListNode(9))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        showListNode(addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode headList = new ListNode();
        ListNode cur = headList;
        int dec = 0;
        boolean curExist = false;

        while (true){
            if(l1 != null){
                cur.val = cur.val + l1.val;
                l1 = l1.next;
                curExist = true;
            }

            if(l2 != null){
                cur.val = cur.val + l2.val;
                l2 = l2.next;
                curExist = true;
            }

            if(curExist || dec > 0){
                cur.val = cur.val + dec;
                if(cur.val >= 10){
                    dec = 1;
                    cur.val = cur.val - 10;
                } else {
                    dec = 0;
                }

                // set next cur if "l1" or "l2" has next
                if((l1 != null || l2 != null) || dec > 0){
                    cur.next = new ListNode();
                    cur = cur.next;
                }

                curExist = false;
            } else {
                return headList;
            }
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val;this.next = next;}
    }

    void showListNode(ListNode l){
        while (true){
            if(l != null){
                System.out.print(l.val + "|");
                l = l.next;
            } else {
                System.out.println();
                return;
            }
        }
    }
}



