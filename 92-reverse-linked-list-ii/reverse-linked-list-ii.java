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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        ListNode ans = new ListNode(0);
        ListNode temp = head;
        ListNode ansHead = ans;
        int pos =1;

        while (pos<left) {
            ans.next = new ListNode(temp.val);
            temp = temp.next;
            ans = ans.next;
            pos++;
        }

        Stack<Integer> st = new Stack<>();
        while (pos<=right) {
            st.push(temp.val);
            temp = temp.next;
            pos++;
        }
        // if (temp != null) {
        //     st.push(temp.val);
        //     temp = temp.next;
        // }

        while (!st.isEmpty()) {
            ans.next = new ListNode(st.pop());
            ans = ans.next;
        }

        while (temp != null) {
            ans.next = new ListNode(temp.val);
            temp = temp.next;
            ans = ans.next;
        }

        return ansHead.next;
    }
}