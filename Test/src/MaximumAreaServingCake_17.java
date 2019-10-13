import java.util.Arrays;

// Google | OA 2019 | Maximum Area Serving Cake
// https://leetcode.com/discuss/interview-question/348510
public class MaximumAreaServingCake_17 {
    public static void main(String[] args) {
        int[] A = new int[] {0, 0};
        System.out.println(findTheMaxCake(A, 10));

    }

    private static double findTheMaxCake(int[] cakes, int count) {
        if (cakes == null || cakes.length == 0 || count == 0) {
            return 0.0;
        }
        double[][] dp = new double[cakes.length+1][count+1];
        for (int i = 1; i <= cakes.length; i++) {
            double cakeSize = Math.PI * cakes[i-1] * cakes[i-1];
            for (int j = 1; j <= count; j++) {
                double optimalsize = 0;
                for (int z = 1; z < j; z++) {
                    optimalsize = Math.max(Math.min(cakeSize/ (j-z), dp[i-1][z]), optimalsize);
                }
                dp[i][j] = Math.max(Math.max(cakeSize/j, optimalsize), dp[i-1][j]);
            }
        }
        return dp[cakes.length][count];
    }
}
