import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortArrayElements_25 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{3,3,4,9},{6,7,3,10}};
        sortElement(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    public static void sortElement(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length != matrix.length) return;

        int n = matrix.length;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                freq.put(matrix[i][j], freq.getOrDefault(matrix[i][j], 0) + 1);

        Map.Entry<Integer, Integer>[] arr = new Map.Entry[freq.size()];
        int size = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            arr[size++] = entry;
        }
        Arrays.sort(arr, (a, b) -> a.getValue() - b.getValue() == 0 ? a.getKey() - b.getKey() : a.getValue() - b.getValue());


        int i = 0;
        int val = arr[i].getKey();
        int ct = arr[i++].getValue();
        for (int cStart = n - 1; cStart >= 0; cStart--) {
            int c = cStart;
            int r = n - 1;
            while (c < n) {
                if (ct == 0) {
                    val = arr[i].getKey();
                    ct = arr[i].getValue();
                    i++;
                }
                matrix[r][c] = val;
                ct--;
                c++;
                r--;
            }
        }

        for (int rStart = n - 2; rStart >= 0; rStart--) {
            int r = rStart;
            int c = 0;
            while (r >= 0) {
                if (ct == 0) {
                    val = arr[i].getKey();
                    ct = arr[i].getValue();
                    i++;
                }
                matrix[r][c] = val;
                ct--;
                c++;
                r--;
            }
        }
    }
}
