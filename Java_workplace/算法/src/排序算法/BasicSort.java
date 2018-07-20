package 排序算法;

import org.junit.Test;


public class BasicSort {
	/*
	 * 冒泡排序算法 
	 * 特点 ：
	 * 无论被排的数据特点如何，时间复杂度固定为n^2
	 * 空间复杂度为O(1)
	 * 思路：
	 * 逐个比较相邻两个数
	 *若发生逆序，则交换；
	 *有俩种方式进行冒泡，一种是先把小的冒泡到前边去
	 *另一种是把大的元素冒泡到后边。
	 *优化：由于每次冒泡都从头到尾亮亮比较完了所有数据，
	 *如果某次冒泡发现没有逆序对，说明当前数列已经是有序的
	 *可以可以设置个Boolean值来判断这种情况，直接退出所有循环
	 */
	public int[] bubbleSort(int[] A, int n) {
        for(int i=n-1;i>=0;i--){
        	boolean isSorted=true;
        	for(int j=0;j<i;j++){
        		if(A[j]>A[j+1]){   //判断是否是逆序对
        			
        			int temp=A[j];  //如果是则交换相邻的两个数
        			A[j]=A[j+1];
        			A[j+1]=temp;
        			isSorted=false; //有逆序对数列还未有序
        			
        		}
        		if(isSorted){
        			return A;
        		}
        	}
        }
        return A;
    }
	
	/*
	 * 选择排序  n^2
	 * 思路：
	 * 扫描寻找当前的最小值的下标并交换到有序数组的最后端
	 */
	   public int[] selectionSort(int[] A, int n) {
			int min=0;     //记录当前最小值的下标

	        for(int i=0;i<n-1;i++){  
	        	min=i;
	        	for(int j=i+1;j<n;j++){ //扫描有序数组最后端+1到待排序数组最后的位置
	        		if(A[j]<A[min]){        //寻找出最小值的下标
	        			min=j;
	        		}
	        	}
	        	if(i!=min){	        	//判断这个最小值是否恰好在	
	        		int temp=A[i];   	//有序数组的最后端+1的位置，是的话不用交换
	        		A[i]=A[min];
	        		A[min]=temp;
	        	}
	        }
	        return A;
	    }
	   
	/*
	 * 插入排序算法  n^2
	 * 思路：跟扑克牌排序一样，
	 * 拿到一个数往前一个个比，比前面的数小就往前挪，
	 * 直到合适的位置
	 */
	   public int[] insertionSort(int[] A, int n) {
		   for(int i=0;i<n;i++){
			   for(int j=i;j>0;j--){
				   if(A[j-1]<A[j]){
					   int temp=A[j-1];
					   A[j-1]=A[j];
					   A[j]=temp;
				   }
			   }
		   }
	       return A;
	    }
	   
	   /*
	    * 希尔排序
	    * 希尔排序是间隔不断变小的插入排序
	    */
	    public int[] shellSort(int[] A, int n) {
	    	for(int gap=n/2;gap>0;gap/=2){
	    		for(int i=0;i<n;i+=gap){
		        	for(int j=i;j-gap>=0;j--){
		        		   if(A[j-gap]>A[j]){
							   int temp=A[j-gap];
							   A[j-gap]=A[j];
							   A[j]=temp;
						   }
		        	}
		        }
	    	}
	    	return A;	        
	    }	   
	   
	   
	   
	   /*
	    * 归并排序 n*log N
	    */
	    public int[] mergeSort(int[] A, int n) {
	       sort(A, 0, n-1);
	       return A;
	    }
	    public void sort(int[] A,int left,int right){
	    	if(right<=left){
	    		return;
	    	}
	    	int middle=(left+right)/2;
	    	sort(A, left, middle);
	    	sort(A, middle+1, right);
	    	merge(A, left, middle,right);
	    	
	    }
	    public void merge(int[] A,int left,int middle,int right){
	    	int[] tempArray=new int[right-left+1];//用来保存数据的临时数组
	    	int i=0;
	    	int leftIndex=left;									 //左边数组临时指针
	    	int rightIndex=middle+1;							 //右边数组临时指针
	    	while(leftIndex<=middle&&rightIndex<=right){
	    		if(A[leftIndex]<A[rightIndex]){
	    			tempArray[i++]=A[leftIndex++];
	    		}else{
	    			tempArray[i++]=A[rightIndex++];
				}
	    	}
	    	while(leftIndex<=middle){
	    		tempArray[i++]=A[leftIndex++];
	    	}
	    	while(rightIndex<=right){
	    		tempArray[i++]=A[rightIndex++];
	    	}
	    	
	    	 int temp=0;
	    	while(temp+left<=right){
	    		A[left+temp]=tempArray[temp];
	    		temp++;
	    	}    	
	    }
	    
	    /*
	     * 快速排序算法
	     */
	    public int[] quickSort(int[] A, int n) {
	        quick_sort(A, 0, n-1);
	        return A;
	    }
	    public int partition(int[] data,int left,int right){
	    	int pivot=data[left];
	    	int pivotIndex=left;
	    	for(int i=left+1;i<=right;i++){
	    		if(data[i]<=pivot){
	    			pivotIndex++;
	    			if(pivotIndex!=i){//交换位置
	    				int temp=data[i];
	    				data[i]=data[pivotIndex];
	    				data[pivotIndex]=temp;
	    			}
	    		}
	    	}
	    	data[left]=data[pivotIndex];
	    	data[pivotIndex]=pivot;
	    	return pivotIndex;

	    }
	    public void quick_sort(int[] data,int left,int right){
	    	if(left<right){
	    		int pivotIndex=partition(data, left, right);
	    		quick_sort(data, left, pivotIndex-1);
	    		quick_sort(data, pivotIndex+1, right);
	    	}
	    }
	    /*
	     * 堆排序
	     * 小细节对于一个除了堆顶元素，其他节点都符合大（小）根堆的堆，
	     * 只需要调整堆顶就可以使堆有序
	     */
	    public int[] heapSort(int[] A, int n) {
	    	
	        BuildHeap(A,n);
	        for(int i=n-1;i>0;i--)
	        {
	        	//交换堆顶和最后一个元素
	        	//即每次将剩余元素中的最大者放到最后面
	            int temp=A[0];
	            A[0]=A[i];
	            A[i]=temp;
	            heap_adjust(A,0,i);      //重新调整堆顶节点成为大顶堆

	        }
	          return A;
	    }
	    /*
	     * 堆调整
	     * 一次堆调整的平均时间成本为log n
	     */
	    public void heap_adjust(int[] A,int i,int n){
	    	int leftChild=2*i+1;		//左孩子的下标
	    	int rightChild=2*i+2;    //右孩子的下标
	    	int max=i;                   	//max记录较大节点的下标
	    	if(i<n/2){                  		 //满足此条件节点才不是叶子节点
	    		if(leftChild<n&&A[leftChild]>A[max]){
	    			max=leftChild;
	    		}
	    		if(rightChild<n&&A[rightChild]>A[max]){
	    			max=rightChild;
	    		}
	    		if(i!=max){
	    			int temp=A[i];				//交换A[i]和A[max]
	    			A[i]=A[max];
	    			A[max]=temp;
	    			
	    			heap_adjust(A, max, n); //再继续调整子树
	    		}
	    	}
	    	
	    }
	    /*
	     * 建堆的时间成本为nlogn
	     */
	    public void BuildHeap(int[] A,int n)    //建立堆 
	    {
	        int i;
	        for(i=n/2-1;i>=0;i--)    //非叶节点最大序号值为n/2 -1
	        {
	            heap_adjust(A,i,n);    
	        }    
	    } 
	  
	    
	    /*
	     * 计数排序
	     */
	    public int[] countingSort(int[] A, int n) {
	    	int max=A[0];
	    	int min=A[0];
	    	for(int i=0;i<A.length;i++){
	    		if(A[i]>max){
	    			max=A[i];
	    		}    	      //确定数组的最大值和最小值，确定计数区间
	    		if(A[i]<min){
	    			min=A[i];
	    		}
	    	}
	    	int [] count_array=new int[max-min+1];	    	
	    	//计数,把所有的数装进区间为min 到 max的桶里面
	    	for(int i=0;i<A.length;i++){
	    		count_array[A[i]-min]++;
	    	}    	
	    	
	    	//把桶里的数从小到大倒出来
	    	int Index =0;
	    	for(int i=0;i<count_array.length;i++){
	    		while(count_array[i]-->0){
	    			System.out.println(Index);
	    			A[Index]=i+min;
	    			Index++;
	    		}
	    	}    	
	    	return A;
	    }
	   
	    /*
	     * 基数排序
	     */
	    public int[] radixSort(int[] A, int n) {
	      if(A==null){
	    	  return null;
	      }
	      int[][] bucket=new int[10][n];//每个桶里面可能有0~n个数   	  
	      int m=0;											 //记录循环次数
	      int k=1;
	      while(m<4){	    	  
	    	   int[]  count=new int[10];      //记录每个桶的指针位置
	    	  //把数装进桶里
	    	  for(int i=0;i<A.length;i++){
	    		  int temp=A[i]/k%10;//取余后的数
	    		  bucket[temp][count[temp]++]=A[i];	    		  
	    	  }
	    	  //把数从桶里倒出来
	    	  int tempIndex=0;
	    	  for(int i=0;i<10;i++){
	    		for(int j=0;j<count[i];j++){
	    			A[tempIndex]=bucket[i][j];
	    			tempIndex++;
	    		}    			
	    		}
	    	  m++;
	    	  k*=10;
	    	  }
	      return A;
	      }
	    	 
	    
	     /*
	      * 打印数组  
	      */
	 public void printArray(int[] B) {
		 for(int i=0;i<B.length;i++){
			   System.out.print(B[i]+" ");
		   }
		 System.out.println();
	}       
	        
	    @Test
	   public void test(){
		   int[] A={54,35,48,36,27,12,44,44,8,14,26,17,28};
//		   int[] A={12,8,14};
		   int[] B=heapSort(A, 13);
		  printArray(B);
	   }  
  
}
