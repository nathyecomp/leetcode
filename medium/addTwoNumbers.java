/*
Improve the code!
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode root = null;
        ListNode result = null;
        int remaining = 0;
        int numNodes = 0;
        while(node1!=null || node2!=null){
            int vNode1 = 0;
            int vNode2 = 0;
            if(node1==null) vNode1 = 0;
            else {
                vNode1 = node1.val;
                node1 = node1.next;
            }
            if(node2==null) vNode2 = 0;
            else {
                vNode2 = node2.val;
                node2 = node2.next;
            }
            int val = remaining+vNode1+vNode2;
            remaining = 0;
            if(val>=10) {
                remaining = 1;
                val = val - 10;
            }
            ListNode nodeR = new ListNode(val);
            if(numNodes ==0){
                root = nodeR;
                result = nodeR;
            }
            else{
                result.next = nodeR;
                result = result.next;
            }
            numNodes++;
        }
        if(remaining!=0){
            ListNode nodeR = new ListNode(1);
            result.next = nodeR;
            result = result.next;
        }
        result.next = null;
        return root;
    }

}