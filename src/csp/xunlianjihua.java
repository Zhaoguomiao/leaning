package csp;

import java.util.Arrays;
import java.util.Scanner;

public class xunlianjihua {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        int[] dependency=new int[m+1];//均不适用 0 作为索引
        int[] days=new int[m+1];
        int[] begin=new int[m+1];
        Arrays.fill(begin,-1);
        for(int i=1;i<=m;i++){
            dependency[i]=scanner.nextInt();
        }
        for(int i=1;i<m+1;i++){
            days[i]=scanner.nextInt();
        }
        /**
         * 如果 第一个项目的依赖 为0，那么说明可以直接从第一天开始
         * 如果不为o，先找开始数组中是否有值，有值的话直接加上 他的天数，就是我最早开始的时间
         * 如果 开始数组中 没有值，
         */
        for(int i=1;i<=m;i++){//向 begin数组中填入数值，一个一个填
            if(dependency[i]==0){
                begin[i]=1;
                continue;
            }else {
                if(begin[dependency[i]]==-1){
                    begin[i]=days[dependency[i]]+1;
                }else {
                    begin[i]=begin[dependency[i]]+days[dependency[i]];
                }
            }

        }
        System.out.println(Arrays.toString(begin));
    }

}
