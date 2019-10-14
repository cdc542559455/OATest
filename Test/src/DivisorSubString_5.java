import java.util.LinkedList;
import java.util.List;

//14 divisorSubstrings   给一个数字, 和一个 k 值(表示除数位数), 看能用多少个sub number整除
//        ex: n = 1220  k = 2 => 1220 % 12 != 0, 1220 % 22 != 0, 1220 % 20 == 0 => ans : 1


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
