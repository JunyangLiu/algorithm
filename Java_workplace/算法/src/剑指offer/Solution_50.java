package 剑指offer;

public class Solution_50 {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	int current;
        for(int i=0;i<length;i++){
        	current=numbers[i];
        	if(current>=length)
        		current-=length;
        	if(numbers[current]>=length){
        		duplication[0]=current;
        		return true ;      		
        	}else{
        		numbers[current]+=length;
        	}
        }
        return false;
    }
}
