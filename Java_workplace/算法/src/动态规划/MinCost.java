package 动态规划;

import org.junit.Test;

public class MinCost {
	/*
	 * 对于两个字符串A和B，我们需要进行插入、删除和修改
	 * 操作将A串变为B串，定                        c0，    c1，   c2
	 * 分别为三种操作的代价，
	 * 请设计一个高效算法，求出将A串变为B串所需要的最少代价。
	 * 给定两个字符串A和B，及它们的长度和三种操作代价，
	 * 请返回将A串变为B串所需要的最小代价。保证两串长度均小于等于300，
	 * 且三种代价值均小于等于100。
	 * 测试样例：
	 * "abc",3,"adc",3,5,3,100
	 * 返回：8
	 */
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
    	char[] a=A.toCharArray();
    	char[] b=B.toCharArray();
        int[][]dp=new int[n+1][m+1];
        for(int i=0;i<n;i++){
        	if(a[i]!=' '){
        		dp[i+1][0]=c1+dp[i][0];
        	}
        }
       for(int i=0;i<m;i++){
       	if(b[i]!=' '){
    		dp[0][i+1]=c0+dp[0][i];
    	}
        }
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){
        	   if(a[i-1]==b[j-1]){
        		   dp[i][j]=dp[i-1][j-1];
        	   }else{
        		   dp[i][j]=Math.min(Math.min(dp[i-1][j]+c1, dp[i][j-1]+c0), dp[i-1][j-1]+c2);
        		   
        	   }
           }
       }
       return dp[n][m];
    }
	   @Test 
	   public void test(){
		   int[] arr={1,4,2,5,3};
		   System.out.println(findMinCost("abc", 3, "abc", 3, 5, 5, 5));
	   }
}
