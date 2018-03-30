/**
 * Eu tinha interpretado a questao errada..como o pai de menor valor =/ Ajustei a solucao e funciona, mas precisa ser revistada, 
 *visto que foi criada pra interpretacao anterior.. 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getLowestDad(root,p,q);
    }
    
    boolean goahead = false;
    public TreeNode getLowestDad(TreeNode root, TreeNode p, TreeNode q){  
        if(root==null) return null;
        else{            
            TreeNode l = getLowestDad(root.left,p,q);   
            if(goahead && l!=null){
                return l;
            }
            TreeNode r = getLowestDad(root.right,p,q);
            if(goahead && r!=null){
                return r;
            }
            if((l==p||l==q) &&(r==p||r==q)){
                goahead = true;
                return root;
            }
            if((l==p||l==q) &&(root==p||root==q)){
                goahead = true;
                return root;
            }
            if((r==p||r==q) &&(root==p||root==q)){
                goahead = true;
                return root;
            }
            if((l==p||l==q) && r==null){
                return  l;
            }
            if((r==q||r==p) && l==null){
                return  r;
            }
            if(root==p||root==q){
                return root;
            }
        }
        return null;
    }

}