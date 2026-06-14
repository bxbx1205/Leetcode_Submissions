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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode prev= null;
        while(slow!=null){
            ListNode nextNode=slow.next;
            slow.next=prev;
            prev=slow;
            slow=nextNode;
        }

        ListNode first=head;
        ListNode second = prev;
        int sum=0;
        while(second!=null){
            int current=first.val+second.val;
            sum=Math.max(sum,current);
            first=first.next;
            second=second.next;
        }

        return sum;
    }
}