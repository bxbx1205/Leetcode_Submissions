class Solution {
    public void tailInsert(ListNode head, ListNode newNode) {
        if (head == null) return;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1); 
        ListNode tail = dummy;

        temp = head;
        while (temp != null) {
            if (map.get(temp.val) == 1) { 
                tail.next = new ListNode(temp.val);
                tail = tail.next;
            }
            temp = temp.next;
        }

        return dummy.next; 
    }
}
