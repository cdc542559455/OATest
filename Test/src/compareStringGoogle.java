import java.util.Arrays;
import java.util.Collections;

// https://leetcode.com/discuss/interview-question/352458/Google-or-OA-Fall-Internship-2019-or-Compare-Strings
public class compareStringGoogle {
    public static void main(String[] args) {
        String A = "abcde aaec bbbceeee";
        String B = "aaa aaaa aa";
        System.out.println(Arrays.toString(compareString(A, B)));

    }

    public static int[] compareString (String A, String B) {
        if (A == null || B == null || B.length() == 0) {
            return new int[0];
        }
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        int[] countRecord = new int[11];
        // stores the count of the smallest characters from a
        for (String word : a) {  // O(b letters --> M)
            // checks to avoid requirements
            if (word.length() == 0 || word.length() > 10) {
                continue;
            }
            int count = countMinLetter(word);
            System.out.println(count);
            countRecord[count]++;
        }
        // uses prefix sum to calculate the sum of the previous from here O(11)
        for (int i = 0; i < 11; i++) {
            if (i > 0) {
                countRecord[i] += countRecord[i-1];
            }
        }
        int[] result = new int[b.length];
        for (int i = 0; i < b.length; i++) { // O(b letters --> N)
            String word = b[i];
            int count = countMinLetter(word);
            result[i] = countRecord[count - 1];
        }
        return result;
    }

    private static int countMinLetter (String word) {
        char biggestLetter = 'z';
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            // assumes that only lowercase letters exist
            if (temp < biggestLetter) {
                biggestLetter = temp;
                count = 1;
            } else if (temp == biggestLetter) {
                count++;
            }
        }
        return count;
    }
}
