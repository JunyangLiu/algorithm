package 二分搜索;

public class LeftMostAppearance {
/*
 * 对于一个有序数组arr，再给定一个整数num，
 * 请在arr中找到num这个数出现的最左边的位置。
 * 给定一个数组arr及它的大小n，同时给定num。
 * 请返回所求位置。若该元素在数组中未出现，请返回-1。
 * 测试样例：
 * [1,2,3,3,4],5,3
 * 返回：2
 */
	public static void main(String[] args) {
		int[] arr={0,1,5,6,10,13,17,21,22,23,25,27,31,35,38,41};
		System.out.println(findPos2(arr, arr.length));

	}
    public static int findPos(int[] arr, int n, int num) {
     int left=0,right=n-1,mid;
     while(left!=right){
//    	 System.out.println("while");
    	 mid=(left+right)/2;
    	 if(arr[mid]>num){
//        	 System.out.println("if");
    		 right=mid-1;
    	 }else if(arr[mid]<num){
//        	 System.out.println("else if");
    		 left=mid+1;
    	 }else{
//    	   	 System.out.println("else");
    		 if(mid==0){
    			 return 0;
    		 }else if(arr[mid-1]<num){
    			 return mid;
    		 }else{
    			 right=mid-1;
    		 } 		 
    	 }
     }
	 return left;
    }
    /*
     * 有一个有序数组arr，其中不含有重复元素，
     * 请找到满足arr[i]==i条件的最左的位置。
     * 如果所有位置上的数都不满足条件，返回-1。
     * 给定有序数组arr及它的大小n，请返回所求值。
     * 测试样例：
     * [-1,0,2,3],4
     * 返回：2
     */
    
    public static int findPos2(int[] arr, int n) {
        int left=0,right=n-1;
        int mid;
        int res=-1;
        while(left<=right){
        	if (arr[left] > left || arr[right] < right) {
				break;
			}
        	
        	mid=(left+right)/2;
        	if(arr[mid]>mid){
        		right=mid-1;
        	}else if(arr[mid]<mid){
        		left=mid+1;
        	}else{
        		res=mid;
        		right=mid-1;
        	}
        }
        return res;

    }
}
