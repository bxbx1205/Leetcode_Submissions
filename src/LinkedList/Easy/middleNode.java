package LinkedList.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class middleNode {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    static public ListNode middleNode(ListNode head) {
        if(head==null || head.next == null) return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
