package tree;

import org.junit.Test;

public class LowestCommonAncestor235_236 {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (root==null||root==p||root==q) {
			return root;
		}
	
		TreeNode lChild=lowestCommonAncestor(root.left, p, q);
		TreeNode rChild=lowestCommonAncestor(root.right, p, q);
		//关键：P，和q一定分别在最近公共祖先的左右子树上
		if((root.right==rChild&&root.left==lChild)||(root.right==lChild&&root.left==rChild)) {
			return root;
		}
		//如果节点不为空也不为p，q那么是之前找到的公共祖先
		if (lChild!=null&&lChild!=p&&lChild!=q) {
			return lChild;
		}//同上
		if (rChild!=null&&rChild!=p&&rChild!=q) {
			return rChild;
		}
		
		if(lChild!=null&&rChild==null){
			return lChild;
		}else if(lChild==null&&rChild!=null){
			return rChild;
		}else{
					return null;
				}

	}
	@Test
	public void test(){
		Integer[] array={4,3,7,null,null,5,6};
		TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
	
	
	}

}
