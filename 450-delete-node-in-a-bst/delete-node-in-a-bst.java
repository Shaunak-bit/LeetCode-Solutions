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
    public TreeNode deleteNode(TreeNode root, int key) {
    Queue<Integer> q = new LinkedList<>();

    root = search(root, key, q);

     while(!q.isEmpty()){
        int rem = q.poll();
        root = insert(root,rem);
     }
     return root;
    }private TreeNode search(TreeNode root,int key,Queue<Integer>q){
        if(root == null){
            return null;
        }
        if(root.val>key){
            root.left = search(root.left,key,q);
        }else if(root.val<key){
            root.right = search(root.right,key,q);
        }else{
            store(root.left,q);
            store(root.right,q);
            return null;
        }
        return root;
    }private void store(TreeNode subtree,Queue<Integer>q){
        if(subtree == null){
            return ;
        }
        q.add(subtree.val);
        store(subtree.left,q);
        store(subtree.right,q);

    }private TreeNode insert(TreeNode root,int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val<root.val){
            root.left = insert(root.left,val);
        }else {
            root.right = insert(root.right, val);
        }
        return root;
    }
}