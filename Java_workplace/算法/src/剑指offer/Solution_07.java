package 剑指offer;

public class Solution_07 {
	/*
	 * 大家都知道斐波那契数列，
	 * 现在要求输入一个整数n，
	 * 请你输出斐波那契数列的第n项。
	 * 指的是这样一个数列：1、1、2、3、5、8、13、21、34、
	 * n<=39
	 */
    public int Fibonacci(int n) {
    	if(n==0){
    		return 0;
    	}
    	if(n<=2){
    		return 1;
    	}
    	int a=1,b=1,c=0;    
    	for(int i=3;i<=n;i++){
    		c=a+b;
    		a=b;
    		b=c;
    	}
    	return c;
    }	
}
