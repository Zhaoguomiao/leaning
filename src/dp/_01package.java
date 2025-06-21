package dp;

import java.util.Scanner;

public class _01package {
    static int N;
    static int V;
    static int[] v=new int[N+1];//体积数组
    static int[] w=new int[N+1];//价值数组

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        V=scanner.nextInt();
        for(int i=1;i<=N;i++){//不仅仅用于计数，同时也是 数组的下标 从1开始
            v[i]=scanner.nextInt();
            w[i]=scanner.nextInt();
        }
        int[][] dp=new int[N+1][V+1];//均从1开始//表示 当 考虑 3个物品时，容量为5的时候的最大价值
        for(int i=1;i<=N;i++){//计数同时是下标
            for(int j=1;j<=V;j++){
                //考虑要不要拿容量为j  的物品
                if(j>=v[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-v[i]]+w[j]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[N][V]);

    }
}
