package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_29 {
	/*
	 * 输入n个整数，找出其中最小的K个数。
	 * 例如输入4,5,1,6,2,7,3,8这8个数字，
	 * 则最小的4个数字是1,2,3,4,。
	 */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> result=new ArrayList<>();
    	if(input==null||input.length==0||k>input.length||k<=0){
    		return result;
    	}
    	//把数组的前K个数组成最大堆
    	for(int i=k/2-1;i>=0;i--){
    		heap_adjust(input, i, k);
    	}
    	//如果新元素比堆顶小那么久放入堆进行调整
    	for(int i=k;i<input.length;i++){
    		if(input[i]<input[0]){
    			int temp=input[i];
    			input[i]=input[0];
    			input[0]=temp;
    			heap_adjust(input, 0, k);
    		}
    	}
    	Arrays.sort(input,0,k-1);
    	for(int i=k-1;i>=0;i--){
    		result.add(input[i]);
    	}
    	return result;
    }
	
	//堆调整，最大堆,从A[i]开始调整
	   public void heap_adjust(int[] A,int i,int n){
		   int left=i*2+1;
		   int right=i*2+2;
		   int max=i;//记录较大节点的位置
		   if(i<n/2){
			   if(left<n&&A[left]>A[max]){
				   max=left;
			   }
			   if(right<n&&A[right]>A[max]){
				   max=right;
			   }
			   if(max!=i){
				   int temp= A[i];
				   A[i]=A[max];
				   A[max]=temp;
				   heap_adjust(A, max, n);
			   } 
		   }

	   }
}
