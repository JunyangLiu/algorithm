package 剑指offer;

import org.junit.Test;

public class Solution_31 {
	/*
	 * 求出1~13的整数中1出现的次数,
	 * 并算出100~1300的整数中1出现的次数？
	 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
	 * 但是对于后面问题他就没辙了。
	 * ACMer希望你们帮帮他,并把问题更加普遍化,
	 * 可以很快的求出任意非负整数区间中1出现的次数。
	 */
    public int NumberOf1Between1AndN_Solution(int n) {
    	int high=0;
    	int low=0;
    	int current=0;
    	int result=0;
    	 for (int m = 1; m <= n; m *= 10){
    		 current=n/m%10;
    		 low=n-(n/m)*m;
    		 high=n/(m*10);

    		 if (current==0) {
				result+=high*m;
			}
    		if(current==1){
    			result+=high*m+low+1;
    		}
    		if(current>=2){
    			result+=(high+1)*m;
    		}

    	 }
        return result;
    }
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }
 @Test
 public void test(){

	 System.out.println(countDigitOne(121));
	 System.out.println(NumberOf1Between1AndN_Solution(121));
 }
}
