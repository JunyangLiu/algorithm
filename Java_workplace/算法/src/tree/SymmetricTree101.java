package tree;

import org.junit.Test;

public class SymmetricTree101 {
	   public boolean isSymmetric(TreeNode root) {
	        if(root==null){
	        	return true;
	        }else {
	        	return isSameTree(root.left, root.right);
	        }
	        
	    }
	   public boolean isSameTree(TreeNode p, TreeNode q) {
	        if(p==null&&q==null){
	        	return true;
	        }else  if(p!=null&&q!=null&&p.val==q.val){
	        	return isSameTree(p.left, q.right)&&isSameTree(p.right, q.left);
	        }else {
				return false;
	        }
	    } 

}
