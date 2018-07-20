package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class NK_LevelOrderPrintTree {
/*
 * 题目：
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，
 * 结果按照每一层一个数组进行储存，
 * 所有数组的顺序按照层数从上往下，
 * 且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * 思路：
 * 巧妙利用队列结构
 * 定义两个节点指针
 * last 当前行的最右节点
 * nlast 每次遍历下一行的最右节点
 * 当nlast==last的时候说明该换行了
 * 
 */
	  public int[][] printTree(TreeNode root) {
	        if(root==null){
	            return null;
	        }
	        
	        Queue<TreeNode> queue=new LinkedList<>();
	        //保存单行二叉树节点
	        ArrayList<Integer> list=new ArrayList<>();	     
	        //保存每一行二叉树节点
	        ArrayList<ArrayList<Integer>> layer=new ArrayList<>();
	        
	        TreeNode last=root;//当前行的最右节点
	        TreeNode nlast=root.left;//下一行的最右节点
	        TreeNode current=root;
	        queue.offer(root);
	  
	        
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
	        	//换层
	        	if(last==current){
	        		last=nlast;
	        		layer.add(list);
	        		list=new ArrayList<>();	        	
	        	}
	        }
	        //把结果转化为返回数组
	        int[][] res=new int[layer.size()][];
	        for(int i=0;i<layer.size();i++){
	        	res[i]=new int[layer.get(i).size()];
	        	for(int j=0;j<res[i].length;j++){
	        		res[i][j]=layer.get(i).get(j);
	        	}
	        }
    	       return res;
	    }
	   @Test
	   public void test(){
		   Integer[] array={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	
		   TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
		   int[][] res= printTree(root);
		   if(res==null){
			   System.out.println("res is null");
		   }
		   for (int[] is : res) {
			for(int i:is){
				System.out.print(i+" ");
			}
		}
	   }   
}
