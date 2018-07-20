package 动态规划;

import org.junit.Test;

public class Backpack {
	/*
	 * 一个背包有一定的承重cap，有N件物品，
	 * 每件都有自己的价值，记录在数组v中，
	 * 也都有自己的重量，记录在数组w中，
	 * 每件物品只能选择要装入背包还是不装入背包，
	 * 要求在不超过背包承重的前提下，选出物品的总价值最大。
	 * 给定物品的重量w价值v及物品数n和承重cap。
	 * 请返回最大总价值。
	 * 测试样例：
	 * [1,2,3],[1,2,3],3,6
	 * 返回：6
	 */
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[]dp=new int[cap+1];
        int[][]a=new int[n][cap+1];
        for(int i=0;i<n;i++){
            for(int j=cap;j>=w[i];j--){
               dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
               a[i][j]=dp[j];
       
        }                 
    }
//        for(int i=0;i<n;i++){
//        	for(int j=0;j<=cap;j++){
//        		System.out.print(a[i][j]+" ");
//        	}
//        	System.out.println();
//        }
      return dp[cap];  
    }
	   @Test 
	   public void test(){
		   int[] w={3,2,1};
		   int[] v={3,2,1};
		   System.out.println(maxValue(w, v, 3, 6));
	   }
}
