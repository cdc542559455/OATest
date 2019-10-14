import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//7. matrixQueries
//        给一个array和一个matrix。
//        matrix里面每一个vector<int>的形式必定是[l,r,target]，固定只有3个数。
//        然后要求统计array里 index从l 到 r这个区间出现了多少次target这个数。
//        比如：
//        array = [1,1,2,3,2]
//        matrix = [[1,2,1],
//        [2,4,2],
//        [0,3,1]]
//        output : 5
//
//        因为在matrix[0],  array的index 1到2区‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌间出现了1 一次，
//        matrix[1], array的index 2到4区间出现2 两次。
//        matrx[2], array的index 0到3区间出现1 两次
//
//        这个题如果直接暴力解O(n*n)会有两个test case过不了。我是用hashmap<int, vector<pair<int,int>>>。 key是target， value是index区间。
//        这样走一遍array，每次确定一下当前index在不在区间里就行了。
//        1， [[1,2],[0,1]]
//        2,  [[2,4]]
//
//        然后loop一遍array,
//        i =0, arr = 1,      然后这个时候判断map.containKey(arr)，然后走一遍key里的value，因为 0 <= i <= 1，所以output++;

public class MatrixQueries_13 {
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
