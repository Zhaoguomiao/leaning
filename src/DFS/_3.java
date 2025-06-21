package DFS;

import java.util.Scanner;
public class _3 {

    private static int minSteps=Integer.MAX_VALUE;
    private static int[][] directions={//二维数组是从左上角往右小角看的
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
    };
    private static void dfs(char[][] maze,boolean[][] visited,int x,int y,int endx,int endy,int steps){
        if(x<0||x>=maze.length||y<0||y>=maze[0].length||maze[x][y]=='1'||visited[x][y]){
            return;
        }
        if(x==endx&&y==endy){
            minSteps=Math.min(minSteps,steps);
            return;
        }
        if(steps>=minSteps){
            return;
        }

        visited[x][y]=true;

        for(int[] dir:directions){//对任意一个顶点执行上下左右四个方向的搜索
            dfs(maze, visited, x + dir[0], y + dir[1], endx, endy, steps + 1);
        }

        visited[x][y]=false;//保证路径重用
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        scanner.nextLine();

        char[][] maze=new char[N][M];
        int[] start=new int[2];
        int[] end=new int[2];  //保存的是起点的 坐标

        for(int i=0;i<N;i++){//一行一行的录入 字符，同时获取起点和重点
            String line=scanner.nextLine().replaceAll(" ","");
            for(int j=0;j<M;j++){
                maze[i][j]=line.charAt(j);
                if(maze[i][j]=='S'){
                    start[0]=i;
                    start[1]=j;
                } else if (maze[i][j] == 'E') {
                    end[0]=i;
                    end[1]=j;
                }
            }
        }
        boolean[][] visited=new boolean[N][M];//是否被检查过
        dfs(maze,visited,start[0],start[1],end[0],end[1],0);
        System.out.println(minSteps==Integer.MAX_VALUE?-1:minSteps);
    }

}
