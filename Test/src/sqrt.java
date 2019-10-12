import java.math.BigDecimal;
import java.math.RoundingMode;

public class sqrt {
    public static void main(String[] args) {
        sqrt(2,3);
        System.out.println(sqrt2(13,12));
        System.out.println("sqrt 3: "+ sqrt3(2));
        System.out.println("sqrt 4: " +sqrt4(2));
    }
    public static void sqrt(int x, int p) {
        if (x <= 0) return ;
        double i = x;

        while (i > x / i) {
            i = (i + x/ i) / 2.0;
        }
        System.out.printf("%."+p+"f",i);

    }

    public static double sqrt2(int x, int p) {
        if (x <= 0 || p <= 0) return 0;
        double i = x * 1.0;
        double pre;
        while( i > x /i) {
            pre = i;
            System.out.println("i :" + i);
            i = (i + x / i) / 2.0;
            if (pre == i) break;

        }

        i = BigDecimal.valueOf(i).setScale(p, RoundingMode.HALF_UP).doubleValue();
        return i;

    }

    public static int sqrt3(int x) {
        if (x <= 0) return 0;
        int low = 1, high = x;
        while (low < high) {
            int mid = (high + low)/ 2;
            if (mid  <= x / mid  && (mid + 1) > x/ (mid + 1)) return mid;
            if (mid < x / mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int sqrt4(int x) {
        if (x <= 0) return 0;
        for(int i = 1; i < x ; i++) {
            if (i <= x / i && (i+1) > x / (i+1)) return i;
        }
        return -1;
    }


}
