# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reversedListNode = None
        tmp = head
        while tmp:
            if reversedListNode is None:
                reversedListNode = ListNode(tmp.val)
            else:
                tmpNode = ListNode(tmp.val, reversedListNode)
                reversedListNode = tmpNode
            tmp = tmp.next

        return reversedListNode