public class MaxRibbon {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        System.out.println(maxRibbon(arr, 5));
    }

    public static int maxRibbon(int[] ribbons, int k) {
        int low = 1, high = 1, sum = 0;
        for (int num : ribbons) {
            sum += num;
            if (num > high) high = num;
        }
        high++;

        if (sum < k) return 0;
        if (sum == k) return 1;

        int result = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int num = 0;
            for (int length : ribbons) {
                num += length / mid;
            }
            if (num >= k) {
                result = Math.max(result, mid);
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return result;
    }
}
