/**
 * Created by Administrator on 2017/7/25 0025.
 */
public class Twelve {
    private static boolean visited[][];

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boolean r = backtrace(matrix, rows, cols, i, j, str, 0);
                if (r) {
                    return r;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[] matrix, int rows, int cols, int rowIdx, int colIndex, char[] str, int idx) {
        if (idx == str.length)
            return true;

        if (rowIdx < 0 || rowIdx >= rows || colIndex < 0 || colIndex >= cols || visited[rowIdx][colIndex] || str[idx] != matrix[rowIdx * cols + colIndex])
            return false;

        visited[rowIdx][colIndex] = true;

        if (backtrace(matrix, rows, cols, rowIdx + 1, colIndex, str, idx + 1)
                || backtrace(matrix, rows, cols, rowIdx - 1, colIndex, str, idx + 1)
                || backtrace(matrix, rows, cols, rowIdx, colIndex - 1, str, idx + 1)
                || backtrace(matrix, rows, cols, rowIdx, colIndex + 1, str, idx + 1)) {
            return true;
        }

        visited[rowIdx][colIndex] = false;

        return false;
    }
}