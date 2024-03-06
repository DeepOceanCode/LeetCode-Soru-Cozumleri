/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var reverseList = function(head) {
    let reversedListNode = null;
    let tmp = head;
    while (tmp !== null) {
        const newNode = new ListNode(tmp.val);
        newNode.next = reversedListNode;
        reversedListNode = newNode;
        tmp = tmp.next;
    }
    return reversedListNode;
};