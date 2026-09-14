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
    public int findBottomLeftValue(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       TreeNode cur = null;
        while(!q.isEmpty()){
          cur = q.poll();
            if(cur.right!=null){
                q.offer(cur.right);
            }
             if(cur.left!=null){
                q.offer(cur.left);
            }
        }
        return cur.val;
    }
}