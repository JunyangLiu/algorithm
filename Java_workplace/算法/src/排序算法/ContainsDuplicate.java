package 排序算法;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	/*
	 * 题目 重复值判断练习题
	 * 请设计一个高效算法，判断数组中是否有重复值。【必须保证额外空间复杂度为O(1)】。
	 * 给定一个int数组A及它的大小n，请返回它是否有重复值。
	 * LeetCode 217 Contains Duplicate
	 */
		  //牛客版
		    public boolean checkDuplicate(int[] a, int n) {
		    	for(int i=n-1;i>=0;i--){
		    		heap_sort(a, n--);
		    		 int temp=a[i];
	   			     a[i]=a[0];
	   			     a[0]=temp;
		    	}
		    	int num=a[0];
		    	for(int i=1;i<a.length;i++){
		    		if(a[i]==num){
		    			return true;
		    		}else{
		    			num=a[i];
		    		}
		    	}
		    	return false;
		    }
		    //非递归的堆调整
		    public void heap_sort(int[] A,int n){
		    	int leftChild;
		    	int rightChild;
		    	int max;
		    	int i;
		    	for(int j=n/2-1;j>=0;j--){
		    		i=j;    		
		    		while(i<n/2){
		    			max=i;
				    	leftChild=i*2+1;
				    	rightChild=i*2+2;
			    		if(leftChild<n&&A[leftChild]>A[max]){
			    			max=leftChild;
			    		}
			    		if(rightChild<n&&A[rightChild]>A[max]){
			    			max=rightChild;
			    		}
			    		if(max!=i){
			    			 int temp=A[max];
			   			     A[max]=A[i];
			   			     A[i]=temp;		   			     
			   			     i=max;
			    		}else{
			    			break;
			    		}
			    	}
		    	}	    	
		    }
		    

	/*
	 * 题目 217. Contains Duplicate
	 * Given an array of integers, find if the array contains any duplicates. 
	 * Your function should return true if any value appears at least twice in the array,
	 *  and it should return false if every element is distinct.	
	 *  对额外空间没有要求    
	 */
		    public boolean containsDuplicate(int[] nums) {
		    	 final Set<Integer> distinct = new HashSet<Integer>();
		    	    for(int num : nums) {
		    	        if(distinct.contains(num)) {
		    	            return true;
		    	        }
		    	        distinct.add(num);
		    	    }
		    	    return false;
		    }	    
/*
 *  题目 219. Contains Duplicate II
 *  Given an array of integers and an integer k,
 *   find out whether there are two distinct indices i and j in the array 
 *   such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
		    public boolean containsNearbyDuplicate(int[] nums, int k) {
		        
		    	return false;
		    }
/*
 * 220. Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct indices i and j
 *  in the array such that the absolute difference between nums[i] and nums[j] 
 *  is at most t and the absolute difference between i and j is at most k.		    
 */
		    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		        return false;
		    }
}
