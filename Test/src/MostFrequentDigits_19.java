import java.util.*;

//5. most Frequent Digits
//        出现频率最高的数字
//        Input: A = [22, 2, 3, 33, 5]
//        Output: [2, 3]
//        开始有一个case过不了，后来重新初始化了一下dictionary， 可能是A=[]的情况

public class MostFrequentDigits_19 {
    public static void main(String[] args) {
        System.out.println(topFrequent(new int[] {22, 2, 3, 33, 555}));
        System.out.println(topFrequent(new int[] {1,1,2,3,4,4}));
    }

    public static List<Integer> topFrequent(int[] arr) {
        List<Integer> res = new LinkedList<>();
        if (arr == null || arr.length == 0) return res;
        Map<Integer, Integer> freqs = new HashMap<>();

        for (int element : arr) {
            //freqs.put(element, freqs.getOrDefault(element, 0) + 1);
            while (element > 0 ) {
                int digit = element % 10;
                freqs.put(digit, freqs.getOrDefault(digit, 0) + 1);
                element /= 10;
            }
        }

        List<Integer>[] bucket = new LinkedList[arr.length + 1];

        for(int key : freqs.keySet()) {
            int freq = freqs.get(key);
            if (bucket[freq] == null) bucket[freq] = new LinkedList<>();
            bucket[freq].add(key);
        }

        for(int i = arr.length - 1; i >= 0; i --) {
            if (bucket[i] != null) return bucket[i];
        }
        Collections.sort(res);
        return res;
    }
}
