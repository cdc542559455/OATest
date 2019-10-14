import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//4. Cool Feature:
//        链接里第四题：Here
//        最开始有3个case超时，原因是每次执行问加起来等于target的情况有多少种的那个query时，我都是重新算一遍记录b数组每个数出现次数的HashMap，
//        其实只用最开始构好，然后每次做第二种query([index, num])，更新一下HashMap就行。改了就过了。
//        Give three array a, b and query. This one is hard to explain. Just read the example.
//        Input:
//        a = [1, 2, 3]
//        b = [3, 4]
//        query = [[1, 5], [1, 1, 1], [1, 5]]
//        Output:
//        [2, 1]
//        Explain:
//        Just ignore every first element in sub-array in the query.
//        So we will get a new query like this query = [[5], [1, 1], [5]]
//        Only record the result when meet the single number in new query array.
//        And the rule of record is find the sum of the single number.
//        The example above is 5 = 1 + 4 and 5 = 2 + 3, there are two result.
//        So currently the output is [2]
//        When we meet the array length is larger than 1, such as [1, 1]. That means we will replace the b[x] = y, x is the first element, y is second element. So in this example, the b will be modify like this b = [1, 4]
//        And finally, we meet the [5] again. So we will find sum again. This time the result is 5 = 1 + 4.
//        So currently the output is [2, 1]
//        note: Don't have to modify the query array, just ignore the first element.
//        Time:
//        Function findSum is O(a * b)
//        Function modifyArrayb is O(1)
//        Function treverse is O(query)
//        So total maybe O(a * b * query)


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

