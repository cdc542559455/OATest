import java.util.LinkedList;
import java.util.List;
//11 给一个数num, 返回这个数每一个digit的乘积: product 和 每一位digit的和: sum的差值

public class digitsProductSum_2 {
    public static void main(String[] args) {
        System.out.print(differenceOfProductAndSum(123));
    }

    public static int differenceOfProductAndSum(int num) {
        num = Math.abs(num);
        List<Integer> digits = new LinkedList<>();
        while (num > 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int product = 1;
        int sum = 0;
        for(int element : digits) {
            product *= element;
            sum += element;
        }
        return product - sum;
    }
}
