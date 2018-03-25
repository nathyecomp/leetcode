//Complexity is O(N) as I need to acess all nodes
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
    List<Integer> result;
    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();
        inorderRead(root);
        return result;
    }
    public void inorderRead(TreeNode tree){
        if(tree == null) return;
        if(tree.left!=null) inorderRead (tree.left);

        result.add(tree.val);
        inorderRead(tree.right);
        return;
    }

}