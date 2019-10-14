import java.util.LinkedList;
import java.util.List;

//8. 花式数位求和
//        25631 -> 2 - 5 + 6 - 3 +1

public class digitsSum_3 {
    public static void main(String[] args) {
        System.out.println(digitSum(128));
    }

    public static int digitSum(int arr) {
        if (arr  < 0 ) return 0;
        List<Integer>  digits = new LinkedList<>();
        while (arr > 0) {
            digits.add(0, arr % 10);
            arr /= 10;
        }
        int res = 0;
        for(int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                res += digits.get(i);
            } else {
                res -= digits.get(i);
            }
        }
        return res;

    }
}
