package 剑指offer;

import string.TreeNode;

public class Solution_39 {
/*
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
    public boolean IsBalanced_Solution(TreeNode root) {
        int result=TreeDepth(root);
        return result==-1?false:true;
    }
    public int TreeDepth(TreeNode root) {
		   if(root==null)return 0;
	        int left=TreeDepth(root.left);
	        int right=TreeDepth(root.right);
	        if(left==-1||right==-1||Math.abs(left-right)>1){
	        	return -1;
	        }
	        return Math.max(left, right)+1;
	    }
}
