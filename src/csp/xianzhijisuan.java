package csp;

import Algorithm.Main;

import java.util.Scanner;

public class xianzhijisuan {
    static int n;
    static double x;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        x=scanner.nextDouble();
        double result=0;
        for(int i=0;i<=n;i++){
            int currentMoney=scanner.nextInt();
            if(i==0){
                result+=currentMoney*Math.pow(1+x,i);
            }else {
                result+=currentMoney*Math.pow(1+x,-i);
            }
        }
        System.out.println(result);
    }
}
