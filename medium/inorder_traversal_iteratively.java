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
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null){
            if(root.left == null){
                result.add(root.val);
                if(root.right!=null){
                    root = root.right;
                }
                else{
                    if(stack.empty()) break;
                    do{
                        root = stack.pop();
                        result.add(root.val);
                        root = root.right;
                    }while(root==null && !stack.empty());
                }
                
            }
            else{
                stack.push(root);
                root = root.left;
            }
        }
        return result;
    }
   
}