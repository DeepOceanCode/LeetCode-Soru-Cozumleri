/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var reversedListNode: ListNode? = null
        var tmp = head
        while(tmp != null){
            if(reversedListNode == null){
                reversedListNode = ListNode(tmp.`val`)
            }else{
                val nd = ListNode(tmp.`val`)
                nd.next = reversedListNode
                reversedListNode = nd
            }
            tmp = tmp.next
        }
        return reversedListNode;
    }
}