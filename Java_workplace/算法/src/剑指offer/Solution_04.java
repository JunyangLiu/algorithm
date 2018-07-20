package 剑指offer;

import tree.TreeNode;
/*
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution_04 {
	int[] preOrder;
	int[] inOrder;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    	preOrder=pre;
    	inOrder=in;
    	return rebuild(0, preOrder.length-1, 0, inOrder.length-1);
    }
    public TreeNode rebuild(int preStart,int preEnd,int inStart,int intEnd) {
    	if(preStart>preEnd||inStart>intEnd){
    		return null;
    	}
        //寻找头结点在中序遍历的位置
    	TreeNode node=new TreeNode(preOrder[preStart]);
    	int index=0;
        for(int i=0;i<=intEnd-inStart;i++){
        	if(preOrder[preStart]==inOrder[i+inStart]){
        		index=i;
        	}
        }
        node.left=rebuild(preStart+1,preStart+index, inStart, inStart+index-1);
        node.right=rebuild(preStart+index+1, preEnd, inStart+index+1, intEnd);
        
        		
		return node;
	}
//    public int[] copy(int [] arr,int start,int end) {
//    	int[] newArr=new int[end-start+1];
//    	for(int i=0;i<newArr.length;i++){
//    		newArr[i]=arr[start+i];
//    	}
//    	return newArr;
//    }
}
