import java.util.HashMap;
import java.util.Map;

public class DivideArray {
    public static void main(String[] args) {
        System.out.println(dividEqual(new int[] {1,2,2,3,3,5}));
    }

    public static boolean dividEqual(int[] arr) {
        if (arr == null || arr.length % 2 == 1) return false;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int element : arr) {
            int res = freq.getOrDefault(element, 0);
            res ++;
            if (res > 2) return false;
            freq.put(element, res);
        }
        return true;
     }
}
