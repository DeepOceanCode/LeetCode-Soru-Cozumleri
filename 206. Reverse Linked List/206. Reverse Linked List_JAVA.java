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
    public ListNode reverseList(ListNode head) {
        ListNode reversedListNode = null;
        ListNode tmp = head;
        while(tmp != null){
            if(reversedListNode == null){
                reversedListNode = new ListNode();
                reversedListNode.val = tmp.val;
            }else{
                ListNode nd = new ListNode();
                nd.val = tmp.val;
                nd.next = reversedListNode;
                reversedListNode = nd;
            }
            tmp = tmp.next;
        }
        return reversedListNode;
    }
}