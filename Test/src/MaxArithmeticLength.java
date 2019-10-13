import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaxArithmeticLength {
    public static void main(String[] args) {
        int[] arr1 = {0, 4, 8, 16};
        int[] arr2 = {0, 2, 6, 12, 14, 20};
        System.out.println(maxArithmeticLength(arr1, arr2));
    }

    public static int maxArithmeticLength(int[] arr1, int[] arr2) {
        // special case 1: arr1 is empty
        if (arr1 == null || arr1.length < 1) {
            return longestArithmeticLength(arr2);
        }
        // special case 2: arr2 is empty;
        if (arr2 == null || arr2.length < 1) {
            if (arr1.length < 2) return arr1.length;
            return testDifference(arr1, new HashSet<Integer>(), arr1[1] - arr1[0]);
        }

        Set<Integer> set = new HashSet<>();
        for (int num2 : arr2) {
            set.add(num2);
        }

        // both arrays are non-empty
        int result = -1, maxDiff = -1;
        if (arr1.length > 1) {
            maxDiff = arr1[1] - arr1[0];
            for (int i = 2; i < arr1.length; i++) {
                maxDiff = gcd(maxDiff, arr1[i] - arr1[i - 1]);
            }
            result = testDifference(arr1, set, maxDiff);
        }
        int num1 = arr1[0];
        int resultSame = 0;
        for (int num2 : arr2) {
            int diff = Math.abs(num2 - num1);
            if (diff == 0) {
                // it might be the case where the difference is 0 (i.e., all numbers are the same)
                if (maxDiff == 0) resultSame++;
                continue;
            }
            if (maxDiff == -1 ||  maxDiff % diff == 0) {
                int temp = testDifference(arr1, set, diff);
                if (temp > result) result = temp;
            }
        }

        if (result != -1) {
            return result;
        } else {
            return resultSame == 0 ? -1 : resultSame;
        }
    }

    private static int testDifference(int[] arr, Set<Integer> set, int diff) {
        int addition = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int val = arr[i];
            int next = val + diff;
            while (arr[i + 1] != next) {
                if (!set.contains(next)) return -1;
                val = next;
                next = val + diff;
                addition++;
            }
        }

        // count values before arr[0]
        int next = arr[0] - diff;
        while (set.contains(next)) {
            addition++;
            next = next - diff;
        }

        // count values after arr[arr.length - 1]
        next = arr[arr.length - 1] + diff;
        while (set.contains(next)) {
            addition++;
            next = next + diff;
        }
        return arr.length + addition;
    }

    // similar to leetcode longest Arithmetic Length
    private static int longestArithmeticLength(int[] A) {
        if (A == null) return 0;
        if (A.length < 2) return A.length;

        // dp[i].get(difference) is the length of the longest arithmetic sequence with that difference
        HashMap<Integer, Integer>[] dp = new HashMap[A.length];
        int result = 2;

        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int start = 0; start < i; start++) {
                int diff = A[i] - A[start];
                int length = dp[start].getOrDefault(diff, 1) + 1;
                result = Math.max(result, length);
                dp[i].put(diff, length);
            }
        }

        return result;
    }

    // return the greatest common divisor
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
