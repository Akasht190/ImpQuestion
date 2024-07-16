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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        Set<Integer> hm=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            hm.add(nums[i]);
        }

        while(head!=null){
            if(!hm.contains(head.val)){
                tail.next=head;;
                tail=tail.next;
            }
            head=head.next;
        }
       tail.next=null;
       return dummy.next;
    }
}