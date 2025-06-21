package AAAAA;

import java.util.Scanner;

public class Apple {
    static int n;
    static int m;
    static int maxResult;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        int[] A=new int[m+1];
        for(int i=1;i<=m;i++){
            A[i]=scanner.nextInt();
        }
        A[0]=0;
        maxResult=Integer.MIN_VALUE;
        backTrack(A,n,0);
        System.out.println(maxResult);
    }

    /**
     * 回溯法
     * @param A
     * @param remainApple
     * @param currentResult
     */
    public static void backTrack(int[] A,int remainApple,int currentResult){
        if(remainApple==0){
            maxResult=Math.max(currentResult,maxResult);
            return;
        }
        for(int i=1;i<=Math.min(remainApple,m);i++){
            currentResult+=A[i];
            remainApple-=i;
            backTrack(A,remainApple,currentResult);
            currentResult-=A[i];
            remainApple+=i;
        }
    }
}
