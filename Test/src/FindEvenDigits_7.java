
//Find how many numbers have even digit in a list.
//        Ex.Input: A = [12, 3, 5, 3456]
//        Output: 2


public class FindEvenDigits_7 {
    public static void main(String[] args) {
        System.out.println(findEvenDigits(new int[] {12, 3, 5, 3456}));
    }

    public static int findEvenDigits(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int res = 0;
        for(int num : arr) {
            if (digitsCount(num) % 2 == 0) res++;
        }
        return res;
    }

    public static int digitsCount(int num) {
        if (num == 0) return 1;
        num = Math.abs(num);
        int len = 0;
        while (num > 0) {
            len += 1;
            num /= 10;
        }
        return len;
    }
}
