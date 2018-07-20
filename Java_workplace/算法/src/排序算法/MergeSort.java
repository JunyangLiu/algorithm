package 排序算法;

import org.junit.Test;

public class MergeSort {
	/*题目：合并有序数组AB
	 * 有两个从小到大排序以后的数组A和B，
	 * 其中A的末端有足够的缓冲空容纳B。
	 * 请编写一个方法，将B合并入A并排序。
	 * 给定两个有序int数组A和B，A中的缓冲空用0填充，
	 *同时给定A和B的真实大小int n和int m，请返回合并后的数组。
	 */
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int indexA=n-1;
        int indexB=m-1;
        int indexC=A.length-1;
        while(indexA>=0&indexB>=0){
        	if(A[indexA]>B[indexB]){
        		A[indexC]=A[indexA];
        		indexA--;
        	}else{
        		A[indexC]=B[indexB];
        		indexB--;
        	}
        	indexC--;
        }
        while(indexA>=0){
        	for(;indexA>=0;indexA--){
        		A[indexC]=A[indexA];
        		indexC--;
        	}
        }
        while(indexB>=0){
        	for(;indexB>=0;indexB--){
        		A[indexC]=B[indexB];
        				indexC--;
        	}
        }
        
        return A;	
    }
    
    /*题目 三色排序
     * 有一个只由0，1，2三种元素构成的整数数组，
     * 请使用交换、原地排序而不是使用计数进行排序。
    * 给定一个只含0，1，2的整数数组A及它的大小，
     * 请返回排序后的数组。保证数组大小小于等于500。
     * leetcode 75
     */
    public int[] sortThreeColor(int[] A, int n) {
    	int index0=0;
    	int index2=A.length-1;
        for(int i=0;i<=index2;i++){
         	System.out.println("i="+i);
        	if(A[i]<1){
        		swap(A,i,index0++);       		
        	}
        	if(A[i]>1){
        		swap(A,i, index2--);
        		i--;     //i--的原因是交换过来的数还得重新判断一下
        	}		     //因为有可能交换过来的数也大于1		
        			  //小于1 的则不需要，因为交换的元素是已经判断过的
   
      	  SortUtils.printArray(A);
        }
        return A;
    }
    public void swap(int[] A,int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



@Test
public void test(){
	   int[] A={1,2,0,2};
//	   int[] A={12,8,14};
//	   BuildHeap(A, 1, 3);
	 A=sortThreeColor(A, 4);
	  SortUtils.printArray(A);
}  
}
