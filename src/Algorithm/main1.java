package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class main1 {
    static int n;
    static int m;
    static int[] options;
    static int[] answer;
    static int[] prefix;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        options=new int[n+1];//均不使用下标0
        for(int i=1;i<=n;i++){
            options[i]=scanner.nextInt();
        }
        /**
         * 目标就是向  answer数组中  填入 答案
         */
        prefix=new int[n+1];
        prefix[0]=1;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]*options[i];
        }
        answer=new int[n+1];
        int[] sums=new int[n+1];
        sums[0]=0;
        for(int i=1;i<=n;i++){
            //先计算当前需要的和
            for(int j=1;j<=i-1;j++){
                sums[j]=sums[j-1]*answer[j];
            }
            answer[i]=(m%prefix[i]-sums[i])/prefix[i-1];
        }
        System.out.println(Arrays.toString(answer));
    }
}
