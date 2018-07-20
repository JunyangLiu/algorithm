package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result=new ArrayList<>();
  	if(root==null){
		return result;
	}
      List<Integer>  layer=new ArrayList<>();
      TreeNode last=root;
      TreeNode nlast=root;
      Queue<TreeNode> queue=new LinkedList<>();
      queue.offer(root);
      TreeNode current;
      while(!queue.isEmpty()){
    	  current=queue.poll();
    	  layer.add(current.val);
    	  if(current.left!=null){
    		  queue.offer(current.left);
    		  nlast=current.left;
    	  }
    	  if(current.right!=null){
    		  queue.offer(current.right);
    		  nlast=current.right;
    	  }
    	  if(nlast==current){
    		  last=nlast;
    		  result.add(layer);
    		  layer=new ArrayList<>();
    	  }
      }
      return result;
    }
}
