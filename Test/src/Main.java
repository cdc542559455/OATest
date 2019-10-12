import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(palindrome(("aabaa")));
    }

    public static int palindrome(String s) {
        // guards input s
        String formattedInput = "@" + s + "#";
        char inputCharArr[] = formattedInput.toCharArray();
        int radius[][] = new int[2][s.length() + 1];
        int max;
        // input
        Set<String> palindromes = new HashSet<>();

        for (int j = 0; j <= 1; j++) {
            radius[j][0] = max = 0;
            int i = 1;
            while (i <= s.length()) {
                palindromes.add(Character.toString(inputCharArr[i]));
                while (inputCharArr[i - max - 1] == inputCharArr[i + j + max])
                    max++;
                radius[j][i] = max;
                int k = 1;
                while ((radius[j][i - k] != max - k) && (k < max)) {
                    radius[j][i + k] = Math.min(radius[j][i - k], max - k);
                    k++;
                }
                max = Math.max(max - k, 0);
                i += k;
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                for (max = radius[j][i]; max > 0; max--) {
                    palindromes.add(s.substring(i - max - 1, max + j + i - 1));
                }
            }
        }

        return palindromes.size();
    }
}
