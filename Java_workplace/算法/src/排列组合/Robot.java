package 排列组合;

import org.junit.Test;

/*
 * 在XxY的方格中，以左上角格子为起点，
 * 右下角格子为终点，每次只能向下走或者向右走，
 * 请问一共有多少种不同的走法
 * 给定两个正整数int x,int y，请返回走法数目。保证x＋y小于等于12。
 * 测试样例：
 * 2,2
 * 返回：2
 * s思路：
 * 相当于 x+y 里面取x 个数
 */
public class Robot {
    public int countWays(int x, int y) {
    	x--;y--;
    	int xsum=1;//xsum保存x的阶乘
        for(int i=0;i<x;i++){
        	xsum=xsum*(x-i);
        }
        int ysum=1;
        for(int i=0;i<x;i++){
        	ysum=ysum*(y+x-i);
        }
        return  ysum/xsum;
    }
	   @Test 
	   public void test(){
		System.out.println(countWays(2, 3));

	   }
}
