package huishuo;

import Algorithm.Main;

public class eightQueen {
    private static final int N = 8; // 棋盘大小
    private static int[] queens = new int[N]; // queens[row] = col 表示皇后位置
    private static int count = 0; // 统计解的数量

    public static void main(String[] args) {
        solve(0); // 从第0行开始放置
        System.out.println("总解数: " + count);
    }

    // 回溯法核心逻辑
    private static void solve(int row) {
        if (row == N) {
            printSolution(); // 找到解，打印
            count++;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                queens[row] = col;   // 放置皇后
                solve(row + 1);      // 递归下一行
            }
        }
    }

    // 检查当前位置 (row, col) 是否安全
    private static boolean isSafe(int row, int col) {
        for (int i = 0; i < row; i++) {
            // 列冲突或对角线冲突
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    // 打印当前解
    private static void printSolution() {
        System.out.println("解 " + (count + 1) + ":");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(queens[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
