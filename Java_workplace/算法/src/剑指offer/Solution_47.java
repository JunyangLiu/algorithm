package 剑指offer;

public class Solution_47 {
    public int Sum_Solution(int n) {
        int result=n;
        boolean ans=(n>0)&&((result+=Sum_Solution(n-1))>0);
        return result;
    }
}
