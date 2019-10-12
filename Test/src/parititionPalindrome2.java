public class parititionPalindrome2 {
    public static void main(String[] args) {

    }

    private static int minCut(String input) {
        if (input == null || input.length() == 0) return 0;
        int n = input.length();
        int[] min = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for(int i = 0; i < n; i ++) {
            int minTemp = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0; j --) {
                if (input.charAt(i) == input.charAt(j) && (i - j <= 3 || isPalindrome[i+1][j-1])) {
                    isPalindrome[i][j] = true;


                }
            }

        }
        return 0;
    }
}
