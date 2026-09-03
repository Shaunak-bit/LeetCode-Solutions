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
    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> set = new TreeSet<>();
        helper(root,set);
        if(set.size()<2){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        return list.get(1);
        
    }public void helper(TreeNode root,TreeSet<Integer>set){
        if(root == null){
            return;
        }
        helper(root.left,set);
        set.add(root.val);
        helper(root.right,set);
    }
}