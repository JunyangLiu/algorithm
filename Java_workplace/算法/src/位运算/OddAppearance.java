package 位运算;

import org.junit.Test;

public class OddAppearance {
	 public int[] findOdds(int[] arr, int n) {
		 	//设两个数为e0,e1
	        int e0 = 0 , e1 = 0;
	        for(int i = 0 ; i < n ; i++){
	            e0 = e0 ^ arr[i];
	        }
	        //此时e0 =e0^e1
	       int index=0;//寻找e0^e1结果中含1的位置（第一个，任意一个都行）
	       while(((e0>>>index)&1)!=1)index++;

	       for(int i = 0 ; i < n ; i++){
	    	   if(((arr[i]>>>index)&1)==1)
	            e1 = e1 ^ arr[i];
	        }
	       e0=e0^e1;
	       int[] result={Math.min(e0, e1),Math.max(e0, e1)};

	       return result;
	    }
	    public int findOdd(int[] A, int n) {
	        int e0 = 0;
	        for(int i = 0 ; i < n ; i++){
	            e0 = e0 ^ A[i];
	        }
	        return e0;
	    }
	   @Test 
	   public void test(){
		   int[] arr={5,5,15,7,7,9,9,10};
		   findOdds(arr, 8);
	   }
}
