package AAAAA;

import java.util.Arrays;
import java.util.Scanner;

public class Apple1 {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        int[] A=new int[m+1];
        for(int i=1;i<=m;i++){
            A[i]=scanner.nextInt();
        }
        A[0]=0;
        /**
         * dp
         * dp 数组代表只吃  i 个苹果时的最大能量
         * 所考虑的 状态已经不一样了，不需要考虑 最后一天 这j个是否够吃，因为今天的依赖于dp[i-j]
         */
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){//依次填入表格，空间换时间
            dp[i]=0;
            for(int j=1;j<=Math.min(m,i);j++){
                dp[i]=Math.max(dp[i],dp[i-j]+A[j]);
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);

    }
}
