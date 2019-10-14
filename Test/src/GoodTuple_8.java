//
//1. GoodTuple
//        链接里第一题：Here
//        Give an array and find the count of a pair number and a single number
//        combination in a row of this array. Target array is a[i - 1], a, a[i + 1]
//        Example：
//        Input: a = [1, 1, 2, 1, 5, 3, 2, 3]
//        Output: 3
//        Explain:
//        [1, 1, 2] -> two 1 and one 2(O)
//        [1, 2, 1] -> two 1 and one 2(O)
//        [2, 1, 5] -> one 2, one 1 and one five(X)
//        [1, 5, 3] -> (X)
//        [5, 3, 2] -> (X)
//        [3, 2, 3] -> (O)

public class GoodTuple_8 {
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
