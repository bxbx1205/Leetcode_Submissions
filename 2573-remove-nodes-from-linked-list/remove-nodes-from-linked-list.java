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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Collections.reverse(list);

        int max = Integer.MIN_VALUE;
        int i = 0;

        while (i < list.size()) {
            int current = list.get(i);

            if (current < max) {
                list.remove(i);
            } else {
                max = Math.max(max, current);
                i++;
            }
        }
        int n = list.size();
        ListNode ans = new ListNode(0);
        ListNode ansHead = ans;
        for (i = n - 1; i >= 0; i--) {
            ans.next = new ListNode(list.get(i));
            ans = ans.next;

        }

        return ansHead.next;
    }
}