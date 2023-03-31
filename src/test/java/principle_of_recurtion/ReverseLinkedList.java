package principle_of_recurtion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static principle_of_recurtion.SwapNodesInPairs.ListNode;

public class ReverseLinkedList {

    @Test
    public void test1(){
        ListNode listNode = new ListNode(1, new ListNode(2 , new ListNode(3, new ListNode(4 , new ListNode(5)))));

        ListNode head = reverseList(listNode);
        System.out.println(head);

        ListNode expected = new ListNode(5 , new ListNode(4, new ListNode(3 , new ListNode(2, new ListNode(1)))));
        assertEquals(expected, head);
    }

    @Test
    public void test2(){
        ListNode listNode = new ListNode(1, new ListNode(2));

        ListNode head = reverseList(listNode);
        System.out.println(head);

        ListNode expected = new ListNode(2, new ListNode(1));
        assertEquals(expected, head);
    }

    @Test
    public void test3(){
        ListNode listNode = new ListNode(1);

        ListNode head = reverseList(listNode);
        System.out.println(head);

        ListNode expected = new ListNode(1);
        assertEquals(expected, head);
    }



    public ListNode reverseList(ListNode head) {
        return recursionRevertList2(null, head);
    }

    // work with couple (height complexity)
    ListNode recursionRevertList(ListNode prevNode, ListNode head){
        if(head == null){
            return prevNode;
        }

        ListNode first = head;
        ListNode second = head.next;

        first.next = prevNode;

        if (second == null) {
            return first;
        }

        ListNode nextIterationNode = second.next;
        second.next = first;

        return recursionRevertList(second, nextIterationNode);
    }

    ListNode recursionRevertList2(ListNode prevNode, ListNode head){
        if(head == null){
            return prevNode;
        }
        ListNode nextIterationNode = head.next;
        head.next = prevNode;
        return recursionRevertList2(head, nextIterationNode);
    }

}
