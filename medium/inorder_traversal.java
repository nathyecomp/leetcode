//Complexity is O(N) as I need to acess all nodes
/*
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

FONT: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
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