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
    public ListNode reverseList(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        ListNode temp= head;
        ListNode temp2= head;

        while(temp!=null){
            stack.add(temp.val);
            temp=temp.next;
        }

        while (!stack.isEmpty()){
            temp2.val=stack.peek();
            stack.pop();
            temp2=temp2.next;
        }
        return head;

    }
}