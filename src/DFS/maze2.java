package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class maze2 {
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
        boolean[][] visited=new boolean[N][N];//标记数组，用以标记，是否被访问过
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
    public static void backtrack(int x,int y,boolean[][] visited,StringBuilder path){
        if(maze[x][y]=='E'){
            paths.add(path.toString());
            return;
        }
        /**
         * 在写递归程序的时候，可以考虑先让他走一步
         */
        visited[x][y]=true;//标记以访问
        /**
         * 递归程序最外层其实也就执行一次而已，对于最开始的一个起点，也不过是执行了 for循环的四个方向，而已，在任意一个方向上的每一个值都进行了下一个四次for循环，不能往回走
         */
        for(int i=0;i<4;i++){
            int currentX=x+dx[i];
            int currentY=y+dy[i];
            if(currentX>0&&currentX<N&&currentY>0&&currentY<N&&!visited[currentX][currentY]&&!(maze[currentX][currentY]=='1')){
                path.append(dirChars[i]);
                backtrack(currentX,currentY,visited,path);
                path.deleteCharAt(path.length()-1);
            }
        }
        visited[x][y]=false;//对于一个节点的四个方向全部尝试之后，就置0
    }

}
