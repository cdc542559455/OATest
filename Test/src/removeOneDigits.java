public class removeOneDigits {
    public static int result = 0;

    public static void main(String[] args) {
        System.out.println(removeOneDigit("129", "231"));
    }

    public static int removeOneDigit(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        if (a.length > b.length) {
            char[] temp = a;
            a = b;
            b = temp;
        }
        // deleteFromA[i] represents whether the rest part after a[i] is smaller than the corresponding b part, if we delete a[i]
        // deleteFromB[i] represents whether the rest part after a[i] is smaller than the corresponding b part, if we delete b[i]
        boolean[] deleteFromA = new boolean[a.length];
        boolean[] deleteFromB = new boolean[a.length];

        // if we delete the last element of a, a.length < b.length, empty string will always smaller than non-empty string
        deleteFromA[a.length - 1] = true;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i + 1] < b[i]) deleteFromA[i] = true;
            else if (a[i + 1] == b[i]) deleteFromA[i] = deleteFromA[i + 1];
        }

        if (a.length < b.length) deleteFromB[a.length - 1] = A.substring(a.length - 1, a.length).compareTo(B.substring(a.length)) < 0 ? true : false;
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < b[i + 1]) deleteFromB[i] = true;
            else if (a[i] == b[i + 1]) deleteFromB[i] = deleteFromB[i + 1];
        }

        // ************************** Debugging ***************************
//        for (int i = 0; i < a.length; i++) {
//            String testA = A.substring(i + 1);
//            String testB = B.substring(i);
//            if (testA.compareTo(testB) < 0 != deleteFromA[i]) {
//                System.out.println("A, " + i + ": " + testA + ", " + testB);
//            }
//        }
//
//        for (int i = 0; i < a.length; i++) {
//            String testA = "";
//            if (i < a.length) testA = A.substring(i);
//            String testB = B.substring(i + 1);
//            if (testA.compareTo(testB) < 0 != deleteFromB[i]) {
//                System.out.println("B, " + i + ": " + testA + ", " + testB);
//            }
//        }
        // ************************* Debugging ***************************

        boolean equal = true;
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            char ca = a[i];
            char cb = b[i];

            if (ca >= '0' && ca <= '9') {
                if (!equal || deleteFromA[i]) {
                    result++;
                    // ************************* Debugging ***************************
//                    String testA = A.substring(0, i);
//                    if (i + 1 < a.length) testA += A.substring(i + 1);
//                    System.out.println("delete A " + i + ": " + (testA.compareTo(B) < 0) + ": " + testA + ", " + B);
                    // ************************* Debugging ***************************
                }
            }
            if (cb >= '0' && cb <= '9') {
                if (!equal || deleteFromB[i]) {
                    result++;
                    // ************************* Debugging ***************************
//                    String testB = B.substring(0, i);
//                    if (i + 1 < b.length) testB += B.substring(i + 1);
//                    System.out.println("delete B " + i + ": " + (A.compareTo(testB) < 0) + ": " + A + ", " + testB);
                    // ************************* Debugging ***************************
                }
            }

            if (equal) {
                if (ca > cb) return result;
                if (ca < cb) equal = false;
            }
        }

        return result + countLeftDigit(b, a.length, equal);
    }

    private static int countLeftDigit(char[] b, int start, boolean equal) {
        if (equal && b.length - 1 <= start) return 0;
        int count = 0;
        for (int i = start; i < b.length; i++) {
            if (b[i] >= '0' && b[i] <= '9') count++;
        }
        return count;
    }

}
