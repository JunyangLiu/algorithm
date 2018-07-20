package 位运算;

public class Swap {
    public int[] getSwap(int[] num) {
        int a=num[0],b=num[1];
        a=a^b;
        b=a^b;
        a=a^b;
        num[0]=a;
        num[1]=b;
        return num;
    }
}
