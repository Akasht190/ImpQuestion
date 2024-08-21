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
    public ListNode swapPairs(ListNode head) {
        return solve(head);
    }

    private ListNode solve(ListNode head){
        if(head==null || head.next==null) return head;

        ListNode tail=head.next;
        head.next=solve(tail.next);
        tail.next=head;
        return tail;
    }
}