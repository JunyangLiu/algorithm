package 剑指offer;

import org.junit.Test;

public class Solution_40 {
/*
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    	int a=0;
        for(int i=0;i<array.length;i++){
        	a^=array[i];
        }
        System.out.println(a);
        //此时a为两个数字异或的结果
        int index=0;
        int b=a;
        for(int i=0;i<=31;i++){
        	if((b&1)==1){
        		index=i;
        		break;
        	}
        	b=b>>>1;
        }
        System.out.println(index);
        b=0;
        //找出其中一个数
        for(int i=0;i<array.length;i++){
        	if((array[i]>>>index&1)==1){
        		b^=array[i];
        	}
        }
        System.out.println(b);
        a=a^b;
        num1[0]=a;
        num2[0]=b;
        System.out.println("a="+a+" b="+b);
    }
    @Test
    public void test(){
    	int[] array={2,4,3,6,3,2,5,5};
    	int[] num1={0};
    	int[] num2={0};
    	FindNumsAppearOnce(array, num1, num2);
    }
}
