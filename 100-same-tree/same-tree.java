/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       Stack<TreeNode> stack = new Stack<>();

       stack.push(p);
       stack.push(q);

       while(!stack.isEmpty()){
        TreeNode nodep = stack.pop();
        TreeNode nodeq = stack.pop();

        if(nodep == null && nodeq == null ){
            continue;
        }
        if(nodep == null || nodeq == null ){
           return false;
        }
        if(nodep.val!=nodeq.val){
            return false;
        }
        stack.push(nodep.left);
        stack.push(nodeq.left);

        stack.push(nodep.right);
        stack.push(nodeq.right);
       }
    return true;
}
}