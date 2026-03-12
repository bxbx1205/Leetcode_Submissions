package LinkedList.Easy;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        ListNode temp = head;
        int i =1;

        if(head==null || head.next==null) return null;
        while(temp!=null && temp.next!=null){
            if(map.containsKey(temp)){
                return (temp);
            }
            else{
                map.put(temp,i);
                i++;
                temp=temp.next;
            }
        }

        return null;
    }
}


//optimized

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(fast!=null && fast.next!=null){
                    if(slow==fast) return fast;
                    slow=slow.next;
                    fast=fast.next;
                }
            }


        }
        return null;
    }
}
