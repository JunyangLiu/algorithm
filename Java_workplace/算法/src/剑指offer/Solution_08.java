package 剑指offer;

public class Solution_08 {
/*
 * 一只青蛙一次可以跳上1级台阶，
 * 也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
    public int JumpFloorII(int target) {
    	if(target<=2){
    		return target;
    	}
        int[]dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=target;i++){
        	for(int j=i-1;j>0;j--){
        		dp[i]+=dp[j];
        	}   
        	dp[i]++;
    }
        return dp[target];
}
}    
