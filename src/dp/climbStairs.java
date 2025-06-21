package dp;

public class climbStairs {
    public static int Function(int n){
        int[] dp=new int[n+1];//表示 dp[3]表示 到达第3阶台阶 有多少种走法。
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // 非静态方法 需要创建 类的示例来进行调用 静态方法属于类本身的元素，可以直接调用
    public static void main(String[] args) {
        int n=3;
        System.out.println(climbStairs.Function(n));
    }
}
