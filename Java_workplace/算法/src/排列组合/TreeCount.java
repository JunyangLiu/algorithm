package 排列组合;

public class TreeCount {
/*
 * 求n个无差别的节点构成的二叉树有多少种不同的结构？
 * 给定一个整数n，请返回不同结构的二叉树的个数。保证结果在int范围内。
 * 测试样例：
 * 1
 * 返回：1
 */
    public int countWays(int n) {
        // write code here
	int sum=1;
   for(int i=0;i<n;i++){
   	sum=sum*(2*n-i);
   }

   for(int i=1;i<=n;i++){
   	sum/=i;
   }
   return  sum/(n+1);
}
}
