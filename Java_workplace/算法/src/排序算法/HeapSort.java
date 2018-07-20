package 排序算法;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HeapSort {
/*
 * 题目：小范围排序
 * 已知一个几乎有序的数组，几乎有序是指，
 * 如果把数组排好顺序的话，每个元素移动的距离可以不超过k，
 * 并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序。
  *给定一个int数组A，同时给定A的大小n和题意中的k，请返回排序后的数组。
  *测试样例：
  *[2,1,4,3,6,5,8,7,10,9],10,2
  *返回：[1,2,3,4,5,6,7,8,9,10]
 */
	  public int[] sortElement(int[] A, int n, int k) {
		  //创建小根堆
		  int[] heap=new int [k];
		  for(int i=0;i<k;i++){
		  		heap[i]=A[i];		  		
		  	}
		  build_heap(heap, k);
		  
		  for(int i=0;i<n;i++){
			     A[i]=heap[0];
			  if(i+k<n){		   
			  	   heap[0]=A[i+k];
			  	   heap_adjust(heap, 0,k);
			  }else{
				  heap[0]=heap[n-1-i];   //使小根堆有序
				  heap_adjust(heap, 0,n-1-i);
			  }
//		  		
		  	}
		  return A;
	    }
	  //建立小根堆
	  public void build_heap(int[] A,int n) {
		  
	        for( int i=n/2-1;i>=0;i--)    //非叶节点最大序号值为n/2 -1
	        {
	            heap_adjust(A,i,n);    
	        }    
	}
	  /*
	     * 小根堆调整
	     * 一次堆调整的平均时间成本为log n
	     * n为堆的元素个数
	     */
	    public void heap_adjust(int[] A,int i,int n){
	    	int leftChild=2*i+1;		//左孩子的下标
	    	int rightChild=2*i+2;    //右孩子的下标
	    	int min=i;                   	//min记录较大节点的下标
	    	if(i<n/2){                  		 //满足此条件节点才不是叶子节点
	    		if(leftChild<n&&A[leftChild]<A[min]){
	    			min=leftChild;
	    		}
	    		if(rightChild<n&&A[rightChild]<A[min]){
	    			min=rightChild;
	    		}
	    		if(i!=min){
	    			int temp=A[i];				//交换A[i]和A[max]
	    			A[i]=A[min];
	    			A[min]=temp;
	    			
	    			heap_adjust(A, min, n); //再继续调整子树
	    		}
	    	}
	    	
	    }

	  
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
  @Test
 public void test(){
	   int[] A={1 ,10, 7, 9, 5, 6, 3, 8, 2, 2};
//	   int[] A={12,8,14};
//	   BuildHeap(A, 1, 3);
   
	 System.out.println(containsDuplicate(A));
	  SortUtils.printArray(A);
 }  
}
