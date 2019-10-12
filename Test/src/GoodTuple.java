public class GoodTuple {
    public static void main(String[] args) {
        System.out.println(goodTuple(new int[]{1, 1, 2, 1, 5, 3, 2, 3}));
    }

    public static int goodTuple(int[] input) {
        if (input == null || input.length <= 2) return 0;
        int res = 0;
        for(int i = 2; i < input.length; i ++) {
            if ((input[i] == input[i - 1] && input[i] != input[i-2])
                    || (input[i] == input[i-2] && input[i] != input[i-1]
                    || (input[i-1] == input[i - 2]) && input[i-1] != input[i])) {
                res ++;
            }
        }
        return res;
    }
}
