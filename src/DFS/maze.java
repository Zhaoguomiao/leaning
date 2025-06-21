package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class maze {
    static int N;
    static char[][] maze;
    static List<String> paths=new ArrayList<>();//字符串数组，用于保存成功的路径
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static String[] dirChars={"U","D","L","R"};

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt();
        maze=new char[N][N];
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
        boolean[][] visited=new boolean[N][N];
        dfs(startX,startY,visited,new StringBuilder());

        if(paths.isEmpty()){
            System.out.println(-1);
        }else {
            Collections.sort(paths);
            for(String s:paths){
                System.out.println(s);
            }
        }
    }
    static void dfs(int x,int y,boolean[][] visited ,StringBuilder path){
        if(maze[x][y]=='E'){
            paths.add(path.toString());//在最深层保存结果
            return;//返回到上一层的 dfs函数调用处
        }
        visited[x][y]=true;//标记以访问

        for(int i=0;i<4;i++){
            int currentX=x+dx[i];
            int currentY=y+dy[i];
            if(currentX>0&&currentX<N&&currentY>0&&currentY<N&&!visited[currentX][currentY]&&!(maze[currentX][currentY]=='1')){
                path.append(dirChars[i]);// 表明  这个方向可以走  保存记录

                dfs(currentX,currentY,visited,path);//带着此时的方向再执行 dfs循环

                path.deleteCharAt(path.length()-1); //四个方向都不行的话，这条语句都不会执行，或者说最后没有成功，那也只是把错误的路径删除
            }
        }
        visited[x][y]=false;//对于一个节点的四个方向全部尝试之后，就置0
    }


}
