package 剑指offer;

import org.junit.Test;

public class Solution_11 {
    public double Power(double base, int exponent) {
        if(exponent==0){
        	return 1;
        }
        if(exponent>0){
        	return power(base, exponent);
        }else{
        	exponent=Math.abs(exponent);
        	return 1/power(base, exponent);
        }
  }
    public double power(double  base,int exponent) {
        if(exponent==0){
        	return 1;
        }
        if(exponent==1){
        	return base;
        }
        double result=power(base, exponent>>1);
        result*=result;
        if((exponent&1)==1){
        	result*=base;
        }
        return result;
	}
    @Test
    public void test(){
    	System.out.println(Power(2, -3));
    }
}
