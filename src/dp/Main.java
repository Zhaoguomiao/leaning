package dp;

import java.util.Scanner;

public class Main {
    static int n;//共有 n 本书可以选择
    static int condition;//必须大于等于这个条件

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        condition=scanner.nextInt();
        int[] value=new int[n+1];//不适用  0 下标 下标就代表编号
        value[0]=0;
        for(int i=1;i<=n;i++){
            value[i]=scanner.nextInt();
        }


    }

}
