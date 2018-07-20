package 智力题;

import java.util.Arrays;

import org.junit.Test;

public class HorseRace {
    public int winMost(int[] oppo, int[] horses, int n) {
    	Arrays.sort(oppo);
    	Arrays.sort(horses);
    	int result=0;
    	int i=0,j=0;
   
    	while(j<n){
    		if(oppo[i]<horses[j]){
    			i++;
    			j++;
    			result++;
    		}else{
    			j++;
    		}
    	}
        return result;
    }
    @Test 
	   public void test(){
		   int[] horses={2,1,3,4};
		   int[] oppo={3,2,1,4};
		   System.out.println(winMost(oppo, horses, 4));
	   }
}
