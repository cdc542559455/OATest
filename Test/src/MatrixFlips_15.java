import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MatrixFlips_15 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}, {7,8,9}};
        List<int[][]> res = processMatrix(matrix, new int[]{0,1,2});
        for(int[][] matr : res) {
            System.out.println(Arrays.deepToString(matr));
        }
    }

    public static List<int[][]> processMatrix(int[][] a, int[] q) {
        List<int[][]> res = new ArrayList<>();
        if (a == null || a.length == 0 || a[0].length == 0) return res;
        for(int subQ: q) {
            int[][] copy = copy2DArray(a);
            if (subQ == 0) {
                res.add(rotateClockWise(copy));
            } else if (subQ == 1) {
                res.add(flipOverMainDiagonals(copy));
            } else {
                res.add(flipOverSecondaryDiagonal(copy));
            }
        }

        return res;

    }

    public static int[][] copy2DArray(int[][] origin) {
        int [][] copy = new int[origin.length][origin[0].length];
        for(int i = 0; i < origin.length; i++) {
            for(int j = 0; j < origin[0].length; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

    private static int[][] rotateClockWise(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = i; j < n - i - 1; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n- j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        return matrix;
    }

    private static int[][] flipOverMainDiagonals(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i ; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }

    private static int[][] flipOverSecondaryDiagonal(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = n - i - 1; j >= 0; j--) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = temp;
            }
        }
        return matrix;
    }

}
