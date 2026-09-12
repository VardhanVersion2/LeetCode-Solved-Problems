/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast !=null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            // It s like extension like slow and fast met then we need to now point to equal steps to get - how muchh 

            //IN LC 141 - JUST FIND
            //IN LC 142 - JUST FIND (LC 142)+WHERE !!?

            if(slow == fast)
            {
              slow = head;

              while(slow !=fast)
              {
                slow = slow.next;
                fast = fast.next;
    
              }

              return slow ; // Cycle start length [where]

            }
        }

       return null;
        
    }
}