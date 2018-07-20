package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import tree.TreeNode;

public class Solution_59 {
	/*
	 * 请实现一个函数按照之字形打印二叉树，
	 * 即第一行按照从左到右的顺序打印，
	 * 第二层按照从右至左的顺序打印，
	 * 第三行按照从左到右的顺序打印，其他行以此类推。
	 */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	
    		Queue<TreeNode> queue=new LinkedList<>();
    		ArrayList<ArrayList<Integer>>result=new ArrayList<>();
    		if(pRoot==null){
    			return result;
    		}
    		ArrayList<Integer> list=new ArrayList<>();
    		int level=1;
    		TreeNode last=pRoot,nlast=pRoot.left,current;
    		queue.offer(pRoot);
    		while(!queue.isEmpty()){
    			current=queue.poll();
    			list.add(current.val);
    			if(current.left!=null){
	        		nlast=current.left;
	        		queue.offer(current.left);	   
	        	}
	        	
	        	if (current.right!=null) {
	        		nlast=current.right;
					queue.offer(current.right);
				}
	        	if(last==current){
	        		last=nlast;
	        		if(level%2==0){
	        			list=reverse(list);
	        		}
	        		level++;
	        		result.add(list);
	        		list=new ArrayList<>();
	        	}
    		}
    		return result;
    }
private ArrayList<Integer> reverse(ArrayList<Integer> layerList) {
		int length = layerList.size();
    	ArrayList<Integer> reverseList = new ArrayList<Integer>();
    	for(int i = length-1; i >= 0;i--){
    	reverseList.add(layerList.get(i));
    	}
    	return reverseList;
    	}
}
