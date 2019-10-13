import java.util.Arrays;

public class RotateOverDiagonals_24 {
    public static void main(String[] args) {
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(rotate(test1, 2)));
        int[][] test2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        System.out.println(Arrays.deepToString(rotate(test2, 1)));
    }


    public static int[][] rotate(int[][] matrix, int k) {
        if (matrix == null || matrix.length < 1 || matrix[0].length != matrix.length) return matrix;
        int end = matrix.length - 1;
        for (int i = 0; i <= (end + 1) / 2; i++) {
            for (int j = i; j <= end - 1 - i; j++) {
                if (i == j || end - i == j) continue;
                for(int l = 0; l < k ; l++ ) {
                    rotation(matrix, i, j, end);
                }
            }
        }
        return matrix;
    }

    public static void rotation(int[][] matrix, int i, int j, int end) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[end - j][i];
        matrix[end - j][i] = matrix[end - i][end - j];
        matrix[end - i][end - j] = matrix[j][end - i];
        matrix[j][end - i] = temp;
    }

}
