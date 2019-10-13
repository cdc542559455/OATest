import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Keyboard_10 {
    public static void main(String[] args) {
        System.out.println(keyboard("hello, world!", new char[] {'i','e','o','l','h'}));
        System.out.println(keyboard("5 + 3 = 8", new char[] {}));
    }

    public static int keyboard(String input, char[] array) {
        if (input == null || input.equals("")) return 9;
        String[] words = input.split(" ");
        Set<Character> set = new HashSet<>();
        for(char c : array) set.add(c);
        int res = 0;
        for(String word : words) {
            boolean valid = true;
            for(char c : word.toCharArray()) {
                char lower = Character.toLowerCase(c);
                if (!set.contains(lower) && lower >= 97 && lower <= 122) {
                    valid = false;
                    break;
                }
            }
            if (valid) res ++;
        }
        return res;
    }
}
