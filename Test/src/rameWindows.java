public class rameWindows {
    public static void main(String[] args) {
        // n > 3
        System.out.println(print(3));
    }

    private static String print(int n) {
        String res = "";
        for(int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                for(int j = 0; j < n + 2; j++) res+="*";
            } else {
                res+= "*";
                for(int j = 0; j < n; j++) res+= " ";
                res+= "*";
            }
            res+="\n";
        }
        return res;
    }


}