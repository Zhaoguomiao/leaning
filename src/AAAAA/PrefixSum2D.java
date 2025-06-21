package AAAAA;

public class PrefixSum2D {
    private int[][] prefix;

    // 构建二维前缀和数组
    public PrefixSum2D(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        prefix = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + matrix[i][j];
            }
        }
    }
    // 查询子矩阵的和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        PrefixSum2D ps2d = new PrefixSum2D(matrix);
        System.out.println("子矩阵[0,0,1,1]的和: " + ps2d.sumRegion(0, 0, 1, 1)); // 1+2+4+5=12
        System.out.println("子矩阵[1,1,2,2]的和: " + ps2d.sumRegion(1, 1, 2, 2)); // 5+6+8+9=28
    }
}
