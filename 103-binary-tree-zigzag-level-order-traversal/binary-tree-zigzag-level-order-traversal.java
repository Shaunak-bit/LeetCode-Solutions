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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> list1 = new ArrayList<>();
        if(root == null){
            return list1;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean order = false;

        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> list2 = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode cur = q.poll();
                list2.add(cur.val);

                if(cur.left!= null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                
            }
            if(order){
                Collections.reverse(list2);
            }
            list1.add(list2);
            order=!order;
        }
        return list1;
    }
}