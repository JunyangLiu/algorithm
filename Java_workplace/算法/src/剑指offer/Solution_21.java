package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.TreeNode;

public class Solution_21 {
/*
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> list=new ArrayList<>();
    	if(root==null){
    		return list;
    	}

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode current;
        while(!queue.isEmpty()){
        	current=queue.poll();
        	list.add(current.val);
        	if(current.left!=null){
        		queue.offer(current.left);
        	}
        	if(current.right!=null){
        		queue.offer(current.right);
        	}
    }
        return  list;
}
}
