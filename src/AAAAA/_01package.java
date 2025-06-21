package AAAAA;

import java.util.Scanner;

public class _01package {
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
