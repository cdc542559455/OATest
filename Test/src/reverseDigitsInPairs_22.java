import java.util.LinkedList;
import java.util.List;
//reverseDigitsInPairs
//        就是把一个integer reverse 成另一个integer, 不用考虑末尾‍‍‌‌‌‍‍‍‍‌‍‍‌‍‌‌‌‍‍是0和溢出

public class reverseDigitsInPairs_22 {
    public static void main(String[] args) {
        System.out.println(reverseInpair(-1));
    }

    public static int reverseInpair(int num) {
        if (num == 0) return 0;
        int abs = Math.abs(num);
        List<Integer> digits = new LinkedList<>();
        while (abs > 0) {
            digits.add(0, abs % 10);
            abs /= 10;
        }
        if (digits.size() == 1) return num < 0 ? 0 - digits.get(0) : digits.get(0);
        int reversed = digits.get(1);
        for(int i = 0; i <  digits.size() ; i++) {
            if (i < digits.size() - 1 && i % 2 == 0) {
                int temp = digits.get(i);
                digits.set(i, digits.get(i + 1));
                digits.set(i + 1, temp);
            }
            if (i == 0) continue;
            reversed = reversed * 10 + digits.get(i);
        }
        return num < 0 ? 0 - reversed : reversed;
    }
}
