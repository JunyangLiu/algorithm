package 剑指offer;

import org.junit.Test;

public class Solution_10 {
/*
 * 输入一个整数，
 * 输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 */
	//常规解法
    public int NumberOf1(int n) {
    	int flag=1;
    	int count=0;
    	while(flag!=0){
    		if((flag&n)==flag){
    			count++;
    		}
    		flag=flag<<1;
    	}
    	return count;
    }
    //把一个数减一再与本身按位与可以使末尾的1变为0；
    public int NumberOf1_2(int n) {
    	int count=0;
    	while(n!=0){
    			count++;
    			n=(n-1)&n;
    	}
    	return count;
    }
    @Test 
	   public void test(){
		
		   System.out.println(NumberOf1_2(7));
	   }
}
