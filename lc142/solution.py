from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head: Optional[ListNode]) -> Optional[ListNode]:

        slow = fast = head
        cycle_detected = False

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                cycle_detected = True
                break

        if not cycle_detected:
            return None

        slow = head
        while slow != fast:
            slow = slow.next
            fast = fast.next

        return slow