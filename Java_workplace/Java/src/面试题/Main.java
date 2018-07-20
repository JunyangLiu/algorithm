package 面试题;


import java.util.HashSet;
import java.util.Scanner;
 
public class Main {
 
    public static int getMaxCount(String []nums){
        HashSet<Integer> data = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int input = Integer.valueOf(nums[i]);
            data.add(input);
            if(input<min){
                min = input;
            }
            if(input>max){
                max = input;
            }
        }
        int count = 1;
        int maxCount = 1;
        for(int i = min+1;i<=max;i++){
            if(data.contains(i)){
                count++;
                if(count>maxCount){
                    maxCount = count;
                }
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();
        inputData = inputData.substring(1,inputData.length()-2);//去括号
        String nums[] = inputData.split(",");
        System.out.println(getMaxCount(nums));
      

    }
}
