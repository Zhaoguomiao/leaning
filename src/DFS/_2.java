package DFS;

public class _2 {
    static int count=0;

    static public int numIsLands(int[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        int rows=grid.length;
        int cols=grid[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    count++;
                    dfs(grid,i,j);//以当前标记为1的作为出发点，遍历他的周围的所有元素，相邻的置零，此后再执行这个循环就行了
                }
            }
        }
        return count;
    }
    //再强调一点 length是5，下标只能到4
    static void dfs(int[][] grid, int x, int y){
        if(x<0||y<0||x>=grid.length||y>=grid[0].length||grid[x][y]==0){//这个深度搜索仅仅是把相邻为1的节点置为0，
            return;
        }

        grid[x][y]=0;//将根节点==0；仅这一个作用

        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);

    }

    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {1,0,1,0,1},
                {1,0,1,0,1},
                {1,1,1,1,1},
                {1,0,1,0,1},
                {1,0,1,0,1}
        };
        System.out.println(numIsLands(grid));

    }

}
