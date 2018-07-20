package 排列组合;

public class HighAndShort {
	/*
	 * 12个高矮不同的人，排成两排，每排必须是从矮到高排列，
	 * 而且第二排比对应的第一排的人高，问排列方式有多少种？
	 * 给定一个偶数n，请返回所求的排列方式个数。保证结果在int范围内。
	 * 测试样例：
	 * 1
	 * 返回：1
	 */
    public int countWays(int n) {
        // write code here
    	int sum=1;
        for(int i=0;i<n/2;i++){
        	sum=sum*(n-i);
        }

        for(int i=1;i<=n/2;i++){
        	sum/=i;
        }
        return  sum/(n/2+1);
    }
}

