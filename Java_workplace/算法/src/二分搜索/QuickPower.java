package 二分搜索;

public class QuickPower {
/*
 * 如果更快的求一个整数k的n次方。
 * 如果两个整数相乘并得到结果的时间复杂度为O(1)，
 * 得到整数k的N次方的过程请实现时间复杂度为O(logN)的方法。
 * 给定k和n，请返回k的n次方，为了防止溢出，
 * 请返回结果Mod 1000000007的值。
 * 
 * 测试样例：
 * 2,3
 * 返回：8
 */
	public static void main(String[] args) {
		System.out.println(getPower(2,30));

	}
    public static int getPower(int k, int N) {
    	if(N==1){
    		return k;
    	}
    	return getPower(k, N/2)*getPower(k, N-N/2);

    }
}
