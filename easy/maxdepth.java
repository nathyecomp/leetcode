/*
Problem description:
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

-------------------
Complexity Analisys: 
Worst case: O(n)
Best case: O(n)

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return searchHighest(root, 0);
    }
    
    public int searchHighest(TreeNode root, int size){
        if(root == null){
            return size;
        }
        int left_size = searchHighest(root.left, size+1);
        int right_size = searchHighest(root.right, size+1);
        
        if(left_size > right_size) return left_size;
        return right_size;
    }
}