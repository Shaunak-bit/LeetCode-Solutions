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
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        Queue<Integer> q = new LinkedList<>();
        
        // 1. Find the node to delete and collect its subtrees into the queue
        root = findAndStore(root, key, q);
        
        // 2. Re-insert all collected elements from the queue back into the BST
        while (!q.isEmpty()) {
            int valToInsert = q.poll();
            root = insertIntoBST(root, valToInsert);
        }
        
        return root;
    }

    // Helper function to find the key, pull its subtree data, and bypass it
    private TreeNode findAndStore(TreeNode root, int key, Queue<Integer> q) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = findAndStore(root.left, key, q);
        } else if (key > root.val) {
            root.right = findAndStore(root.right, key, q);
        } else {
            // Target key node found! Collect all elements from its subtrees
            store(root.left, q);
            store(root.right, q);
            
            // Bypass this node by returning null to its parent
            return null; 
        }
        return root;
    }

    // Your requested function to store subtree elements into the queue
    public void store(TreeNode subTreeRoot, Queue<Integer> q) {
        if (subTreeRoot == null) {
            return;
        }
        
        q.add(subTreeRoot.val);      // Process Root
        store(subTreeRoot.left, q);  // Process Left
        store(subTreeRoot.right, q); // Process Right
    }

    // Standard BST helper function to insert values back into the tree
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
