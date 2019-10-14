import java.util.HashMap;
import java.util.Map;
//3. Divide Array into two with equal size, make sure every element in each two array is unique. return empty list if impossible.
//        先sort再分配，连续超过2，就不能满足了
//        我是一个HashMap记录原数组每个数出现次数，如果有某个超过2的话，就不可能满足要求直接返回空；
//        如果出现次数都是2或以下的话，就对出现两次的平分到两个数组，剩下只出现一次的随便分给两个数组就行只要保障最后两个数组长度一致。

public class DivideArray_4 {
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
