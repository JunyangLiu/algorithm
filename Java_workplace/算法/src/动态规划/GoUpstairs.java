package 动态规划;

import org.junit.Test;

public class GoUpstairs {
	/*
	 * 有n级台阶，一个人每次上一级或者两级
	 * ，问有多少种走完n级台阶的方法。为了防止溢出，
	 * 请将结果Mod 1000000007
	 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。
	 * 保证n小于等于100000。
	 * 测试样例：
	 * 1
	 * 返回：1
	 */
    public int countWays(int n) {
        if(n==1)return 1;
        if(n==2)return 2;
        int a=1,b=2,c=0;
        for(int i=3;i<=n;i++){
        	c=(a+b)%1000000007;
        	a=b;
        	b=c;
        }
        return c;
    }
	   @Test 
	   public void test(){
		   int[] arr={1,2,4};
		   System.out.println(countWays(36196));
	   }
}
