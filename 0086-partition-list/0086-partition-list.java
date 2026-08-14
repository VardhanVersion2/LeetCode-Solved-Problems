class Solution {
    public ListNode partition(ListNode head, int x) {
       
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

    
        ListNode less = lessHead;  // pointer 
        ListNode greater = greaterHead;  //pointer 
        
        ListNode curr = head;  //link to head
        
        while (curr != null) {
            if (curr.val < x) {
                less.next = curr;      // JOIN 
                less = less.next;       // less pointer ko aage badao
            } else {
                greater.next = curr;    // JOIN 
                greater = greater.next; // greater pointer ko aage badao
            }
            
            curr = curr.next;          
        }
        
        
        greater.next = null;
        
        // 5. Less list ke end ko Greater list ke start se connect karo
        less.next = greaterHead.next;
        
        // 6. Partitioned list ka head return karo
        return lessHead.next;
    }
}