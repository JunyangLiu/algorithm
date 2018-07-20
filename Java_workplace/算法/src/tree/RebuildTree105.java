package tree;

import org.junit.Test;
/*
 * 重建二叉树
 */
public class RebuildTree105{
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length==0||inorder.length==0){
    		return null;
    	}
        TreeNode node=new TreeNode(preorder[0]);
        int i=0;
       while(preorder[0]!=inorder[i]){
        	i++;
        	}	
        node.left=buildTree(copyArray(preorder, 1, i), copyArray(inorder, 0, i));
        node.right=buildTree(copyArray(preorder, i+1, preorder.length-1), copyArray(inorder, i+1, inorder.length-1));
        return node;
    }
    public TreeNode buildTreeHelper(){
    	return null;
    }
    
    public int[] copyArray(int [] array,int start,int end){
    	int[]newArray=new int[end-start+1];
    	for(int i=0;start+i<=end;i++){
    		newArray[i]=array[start+i];
    	}
		return newArray;   	
    }
    /*
     * 重建二叉树优化版
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
  
    	return rebuildTree(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }
    public TreeNode rebuildTree(int preStart, int preEnd,int inStart, int inEnd, int[] preorder, int[] inorder){
    	if(preEnd<preStart||inStart>inEnd){
    		return null;
    	}
    	TreeNode root=new TreeNode(preorder[preStart]);
    	int index=0;
    	while(preorder[preStart]!=inorder[inStart+index]){
    		index++;
    	}
    	root.left=rebuildTree(preStart+1, preStart+index, inStart, inStart+index-1, preorder, inorder);
    	root.right=rebuildTree(preStart+index+1, preEnd, inStart+index+1, inEnd, preorder, inorder);
    	return root;
    }
    /*
     * 重建二叉树再优化版
     */
    private int[] mPreorder,mInorder;
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
    	mPreorder=preorder;
    	mInorder=inorder;
    	return rebuildTree1(0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode rebuildTree1(int preStart, int preEnd,int inStart, int inEnd){
    	if(preEnd<preStart||inStart>inEnd){
    		return null;
    	}
    	TreeNode root=new TreeNode(mPreorder[preStart]);
    	int index=0;
    	while(mPreorder[preStart]!=mInorder[inStart+index]){
    		index++;
    	}
    	root.left=rebuildTree1(preStart+1, preStart+index, inStart, inStart+index-1);
    	root.right=rebuildTree1(preStart+index+1, preEnd, inStart+index+1, inEnd);
    	return root;
    }
	   @Test
	   public void test(){
		   int[] preorder={1,2,4,5,3,6,7};
		   int[] inorder={4,2,5,1,6,3,7};
//		   System.out.println(preorder.length);
		   System.out.println("结果为");
		   BinaryTreeHelper.preorderPrintTree(buildTree2(preorder, inorder));
		   System.out.println();
		   BinaryTreeHelper.InorderPrintTree(buildTree2(preorder, inorder));
		   System.out.println();
		   BinaryTreeHelper.posorderPrintTree(buildTree2(preorder, inorder));
	   }
}
