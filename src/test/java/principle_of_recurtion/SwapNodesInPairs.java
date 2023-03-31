package principle_of_recurtion;

import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class SwapNodesInPairs {

    @Test
    public void test1(){
        ListNode listNode = new ListNode(1, new ListNode(2 , new ListNode(3, new ListNode(4 , new ListNode(5, new ListNode(6))))));
        ListNode[] newHeadLink = new ListNode[1];
        recursionSwap(newHeadLink,null, listNode);
        System.out.println("out: " + newHeadLink[0].toString());

        ListNode expected = new ListNode(2, new ListNode(1 , new ListNode(4, new ListNode(3 , new ListNode(6, new ListNode(5))))));

        assertEquals(newHeadLink[0], expected);
    }

    @Test
    public void test2(){
        ListNode head1 = new ListNode(1);

        ListNode[] newHeadLink1 = new ListNode[1];
        recursionSwap(newHeadLink1,null, head1);

        ListNode expected1 = new ListNode(1);
        assertEquals(newHeadLink1[0], expected1);

        ////
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode[] newHeadLink2 = new ListNode[1];
        recursionSwap(newHeadLink2,null, head2);

        ListNode expected2 = new ListNode(2, new ListNode(1));
        assertEquals(newHeadLink2[0], expected2);
    }

    void recursionSwap(ListNode[] newHeadLink, ListNode prevNode, ListNode head){
        if(head == null || head.next == null){
            if(newHeadLink[0] == null) newHeadLink[0] = head;
            return;
        }

        // Nodes to be swap
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;
        // Set link for new head (instead firstNode)
        if(prevNode != null) prevNode.next = secondNode;

        // Init main head
        if(newHeadLink[0] == null) newHeadLink[0] = secondNode;

        // call recursion
        recursionSwap(newHeadLink, firstNode, firstNode.next);
    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; next = null; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode node = (ListNode) o;

            if (val != node.val) return false;
            return Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            int result = val;
            result = 31 * result + (next != null ? next.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder sb = new StringBuilder();
            sb.append("ListNode{");
            while (node != null){
                sb.append(node.val);
                if(node.next != null){
                    sb.append(",");
                }
                node = node.next;
            }
            sb.append("}");
            return sb.toString();
        }
    }

}
