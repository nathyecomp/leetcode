
 
public class Solution {
    Set<ListNode> visited = new HashSet<>();
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        if(visited.contains(head)) return true;
        visited.add(head);
        if(head.next!=null){ 
            return hasCycle(head.next);
        }
        return false;
    }
}