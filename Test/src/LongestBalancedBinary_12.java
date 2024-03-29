import java.util.HashMap;
import java.util.Map;

//longestEqualSubarray
//        int fun(int[] a), a 由 1 和 0 组成. 求 0，1个数相同的subarray 最大长度.

public class LongestBalancedBinary_12 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0};
        System.out.println(longestLength(arr));
        System.out.println();
        arr = new int[] {1, 1};
        System.out.println(longestLength(arr));
        System.out.println();
        arr = new int[] {1,1,0,0, 0, 0,0,1,0,1,0,1,0,1,1,1,1,0,0,0,0,1,0};
        System.out.println(longestLength(arr));

    }

    public static int longestLength(int[] arr) {
        int diff = 0;
        Map<Integer, Integer> prefixDiff = new HashMap<>();
        int longest = 0;
        // int left = -1, right = -1;
        prefixDiff.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) diff++;
            else diff--;
            if (prefixDiff.containsKey(diff)) {
                int length = i - prefixDiff.get(diff);
                if (length > longest) {
                    longest = length;
                }

            } else {
                prefixDiff.put(diff, i);
            }

        }

        return longest;
    }
}
