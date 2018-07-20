package 剑指offer;

import org.junit.Test;

public class Solution_22 {
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence==null||sequence.length==0){
    		return false;
    	}
        return verify(sequence, 0, sequence.length-1);
    }
    public boolean verify(int[] sequence,int start,int end){
    	System.out.println("进入程序"+start+"  "+end);
    	if(start>=end){
    		return true;
    	}
    	int root=sequence[end];
    	//寻找左子树的边界
    	int i=start;
    	for(;i<end;i++){
    		System.out.println("i~"+i);
    		if(sequence[i]>root){
    			break;
    		}
    	}
    	System.out.println("for后i="+i);
    	//寻找右子树有没有小于根节点的节点
    	int j=i+1;
    	for(;j<end;j++){
    		if(sequence[j]<root){
    			return false;
    		}
    	}
    	
    	boolean left=true;
    	System.out.println("进入if之前i="+i);
    	if(i>0){
    		System.out.println(start+"  "+(i-1));
    		left=verify(sequence, start, i-1);
    	}
    	boolean right=verify(sequence, i, end-1);
		return left&&right; 	
    }
    @Test
    public void test(){
    	int[] sequence={7,4,6,5};
    	System.out.println(VerifySquenceOfBST(sequence));
    }
}
