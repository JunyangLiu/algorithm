package tree;

import org.junit.Test;

public class NK_LongestDistance {
    public int findLongest(TreeNode root) {
       int[] result= find(root);
       return result[1];
    }

   /* 
    *     result数组保存两个信息：
    *     result[0]距离根节点的最大距离
    *     result[1]以该节点为子树的最远距离
    * 
    */
    public int[] find(TreeNode root){
    	int[] result=new int[2];
    	if(root==null){
    		return result;
    	}
    	int[] left=find(root.left);
    	int[] right=find(root.right);
    	result[0]=Math.max(left[0], right[0])+1;
    	result[1]=Math.max(Math.max(left[1], right[1]), left[0]+right[0]+1);
    	System.out.println("node="+root.val+"  "+result[0]+"  "+result[1]);
    	return result;
    }
    @Test
	   public void test(){
		   Integer[] array={3,2,5,1,null,4,null,null,null,null,null};
	
		   TreeNode root=BinaryTreeHelper.arrayToBinaryTree(array, null);
		  System.out.println(findLongest(root));
	   }   
}
