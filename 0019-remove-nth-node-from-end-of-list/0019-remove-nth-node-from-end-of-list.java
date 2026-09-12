
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

    //counter needed here .

    
    ListNode curr = head;
    int count = 0;
    
    

    while(curr != null ) 
    {
        
        curr=curr.next;
        count++;
    } 
     
     if(count == n)      //edge case
     {
        return head.next;
     }


    curr = head;
    for(int i =1; i<count-n ; i++)   //wheels running
    {
        curr = curr.next;
    }
    
        curr.next = curr.next.next;

        return head;
    
    }
}