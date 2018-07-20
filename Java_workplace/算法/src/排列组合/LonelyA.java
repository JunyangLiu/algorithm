package 排列组合;

import org.junit.Test;

public class LonelyA {
	/*
	 * A(A也是他的编号)是一个孤傲的人，
	 * 在一个n个人(其中编号依次为1到n)的队列中，
	 * 他于其中的标号为b和标号c的人都有矛盾，
	 * 所以他不会和他们站在相邻的位置。
	 * 现在问你满足A的要求的对列有多少种？
	 * 给定人数n和三个人的标号A,b和c，请返回所求答案，
	 * 保证人数小于等于11且大于等于3。
	 * 测试样例：
	 * 6,1,2,3
	 * 288
	 */
    public int getWays(int n, int A, int b, int c) {
       int sum=1;//sum是所有情况
       for(int i=1;i<=n;i++){
    	   sum*=i;
       }

       int all=4*sum/n-2*(sum/n/(n-1));

      int  result=sum-all;

       return result;
    }
	   @Test 
	   public void test(){
		System.out.println(getWays(4, 1,2, 3));

	   }
}
