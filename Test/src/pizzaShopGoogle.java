import java.util.*;

public class pizzaShopGoogle {
    public static void main(String[] args) {
        int[] pizza1 = new int[]{800, 850, 900};
        int[] topping1 = new int[]{100, 150};
        System.out.println(countPizzas(pizza1, topping1, 1000));
        int[] pizza2 = new int[]{850, 900};
        int[] topping2 = new int[]{200, 250};
        System.out.println(countPizzas(pizza2, topping2, 1000));
        int[] pizza3 = new int[]{1100, 900};
        int[] topping3 = new int[]{200};
        System.out.println(countPizzas(pizza3, topping3, 1000));
        int[] pizza4 = new int[]{800, 800, 800, 800};
        int[] topping4 = new int[]{100};
        System.out.println(countPizzas(pizza4, topping4, 1000));

    }
    private static int countPizzas (int[] pizzas, int[] toppings, int x) {
        TreeSet<Integer> toppingSum = new TreeSet<>();
        dfs(toppings, 0, 0, toppingSum, 2);
        int minvalue = pizzas[0];
        int diff = Math.abs(x - minvalue);
        for (int pizza : pizzas) {
            Integer value = toppingSum.ceiling((Integer) x-pizza);
            if (value != null) {
                System.out.println(pizza + ":" + value);
                int cursum = value + pizza;
                int abs = Math.abs(x - cursum);
                if (abs < diff || (abs == diff && cursum < minvalue)) {
                    diff = abs;
                    minvalue = cursum;
                }
            }
            Integer value2 = toppingSum.floor((Integer) x-pizza);
            if (value2 != null) {
                System.out.println(pizza + ":" + value);
                int cursum = value2 + pizza;
                int abs = Math.abs(x - cursum);
                if (abs < diff || (abs == diff && cursum < minvalue)) {
                    diff = abs;
                    minvalue = cursum;
                }
            }
        }
        return minvalue;
    }

    private static void dfs (int[] array, int sum, int index, Set<Integer> sums, int size) {
        sums.add(sum);
        if (index >= array.length || size == 0) {
            return;
        }
        for (int i = index; i < array.length; i++) {
            dfs(array, sum + array[i], i + 1, sums, size-1);
        }
    }
}
