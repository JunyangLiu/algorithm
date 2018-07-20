package 排序算法;

import org.junit.Test;

public class Others {
	/*
	对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。
	给定一个int数组A和数组的大小n，请返回一个二元组，
	代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。
	保证A中元素均为正整数。
	测试样例：[1,4,6,5,9,10],6
	返回：2
	*/
	//思路：记录当前的最大值max，以及max大于右边元素最右的位置right
	//             记录当前的最小值min，以及min小于右边元素最左的位置left
	//             right-left+1就是结果
    public int shortestSubsequence(int[] A, int n) {
    	int max=A[0];
    	int min=A[n-1];
    	int right=0;
    	int left=0;
    	for(int i=1;i<n;i++){
    		if(max>A[i]){
    			right=i;
    		}else{
    			max=A[i];
    		}
    	}
    	for(int i=n-2;i>=0;i--){
    		if(min<A[i]){
    			left=i;
    		}else{
    			min=A[i];
    		}
    	}
    	if(right==left){//此时left和right都为0，即整个数组有序
    		return 0;
    	}else{
    	  	return right-left+1;
    	} 
    }
    /*
     * 题目：相邻两数最大差值
    有一个整形数组A，请设计一个复杂度为O(n)的算法，
    算出排序后相邻两数的最大差值。
    给定一个int数组A和A的大小n，请返回最大的差值。
    保证数组元素多于1个。
    测试样例：
    [1,2,5,4,6],5
    返回：2 
    */
    public int maxGap(int[] A, int n) {
    	int min=A[0];
    	int max=A[0];
        for(int i=0;i<n;i++){
        	if(A[i]>max){
        		max=A[i];
        	}
        	if(A[i]<min){
        		min=A[i];
        	}
        }
        int[][] bucket=new int[n+1][n];
        int[]  count=new int[n+1];
        double gap=(max-min)*1.0/n;
        for(int i=0;i<n;i++){
        	int num=(int) ((A[i]-min)/gap);
        	bucket[num][count[num]++]=A[i];
        }
  	  SortUtils.printArray(count);
        int left=0,right=n;
        for(int i=1,j=n;i<n+1;i++){
        	if(count[i]==0&&count[i-1]!=0){
        		left=i-1;
        	}
        	if(count[j-i]==0&&count[j-i+1]!=0){
        		right=j-i+1;
        	}

        }
    	System.out.println(left+"  "+right);
        min=bucket[left][0];
        for(int i=1;i<count[left];i++){

        	if(bucket[left][i]<min){
        		min=bucket[left][i];
        	}
        }
        max=bucket[right][0];
        for(int i=1;i<count[right];i++){

        	if(bucket[right][i]<max){
        		max=bucket[right][i];
        	}
        }
        return max-min;
    }
    @Test
    public void test(){
    	   int[] A={3429,6401,8559,1052,4775,6220,3593,2406,4995};
//    	   int[] A={12,8,14};
//    	   BuildHeap(A, 1, 3);
    	System.out.println(maxGap(A, 9));

    }  
}
