package string;

import java.util.ArrayList;

import org.junit.Test;

public class KMP {
	  /*
	   *
	   * 如果对于一个字符串A，将A的前面任意一部分挪到后边去
	   * 形成的字符串称为A的旋转词。
	   * 比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。
	   * 对于两个字符串A和B，请判断A和B是否互为旋转词。
	   * 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，
	   * 代表他们是否互为旋转词。
	   * 测试样例：
	   * "cdab",4,"abcd",4
	   * 返回：true  
	   */
	    
	    public boolean chkRotation(String A, int lena, String B, int lenb) {
	        if(lena!=lenb){
	        	return false;
	        }
	        char[] a=A.toCharArray();
	        char[] b=B.toCharArray();
	        char[] c=new char[a.length+b.length];
	        for(int i=0;i<a.length;i++){
	        	c[i]=a[i];
	        }
	        for(int j=0,k=a.length;j<a.length;j++,k++){
	        	c[k]=a[j];
	        }
	        int[] next=new int[lena];
	        
	        getNextArray(b, next);
	        for(int i=0;i<next.length;i++){
	        	System.out.print(next[i]+" ");
	        }
	        return kmpSearch(c, b, next);
	    }
	   public boolean kmpSearch(char[] s,char[] p,int[] next){
		   int i=0,j=0;
		   while(i<s.length&&j<p.length){
			   if(j==-1||s[i]==p[j]){
				   j++;
				   i++;
			   }else{
				   j=next[j];
			   }
		   }
		   if(j==p.length){
			   return true;
		   }else{
			   return false;
		   }
	   }
	   public void getNextArray(char[] p,int[] next){
		   int k=-1;
		   int i=0;
		   next[0]=-1;
		   while(i<p.length-1){
			   if(k==-1||p[k]==p[i]){
				   i++;
				   k++;
				   if(p[i]!=p[k]){
					   next[i]=k;
				   }else{
					   next[i]=next[k];
				   }
			   }else{
				   k=next[k];
			   }
		   }
	   } 
/*
 * 对于两棵彼此独立的二叉树A和B，
 * 请编写一个高效算法，
 * 检查A中是否存在一棵子树与B树的拓扑结构完全相同。
 * 给定两棵二叉树的头结点A和B，
 * 请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 */
	   
	    public boolean chkIdentical(TreeNode A, TreeNode B) {
	        // write code here
	    	StringBuilder a=new StringBuilder();
	    	StringBuilder b=new StringBuilder();
	    	
	    	getTreeString(A, a);
	    	getTreeString(B,b);
	    	int[] next=new int[b.length()];
	    	getNextArray(b.toString().toCharArray(), next);
	    	return kmpSearch(a.toString().toCharArray(), b.toString().toCharArray(), next);
	    }
	    
	    public void getTreeString(TreeNode node,StringBuilder s){
	    	if(node==null){
	    		s.append("#");
	    		return;
	    	}
	    	s.append(node.val+"!");
	    	getTreeString(node.left, s);	    	
	    	getTreeString(node.right, s);
	    	
	    }
		
	    @Test
	    public void test(){
	    Integer[] a={1,2,3,4,5,6,7};
	    Integer[] b={1};
	    TreeNode A=BinaryTreeHelper.arrayToBinaryTree(a, 0);
	    TreeNode B=BinaryTreeHelper.arrayToBinaryTree(b, 0);
	    System.out.println(chkIdentical(A, B));
	 } 
}
