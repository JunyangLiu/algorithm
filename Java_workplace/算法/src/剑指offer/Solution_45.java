package 剑指offer;

import org.junit.Test;

public class Solution_45 {
//判断五张牌是否为顺子
	/*	
	 * 思路：
	 * 1. 除0外没有重复的数
	 * 2. max - min < 5
	 * 
	 */
    public boolean isContinuous(int [] numbers) {
    	if(numbers.length!=5){
    		return false;
    	}
    	int[] map=new int[14];
    	int max=-1,min=14;
    	for(int i=0;i<numbers.length;i++){
    		if(numbers[i]>max)max=numbers[i];
    		if(numbers[i]!=0&&numbers[i]<min)min=numbers[i];
    		map[numbers[i]]++;
    		if(numbers[i]!=0&&map[numbers[i]]>1){
    			System.out.println("map");
    			return false;
    		}
    	}
    	if(max-min<5){
    		return true;
    	}else{
    		System.out.println("max="+max+" min="+min);
    		System.out.println("if");
    		return false;
    	}
    }
    @Test
    public void test(){
    	int[] numbers={0,3,2,6,4};
    	System.out.println(isContinuous(numbers));
    }
}


