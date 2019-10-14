//
//rameWindow (有点忘记名字了) : Given an int n, print the *** window frame of the number;
//        Example: input -> n = 6
//        output -> [
//        "********", --> 8 *
//        "*           *", -> 2 * 加 六个 ' ' (space)
//        "*           *",
//        "*           *",
//        "*           *",
//        "********"
//        ]
//
//        Input -> n = 3;
//        Output -> [
//        "***“，
//        ”*  *“，
//        ”***
//        ]

public class rameWindows_20 {
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
