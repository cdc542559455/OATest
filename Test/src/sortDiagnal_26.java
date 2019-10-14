import java.lang.reflect.Array;
import java.util.Arrays;

//15 sort diagnal https://www.1point3acres.com/bbs/thread-546408-1-1.html 第二题
//        给2D array, 斜的(方向从左上到右下)为一列做sorted
//        ex :
//        4, 5, 3                2, 1, 3
//        3, 2, 1       =>    1, 3, 5
//        2, 1, 3                2, 3, 4
//
//        ex:
//        1, 3, 9, 4              1, 3, 7, 4
//        9, 5, 7, 7     =>     2, 2, 7, 9
//        3, 6, 9, 7              2, 6, 5, 7
//        1, 2, 2, 2               1, 3, 9, 9

public class sortDiagnal_26 {
    public static void main(String[] args) {
        int[][] originalArray = {{1,2,3,7},{8,9,6,2},{4,3,2,3}};
        System.out.println(Arrays.deepToString(sortDiagnal(originalArray)));
    }

    public static int[][] sortDiagnal(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return matrix;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for(int i = matrix.length - 1; i >= 0; i --) {
            int len = Math.min(rowLength - 1 - i, colLength - 1 - 0) + 1;
            if (len == 1) continue;
            int[] diagonals = new int[len];
            fillDiagnalsOrMatrix(matrix, diagonals, 0, i, 0, true);
            Arrays.sort(diagonals);
            fillDiagnalsOrMatrix(matrix, diagonals, 0, i, 0, false);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int len = Math.min(rowLength - 1 - 0, colLength - 1 - j) + 1;
            if (len == 1) continue;
            int[] diagonals = new int[len];
            fillDiagnalsOrMatrix(matrix, diagonals, 0, 0, j, true);
            Arrays.sort(diagonals);
            fillDiagnalsOrMatrix(matrix, diagonals, 0, 0, j, false);
        }
        return matrix;

    }

    public static void fillDiagnalsOrMatrix(int[][] matrix, int[] diagonals, int idx, int i, int j, boolean filledDiagnals) {
        if (idx >= diagonals.length || i >= matrix.length || j >= matrix[0].length) return;
        if (filledDiagnals) {
            diagonals[idx] = matrix[i][j];
            fillDiagnalsOrMatrix(matrix, diagonals, idx + 1, i + 1, j + 1, filledDiagnals);
        } else {
            matrix[i][j] = diagonals[idx];
            fillDiagnalsOrMatrix(matrix, diagonals, idx + 1, i + 1, j+ 1, filledDiagnals);
        }
    }

}
