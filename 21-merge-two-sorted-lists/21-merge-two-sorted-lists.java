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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode merged = null;
        ListNode tail = null;
        
        ListNode p1 = list1;
        ListNode p2 = list2;
        
        while(p1 != null && p2 != null) {
            
            ListNode current = new ListNode();
            
            if(p1.val <= p2.val) {
                current.val = p1.val;
                p1 = p1.next;
            }
            else {
                current.val = p2.val;
                p2 = p2.next;
            }
            if(merged == null) {
                merged = current;
                tail = current;
            }
            else {
                tail.next = current;
                tail = current;
            }
        }
        
        while(p1 != null) {
            ListNode node = new ListNode(p1.val);
            if(merged == null) {
                merged = node;
            }
            else {
                tail.next = node;
            }
            tail = node;
            
            p1 = p1.next;
        }
        while(p2 != null) {
            ListNode node = new ListNode(p2.val);
            if(merged == null) {
                merged = node;
            }
            else {
                tail.next = node;
            }
            tail = node;
            
            p2 = p2.next;
        }
        return merged;
    }
}