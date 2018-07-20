package 动态规划;

import org.junit.Test;

public class Exchange {
/*
 * 有数组penny，penny中所有的值都为正数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，
 * 再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
 * 给定数组penny及它的大小(小于等于50)，
 * 同时给定一个整数aim，请返回有多少种方法可以凑成aim。
 * 测试样例：
 * [1,2,4],3,3
 * 返回：2
 */
    public int countWays(int[] penny, int n, int aim) {
//    	return violence(penny, 0, aim);
    	int[][]map=new int[n+1][aim+1];
    	return violence(penny, 0, aim, map);
    }
    //暴力求解法
    public int violence(int[] penny, int start, int aim){
    	int res=0;
    	if(start==penny.length){
    		res=aim==0?1:0;
    	}else{
        	for(int i=0;i*penny[start]<=aim;i++){
        		res+=violence(penny, start+1, aim-i*penny[start]);
        	}
    	}
    	return res;
    } 
    
    //记忆搜索法
    public int violence(int[] penny, int start, int aim,int[][] map){
    	int res=0;
    	if(start==penny.length){
    		res=aim==0?1:0;
    	}else{
        	for(int i=0;i*penny[start]<=aim;i++){
        		int value=map[start+1][aim-i*penny[start]];
        		if(value==0){
        			res+=violence(penny, start+1, aim-i*penny[start],map);
        		}else{
        			res+=value;
        		}
        	}
    	}
    	map[start][aim]=res;
    	return res;
    }
    //动态规划法
    public int dynamic(int[] penny, int n, int aim){
        int[] dp = new int[aim+1];
        for(int i = 0;i <= aim;i++)
            if(i % penny[0] == 0)
                dp[i] = 1;
             
        for(int i = 1;i<n; i++)
            for(int j = 1;j<=aim;j++)
                if(j>=penny[i])
                    dp[j] += dp[j-penny[i]];
        //相当于dp[i][j]=dp[i-1][j]+dp[i][j-penny[i]]
         
        return dp[aim];
    }
	   @Test 
	   public void test(){
		   int[] arr={1,2,4};
		   System.out.println(countWays(arr, 3, 3));
	   }
}
