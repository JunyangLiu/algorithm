package 剑指offer;

import tree.TreeNode;

public class Solution_17 {
	/*
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。
	 */
    public void Mirror(TreeNode root) {
        mirror(root);
    }
    public TreeNode mirror(TreeNode root){
    	if(root==null){
    		return null;
    	}
    	TreeNode right=root.right;
    	root.right=mirror(root.left);
    	root.left=mirror(right);
    	return root;
    }
}
