package 剑指offer;

public class Solution_01 {
/*题目：二维数组的查找
 * 在一个二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
    public boolean Find(int target, int [][] array) {
    	int n=0;//行
    	int m=array[0].length-1;//列
    	while(n<array.length&&m>=0){
    		if(array[n][m]>target){
    			m--;
    		}
    		else if(array[n][m]<target){
    			n++;	
    		}else{
    			return true;
    		}
    		}
    	return false;
    }
}
