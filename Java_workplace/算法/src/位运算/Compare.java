package 位运算;

import org.junit.Test;

public class Compare {
    public int getMax(int a, int b) {
    	int c=a-b;
    	int sa=sign(a);
    	int sb=sign(b);
        int sc=sign(c);

        int diffab=sa^sb;
        int samab=flip(diffab);
        int returnA=diffab*sa+samab*sc;
    
        return a*returnA+b*flip(returnA);
    }
    //返回一个数的正负，1为正，0为负
    public int sign(int num){
    	return flip((num>>31)&1) ;
    }
    /*
     * n是一个32位的有符号整型，
     * n 右移 31 位后，最低位就是符号位了，
     * &1 取出最低位。
     *  在 java 中，>> 系有符号右移，右移后，会保留最高位不变。
     *  如果是正数则在高位插入0，负数就在高位插入1；
     *   >>> 系无符号右移，右移后，最高位置0。
     *   在 java 中 (n>>31) & 1 == n>>>31。 
     *   任意int类型的数 n>>31后
     *   c++中没有无符号右移操作符。
     */
    //把一个数按位取反
    public int flip(int num){
    	return num^1;
    }
	   @Test 
	   public void test(){
		   int[] arr={4597112,14102417};
		  System.out.println(getMax(4597112,14102417));

	   }
}
