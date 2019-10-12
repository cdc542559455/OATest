import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatrixQueries {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,2};
        int[][] maxtrix = { {1,2,1}, {2,4,2}, {0,3,1}
            };
        System.out.println(matrixQueue(arr, maxtrix));
    }


    public static int matrixQueue(int[] arr, int[][] matrix) {
        if (arr == null || arr.length == 0 ||
                matrix == null || matrix.length == 0 || matrix[0].length != 3) return 0;
        int res = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            Set<Integer> set = map.getOrDefault(arr[i], new HashSet<>());
            set.add(i);
            map.put(arr[i], set);
        }
        for(int[] row : matrix) {
            if (map.containsKey(row[2])) {
                Set<Integer> set = map.get(row[2]);
                for(int element : set) {
                    if (element > row[1]) break;
                    if (element >= row[0] && element <= row[1]) res ++;
                }
            }
        }
        return res;
    }
}
