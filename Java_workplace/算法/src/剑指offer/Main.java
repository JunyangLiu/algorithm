package 剑指offer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String input=in.next();
		 char[] arr=input.toCharArray();
		 if(arr==null||arr.length<=1){
			 System.out.println(0);
		 }
		 if(arr.length==2){
			 if(arr[0]==arr[1]){
				 System.out.println(1);
			 }else{
				 System.out.println(0);
			 }
		 }
		 
		 char pre,cur,next,end;
		 int result=0;
		 for(int i=3;i<=arr.length;i++){
			 pre=arr[i-3];
			 cur=arr[i-2];
			 next=arr[i-1];
			 if(i==arr.length){
				 end=change(cur, next);
			 }else{
				 end=arr[i];
				 }
			
			 if(pre==cur&&cur==next){
				 System.out.println("same");
				 arr[i-2]=change(pre,end);
				 result++;
				 }else if(pre==cur){
					 arr[i-3]=change(cur, next);
					 result++;
				 }else if(cur==next){
					 arr[i-1]=change(cur, end);
					 result++;
				 }
			 }
		 System.out.println(result);
		 }


//输出除两个颜色外的颜色
public static char change(char a,char b){
	if(a!='R'&b!='R'){
		return 'R';
	}else if(a!='G'&b!='G'){
		return 'G';
	}else if(a!='B'&b!='B'){
		return 'B';
	}else{
		return 'Y';
	}
}
}
