package Algorithm;

import java.util.Scanner;

public class _01 {
    static int W;
    static int n;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        W=scanner.nextInt();
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        for(int i=1;i<=n;i++){
            w[i]=scanner.nextInt();
            v[i]=scanner.nextInt();
        }
        int[][] dp=new int[n+1][W+1];
        /**
         * 对于这个二维数组
         * 第一行代表 只有1个宝物时，容量大小分别为1 2 3 .。。。。。W时 所携带的最大价值
         * 最后一行    有n个宝物时，容量大小为1 2 3 .。。。。。。。W时 所携带的最大价值
         */
        /**
         * dp[3][5]
         * 表示  考虑  3 件物品，且当 背包容量 等于5时的最大价值   也就是说 放进 dp数组里面的 都是 最大值  都是 子问题的最优解
         */
        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(j>=w[i]){//当前可以考虑 拿一个宝物
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
    }
}
