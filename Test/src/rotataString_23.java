// swap string in pair
public class rotataString_23 {

    public static void main(String[] args) {
        System.out.println(rotate("abcdefg"));
    }

    public static String rotate(String input) {
        if (input == null || input.equals("")) return "";
        char[] origin = input.toCharArray();
        for(int i = 0; i < origin.length - 1; i++) {
            if (i % 2 == 0) {
                char temp = origin[i];
                origin[i] = origin[i + 1];
                origin[i+1] = temp;
            }
        }
        return String.valueOf(origin);
    }
}
