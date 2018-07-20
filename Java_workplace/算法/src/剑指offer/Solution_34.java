package 剑指offer;

import org.junit.Test;

public class Solution_34 {
/*
 * 在一个字符串(1<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置
 */
    public int FirstNotRepeatingChar(String str) {
    	int [] hash=new int[58];
    	char [] s=str.toCharArray();
    	for(int i=0;i<s.length;i++){
    		hash[s[i]-65]++;
    	}
    	 int result=0;
    	for(int i=0;i<s.length;i++){
    		if(hash[s[i]-65]==1){
    			result=i;
    	    	break;
    		}

    	}
        return result;
    }
    @Test
    public void test(){
   System.out.println(FirstNotRepeatingChar("google"));
//    	System.out.println(Integer.valueOf((int)'z'));

    }
}
