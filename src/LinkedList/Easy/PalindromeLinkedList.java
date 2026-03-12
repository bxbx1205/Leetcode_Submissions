package LinkedList.Easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode current = head;
        ListNode next = head.next;

        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode newHead =  reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        while(second!=null){

            if(first.val!=second.val) {
                reverse(newHead);
                return false;
            }

            first=first.next;
            second=second.next;
        }

        reverse(newHead);
        return true;

    }
}