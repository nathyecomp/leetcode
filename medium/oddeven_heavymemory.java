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
        List<ListNode> oddList = new ArrayList<>();
        List<ListNode> evenList = new ArrayList<>();
        ListNode result = head;
        ListNode begin = head;
        int cont =1;
        while(head!=null){
            if(cont%2!=0){
                oddList.add(head);
            }
            else{
                evenList.add(head);
            }
            cont++;
            head = head.next;
        }
        begin = oddList.get(0);
        for(int i1 = 1; i1< oddList.size(); i1++){
          //  System.out.println("Odd node is "+ begin.val);
            begin.next = oddList.get(i1);
            begin = begin.next;
            
        }
        for(int i1 = 0; i1< evenList.size(); i1++){
           // System.out.println("Even node is "+ begin.val);
            begin.next = evenList.get(i1);
            begin = begin.next;
            
        }
    return result;
  }
}