import java.util.LinkedList;
import java.util.List;

public class DivisorSubString_5 {
    public static void main(String[] args) {
        System.out.println(divisorSubStrings(1220, 2));
    }

    public static int divisorSubStrings(int num, int k) {
        List<Integer> digits = new LinkedList<>();
        int tempNum = Math.abs(num);
        while (tempNum > 0) {
            digits.add(0, tempNum % 10);
            tempNum /= 10;
        }

        int res = 0;
        if (digits.size() < k) return 0;

        for(int i = 0; i < digits.size() - k + 1; i++) {
            int divisor = digits.get(i);
            for(int j = i + 1; j < i + k; j++) {
                divisor = divisor * 10 + digits.get(j);
            }
            if (num % divisor == 0) res ++;
        }


        return res;
    }
}
