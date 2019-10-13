public class SumOfString_27 {
    public static void main(String[] args) {
        System.out.println(sumOfString("99","99"));
    }

    public static String sumOfString(String a, String b) {
        if (a == null && b == null) return "";
        if (a == null) return b;
        if (b == null) return a;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 && j >= 0) {
            int res = (a.charAt(i--) - '0') + (b.charAt(j--) - '0');
            sb.insert(0, res);
        }
        while (i >= 0) sb.insert(0, a.charAt(i--));
        while (j >= 0) sb.insert(0, b.charAt(j--));
        return sb.toString();
    }
}
