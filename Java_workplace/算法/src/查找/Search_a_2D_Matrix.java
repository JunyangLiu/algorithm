package 查找;

public class Search_a_2D_Matrix {
	
	/*
	 * 牛客网
	 * 题目 ：有序矩阵查找练
	 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法
	 * 快速查找矩阵中是否含有值x。
	 * 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，
	 * 请返回一个bool值，代表矩阵中是否存在x。
	 * 所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
	 */
    public boolean findX(int[][] mat, int n, int m, int x) {
        int i=0;
        int j=m-1;
        while(i<=n-1&&j>=0){
        	if(mat[i][j]>x){
        		j--;
        	}else if(mat[i][j]<x){
        		i++;
        	}else{
        		return true;
        	}
        }
        return false;
    }
    /*
     * 74. Search a 2D Matrix
     * Write an efficient algorithm that searches for a value in an m x n matrix. 
     * This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * For example,
     * [ 
     * [1,   3,  5,  7], 
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     *  ]
     *  Given target = 3, return true.
     */
    
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null||matrix.length==0){
    		return false;
    	}
    	int n=matrix.length;			//行
    	int m=matrix[0].length;	//列
        int i=0;
        int j=m-1;
        while(i<=n-1&&j>=0){
        	if(matrix[i][j]>target){
        		j--;
        	}else if(matrix[i][j]<target){
        		i++;
        	}else{
        		return true;
        	}
        }
        return false; 
    }
    /*
     240. Search a 2D Matrix II
     Write an efficient algorithm that searches for a value in an m x n matrix.
     This matrix has the following properties:
	 Integers in each row are sorted in ascending from left to right.
	 Integers in each column are sorted in ascending from top to bottom.
	 For example,
	Consider the following matrix:
	[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
     */
 //解法与上题相同
}
