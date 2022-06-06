/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        int count1 = count(headA);
        int count2 = count(headB);
        
        ListNode fast = headA;
        ListNode slow = headB;
        if(count1 < count2) {
            slow = headA;
            fast = headB;
        }
        
        if(count1 != count2) {
            int diff = Math.abs(count1 - count2);
            while(diff > 0) {
                fast = fast.next;
                diff--;
            }
        }
        
        while(slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
        
    }
    
    private int count(ListNode headA) {
        
        int count = 0;
        ListNode temp = headA;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}