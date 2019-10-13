import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CoolFeatture_1 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {3,4};
        int[][] query = {{1,5}, {1,1,1}, {1,5}};
        System.out.println(coolFeature(a, b, query));

    }

    public static List<Integer> coolFeature(int[] a, int[] b, int[][] query) {
        List<Integer> res = new LinkedList<>();
        if (a == null || b == null || query == null) return res;

        Map<Integer, Integer> freq = new HashMap<>();
        for(int element : a) {
            freq.put(element, freq.getOrDefault(element, 0) + 1 );
        }

        for(int[] subquery: query) {
            if (subquery.length == 3) {
                b[subquery[1]] = subquery[2];
            } else {
                int target = subquery[1];
                int counter = 0;
                for(int bElement: b) {
                    counter += freq.getOrDefault(target - bElement, 0);
                }
                if (counter != 0) res.add(counter);
            }
        }
        return res;
    }
}

