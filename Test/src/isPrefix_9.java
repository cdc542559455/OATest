import java.util.HashSet;
import java.util.Set;
//isPrefix，给两个str array a，b，判断b里面的所有str是不是都是a的str各种组合黏在一起而成的
//
//        Sol: 直接建立所有a里面str的permutation然后存入set里

public class isPrefix_9 {
    private static Set<String> s;
    public static void main(String[] args) {
        String[] a = {"one","two", "three"};
        String[] b = {"two"};
        System.out.println(checkPrefix(a, b));
        System.out.println(s);
    }

    public static boolean checkPrefix(String[] a, String[] b) {
        if (a == null ||  b == null ) return false;
        if (a.length == 0 && b.length == 0) return true;
        if (a.length == 0 || b.length == 0) return false;
        s = new HashSet<>();

        permuation(a);
        for(String subelement: b){
            if (!s.contains(subelement)) return false;
        }
        return true;

    }

    public static void permuation(String[] a) {
        String tempRes = "";
        for(int i = 0; i < a.length; i++) {
            tempRes += a[i];
            s.add(tempRes);
        }
    }
}
