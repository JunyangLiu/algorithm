package 排列组合;

public class Stack {
	/*
	 * n个数进出栈的顺序有多少种？假设栈的容量无限大。
	 * 给定一个整数n，请返回所求的进出栈顺序个数。保证结果在int范围内。
	 * 测试样例：
	 * 1
	 * 返回：1
	 * 思路：n取 n/2 再除以 n/2-1
	 */
    public int countWays(int n) {
        // write code here
    	int sum=1;
        for(int i=0;i<n;i++){
        	sum=sum*(2*n-i);
        }

        for(int i=1;i<=n;i++){
        	sum/=i;
        }
        return  sum/(n+1);
    }
}
