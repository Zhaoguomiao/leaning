package Algorithm;

import java.util.*;

public class Main {
    /**
     * 矩阵重塑操作
     * @param matrix
     * @param p
     * @param q
     * @return
     */
    int[][] reshape(int[][] matrix,int p,int q){
        if(matrix.length*matrix[0].length!=p*q){
            return null;
        }
        int[][] newMatrix=new int[p][q];
        int[] tempArray=new int[matrix.length*matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                tempArray[i*matrix[0].length+j]=matrix[i][j];
            }
        }
        for(int i=0;i<p;i++){
            for(int j=0;j<q;j++){
                newMatrix[i][j]=tempArray[i*q+j];
            }
        }
        return newMatrix;
    }

    /**
     * 转置操作
     * @param matrix
     * @return
     */
    int[][] T(int[][] matrix){
        int[][] newMatrix=new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                newMatrix[j][i]=matrix[i][j];
            }
        }
        return newMatrix;
    }

    /**
     * 元素查询操作
     * @param matrix
     * @param x
     * @param y
     * @return
     */
    int find(int[][] matrix,int x,int y){
        return matrix[x][y];
    }

    public static void main(String[] args) {
        int n,m,t;
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        t=scanner.nextInt();
        List<Integer> resultList=new ArrayList<>();//输出结果的列表
        int[][] matrix=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<t;i++){//仅仅用来计数，处理 t 个操作
            int op,a,b;
            op=scanner.nextInt();
            a=scanner.nextInt();
            b=scanner.nextInt();
            switch (op){
                case 1:
                    matrix=new Main().reshape(matrix,a,b);
                    break;
                case 2:
                    matrix=new Main().T(matrix);
                    break;
                case 3:
                    int result=new Main().find(matrix,a,b);
                    resultList.add(result);
                    break;
                default:
                    System.out.println("无效操作："+op);
                    break;
            }
        }
        for(int num:resultList){
            System.out.println(num);
        }
    }
}
