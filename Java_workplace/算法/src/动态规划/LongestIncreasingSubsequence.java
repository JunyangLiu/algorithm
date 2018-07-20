package 动态规划;

import org.junit.Test;

public class LongestIncreasingSubsequence {
	/*
	 * 这是一个经典的LIS(即最长上升子序列)问题，
	 * 请设计一个尽量优的解法求出序列的最长上升子序列的长度。
	 * 给定一个序列A及它的长度n(长度小于等于500)，请返回LIS的长度。
	 * 测试样例：
	 * [1,4,2,5,3],5
	 * 返回：3
	 */
    public int getLIS(int[] A, int n) {
      int[] dp=new int[n];
      dp[0]=1;
      for(int i=1;i<n;i++){
    	  int max=0;
    	  for(int j=i-1;j>=0;j--){
    		  if(A[j]<A[i]&&dp[j]>max){ 			  
    				  max=dp[j]; 			  
    		  }
        	  dp[i]=max+1;
    	  }
      }
      int result=0;
      for(int i=0;i<n;i++){
    	  if(dp[i]>result){
    		  result=dp[i];
    	  }
      }
      return result;
    }
	   @Test 
	   public void test(){
		   int[] arr={1,4,2,5,3};
		   System.out.println(getLIS(arr, 5));
	   }
}
