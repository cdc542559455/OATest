import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//10.Keyboard: input: String, char[] array; output int返回可以输出的字符串个数
//        这道题我看之前各位的面经一直对什么地方该split什么地方不该感到困惑，结果还是让我遇到了，仔细看题之后发现只需要按照空格分就行了，
//        broken keyboard 键盘的部分英文字母键坏了（注意只有字母键坏了） 给定一个String 和 一个char Array（没坏的字母键），输出String中能打出的字符串数。
//        栗子：
//        input “hello, world!” ['i','e','o','l','h']; output: 1 (只能打出 hello 这个单词）
//        input “5 + 3 = 8” []; output: 5 (没有英文字母， 5， +， 3， =， 8 都可以打出）
//        之前面经有过的题。输入一组words和一组valid letters，
//        判断有多少个words是valid。判断条件是words里的所有upper and lower letter必须在valid letters里面。
//        如果word里面有special character不用管。注意valid letter只有小写，但是words里面有大写的也算valid。比如words = [hEllo##, This^^],
//        valid letter = [h, e, l, 0, t, h, s]; "hello##" 就是valid，因为h，e，l，o都在valid letter 里面， “This^^” 不valid, 因为i不在valid letter里面

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
