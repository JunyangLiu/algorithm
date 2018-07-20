package 排列组合;

public class Distribution {
	/*
	 * n颗相同的糖果，分给m个人，每人至少一颗，问有多少种分法。
	 * 给定n和m，请返回方案数，保证n小于等于12，且m小于等于n。
	 * 测试样例：
	 * 10,3
	 * 返回：36
	 * 思路 相当于n-1里面取吗m-1个数
	 */
    public int getWays(int n, int m) {
    	
    	int sum=1;
        for(int i=0;i<m-1;i++){
        	sum=sum*(n-1-i);
        }

        for(int i=1;i<=m-1;i++){
        	sum/=i;
        }
        return  sum;
    }
}
