import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


//Question 3: divisorSu‍‍‌‌‍‍‍‌‌‍‍‌‍‍‍‍‌‍‌bStrings
//
//        16. 之前面经也出现过。compare两个string，只有小写字母。 每个stirng内部可以任意换位置，所以位置不重要。
//        每个string内部两个letter出现的频率也可以互换，所以这题只需要两个string每个frequency出现的次数要一样。
//        比如“babzccc” 和 “bbazzcz” 就返回“true”，因为z和c可以互换频率。
//        但是“babzcccm” 和 “bbazzczl” 就不一样，因为m在第一个里出现过，第二个里没有出现过。
//        Given two rules to define two strings are close enough.
//        1. you can swap neighbor char any times. Ex. "abb" -> "bba"
//        2. If two strings have the same character, then you can change the character into another.
//        Ex. If both strings contain "a" and "b", you can change all "a"s in the first string or change all "b"s in the first string. same as the second string
//
//        Ex.
//        Input: S1 = "babzccc", S2 = "abbzczz"
//        Output: True

public class DivisorSubStrings_6 {
    public static void main(String[] args) {
        System.out.println(compare("babzccc", "abbzczz"));
        System.out.println(compare("babzcccm", "bbazzczl"));
    }

    public static boolean compare(String a, String b) {


        if (a == null && b == null) return true;

        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;


        int[] afreq = new int[26];
        int[] bfreq = new int[26];

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        for(int i = 0; i < aArray.length; i++) {
            afreq[aArray[i] - 'a'] ++;
            bfreq[bArray[i] - 'a'] ++;
        }


        for(int i = 0; i < afreq.length; i++) {
            if (afreq[i] == 0 && bfreq[i] == 0) continue;
            if (afreq[i] > 0 && bfreq[i] > 0) continue;
            return false;
        }
//        System.out.println("happend");
        for(int i = 0; i < afreq.length; i++) {
            if (afreq[i] == 0) continue;
            boolean found = false;
            int curFreq = afreq[i];
            for(int j = 0; j < bfreq.length; j++) {
                if(curFreq == bfreq[j]) {
                    found = true;
                    bfreq[j] = 0;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

}
