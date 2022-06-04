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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode midPoint = findMidPoint(head);
        
        ListNode nodeAfterMid = midPoint.next;
        midPoint.next = null;
        
        ListNode reversedSecondHalf = reverse(nodeAfterMid);
        
        merge(head, reversedSecondHalf);  
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        
        ListNode p1 = first;
        ListNode p2 = second;
        
        while(p1 != null && p2 != null) {
            ListNode p1Next = p1.next;
            
            p1.next = p2;
            
            p1 = p2;
            p2 = p1Next;
        }
        return first;
    }
    
    private ListNode reverse(ListNode node) {
        
        ListNode curr = node;
        ListNode prev = null;
        
        while(curr != null) {
            
            ListNode currNext = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
    
    private ListNode findMidPoint(ListNode node) {
        
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}