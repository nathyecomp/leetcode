/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public ListNode oddEvenList(ListNode head) {
        //Save memory reference
        ListNode result = head;
        
        if(head==null) return result;
        ListNode odd = head;
        ListNode even = head.next;
        //Save reference to the begin of the even list
        ListNode connect = head.next;
        //Supposing 1 2 3 4
        while(even!=null&&even.next!=null){
            //the next of 1 receives 3 
            odd.next = even.next;
            // now, the poiter points to 3
            odd = odd.next;
            
            //the next of 2 receives the next of 3, that is, 4
            even.next = odd.next;
            //now, the pointer points to 4
            even = even.next;
        }
        //the next of 3 points to 2 (that is the ref that was saved in connect)
        odd.next = connect;
        //return the ref to 1
    return result;
  }
}