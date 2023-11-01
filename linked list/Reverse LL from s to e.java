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
     ListNode connect;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode dummy = new ListNode();
         dummy.next = head;
        ListNode beforeStart = dummy;
        ListNode afterEnd = dummy;

        if(right == left){
            return head;
        }
        
       
        for(int i = 0; i< left-1; i++){
            beforeStart =  beforeStart.next;
          
        }
      
        for(int i = 0; i< right; i++){
            afterEnd = afterEnd.next;
                    
        }
        connect = afterEnd.next ;
       afterEnd.next = null;
    

          ListNode start = beforeStart.next;
         
         
         
        ListNode reversed = reverse(start);

        beforeStart.next = reversed;
       
        
    

            return  dummy.next;

    }


    public ListNode reverse(ListNode n){

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = n;
        ListNode head = n;
  
       


            while(curr!=null){

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;


            }
 
    head.next = connect;
        return prev;



    }



}
