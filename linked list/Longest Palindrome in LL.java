/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public int solve(ListNode A) {

        ListNode prev = null;
        ListNode curr = A;

        int ans =0;
        ListNode nxt=null;
        while(curr != null){
        ans = Math.max(ans,2* count(prev,curr));
         nxt = curr.next;
         ans = Math.max(ans,2* count(prev,nxt)+1);
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
     
        return ans;

    }

    public int count(ListNode A, ListNode B){
        int num =0;

        while(A!= null && B!= null){
        if(A.val !=B.val){
            break;
        }
        num++;
        A = A.next;
        B = B.next;


    }
    return num;
    }

}
