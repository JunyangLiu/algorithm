package 剑指offer;

import java.util.ArrayList;

import org.junit.Test;

public class Solution_18 {
	/*
	 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
	 * ，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	ArrayList<Integer> list=new ArrayList<>();
    	int n=matrix.length;//行
    	int m=matrix[0].length;//列
    	int startX=0,startY=0;
    	int i=0;
    	while(startX*2<=n-1&&startY*2<=m-1){
//    		System.out.print(startX+" "+startY+" "+n+" "+m  );
    		print(matrix, list, startX, startY, n-(2*i), m-(2*i));
    		i++;
    		startX++;
    		startY++;

    	}
        return list;
    }
    public void print(int[][] matrix,ArrayList<Integer> list,int startX,int startY,int n,int m)  {
   		System.out.print(startX+" "+startY+" "+n+" "+m  );
		for(int i=0;i<m;i++){
			list.add(matrix[startX][startY+i]);
		}
		for(int i=1;i<n;i++){
			list.add(matrix[startX+i][startY+m-1]);
		}
		if(n>1){
			for(int i=m-2;i>=0;i--){
				list.add(matrix[startX+n-1][startY+i]);
			}
		}
		if(m>1){
			for(int i=n-2;i>=1;i--){
				list.add(matrix[startX+i][startY]);
			}
		}		
	}
@Test
public void test(){
//	int[][] matrix={{1,2,3,4},{5,6,7,8}	,{9,10,11,12},{13,14,15,16}	};
	int[][] matrix={{1}};
//	ArrayList< Integer> list=new ArrayList<>();
	ArrayList<Integer> list=printMatrix(matrix);
//     print(matrix, list, 0, 0, 1, 1);
	for(Integer i:list){
		System.out.print(i+"  ");
	}
}
}
