package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class Solution_60 {
	/*
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
	 */
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        if(pRoot==null){
        	return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(pRoot);
        TreeNode last=pRoot,nlast=pRoot.left,current;
        while(!queue.isEmpty()){
        	current=queue.poll();
        	list.add(current.val);
        	if(current.left!=null){
        		queue.offer(current.left);
        		nlast=current.left;
        	}
        	if(current.right!=null){
        		queue.offer(current.right);
        		nlast=current.right;
        	}
        	if(current==last){
        		result.add(list);
        		last=nlast;
        		list=new ArrayList<>();
        	}
        	
        }
        return result;
    }
}
