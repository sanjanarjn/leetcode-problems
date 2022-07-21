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
        
        if(left == right || head == null)
            return head;
        
        int pos = 0;
        ListNode temp = head;
        ListNode leftPrev = null;
        ListNode leftNode = left == 1 ? head : null;
        ListNode rightNode = null;
        while(pos < left || pos < right) {
            pos++;
            
            if(pos == left - 1) {
                leftPrev = temp;
                leftNode = temp.next;
            }
            if(pos == right) {
                rightNode = temp;
            }
            temp = temp.next;
        }
        
        ListNode rightNext = rightNode.next;
        rightNode.next = null;
        
        ListNode prev = rightNext;
        ListNode curr = leftNode;
        while(curr != null) {
            ListNode currNxt = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = currNxt;
        }
        if(leftPrev != null) {
            leftPrev.next = prev;
        }
        else {
            head = prev;
        }
        return head;
    }
}