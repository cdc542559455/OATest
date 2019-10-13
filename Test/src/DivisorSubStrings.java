import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DivisorSubStrings {
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
