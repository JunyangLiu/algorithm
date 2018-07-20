package 剑指offer;

import org.junit.Test;

public class Solution_49 {
    public int StrToInt(String str) {
    	if(str==null||str.length()==0){
    		return 0;
    	}
        char [] s=str.toCharArray();
        int sum=0;
        int a=1;
        for(int i=s.length-1;i>=0;i--){
        	if(s[i]>=48&&s[i]<=57){
        	sum+=(s[i]-48)*a;
        	a*=10;
        	}else if(s[i]=='-'){
        	sum=0-sum;
        	}else if(s[i]=='+'){
        		
        	}else{
        		sum=0;
        		break;
        	}
        }
        return sum;
    }
    @Test
    public void test(){
    	System.out.println(StrToInt("1a23"));
    }
}
