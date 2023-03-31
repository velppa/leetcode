package principle_of_recurtion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedList {

    @Test
    public void test1(){
        final ListNode a1 = fillValuesToList(Arrays.asList(1,2,4));
        System.out.println(a1);
        final ListNode b1 = fillValuesToList(Arrays.asList(1,3,4));
        System.out.println(b1);

        System.out.println(mergeTwoLists(a1, b1));
    }

    ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode rCurrent = new ListNode();
        ListNode rHead = rCurrent;
        ListNode prev = null;

        while (true) {

            if (a == null && b == null) {
                if(prev != null){
                    prev.next = null;
                    return rHead;
                } else {
                    return null;
                }
            } else {
                prev = rCurrent;
            }

            if (a == null) {
                rCurrent.val = b.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                b = b.next;
            } else if (b == null) {
                rCurrent.val = a.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                a = a.next;
            } else if (a.val < b.val) {
                rCurrent.val = a.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                a = a.next;
            } else if (b.val < a.val) {
                rCurrent.val = b.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                b = b.next;
            } else if (a.val == b.val) {
                rCurrent.val = a.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                a = a.next;
                prev = rCurrent;

                rCurrent.val = b.val;
                rCurrent.next = new ListNode();
                rCurrent = rCurrent.next;
                b = b.next;
            }
        }
    }


    public class ListNode{
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    ListNode fillValuesToList(List<Integer> listOfValues){
        ListNode rCur = listOfValues.size() == 0 ? null : new ListNode();
        ListNode head = rCur;

        for (int idx = 0; idx < listOfValues.size() ; idx++){
            rCur.val = listOfValues.get(idx);
            rCur.next = idx == (listOfValues.size() - 1)  ? null : new ListNode();
            rCur = rCur.next;
        }

        return head;
    }

}
