package AAAAA;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class Maze {
    static int N;
    static char[][] maze;
    static List<String> paths=new ArrayList<>();
    static int[] dx=new int[]{-1,1,0,0};
    static int[] dy=new int[]{0,0,-1,1};
    static String[] dirChars=new String[]{"U","D","L","R"};
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        maze=new char[N][N];//迷宫的下标 是从0开始的
        int startX=-1,startY=-1;
        for(int i=0;i<N;i++){
            String line=scanner.nextLine();
            for(int j=0;j<N;j++){
                maze[i][j]=line.charAt(j);
                if(maze[i][j]=='S'){
                    startX=i;
                    startY=j;
                }
            }
        }
        boolean[][] visited=new boolean[N][N];//标记数组，用以标记在同一个顺序中是否被访问过
        backtrack(startX,startY,visited,new StringBuilder());
        if(paths.isEmpty()){
            System.out.println(-1);
        }else {
            Collections.sort(paths);
            for(String s:paths){
                System.out.println(s);
            }
        }
    }
    private static void backtrack(int startX, int startY, boolean[][] visited, StringBuilder stringBuilder) {
        if(maze[startX][startY]=='E'){
            paths.add(stringBuilder.toString());
            return;
        }
        /**
         * 模拟让他 执行一次,   用最简单的一种情况 比如说两层的递归，让递归实现一次，从而确定整体逻辑
         */
        visited[startX][startY]=true;//标记这条路径上被访问
        for(int i=0;i<4;i++){//仅仅起一个计数的作用和下标访问
            startX+=dx[i];
            startY+=dy[i];
            if(startX>0&&startX<N&&startY>0&&startY<N&&!(visited[startX][startY])&&!(maze[startX][startY]=='1')){
                stringBuilder.append(dirChars[i]);
                backtrack(startX,startY,visited,stringBuilder);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);//删除最后一个字符
            }
        }
        visited[startX][startY]=false;
    }
}
