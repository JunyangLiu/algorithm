package 剑指offer;

public class Solution_30 {
	/*
	 * 连续子数组的最大和
	 */
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp=new int[array.length];
        dp[0]=array[0];
        for(int i=1;i<array.length;i++){
        	if(dp[i-1]<0){
        		dp[i]=array[i];
        	}else{
        		dp[i]=dp[i-1]+array[i];
        	}
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<dp.length;i++){
        	if(dp[i]>result){
        		result=dp[i];
        	}
        }
        return result;
    }
}
