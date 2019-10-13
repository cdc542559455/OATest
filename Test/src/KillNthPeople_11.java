import java.util.Arrays;

public class KillNthPeople_11 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};

        System.out.println(Arrays.toString(killKth(arr, 5)));
    }

    public static int[] killKth(int[] arr, int k) {
        int[] result = new int[arr.length];
        int alive = arr.length;
        boolean[] killed = new boolean[arr.length];
        int i = 0, ct = 0, idx = 0;
        while (alive > 0) {
            if (i == arr.length) {
                int position = (k - ct) % alive;
                int temp = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (!killed[j]) {
                        temp++;
                        // temp == alive is the case where position is 0: because position = (k - ct) % alive. if (k - ct) == alive, we should kill the last man
                        if (temp == position || temp == alive) {
                            killed[j] = true;
                            alive--;
                            result[idx++] = arr[j];
                            i = (j + 1) % arr.length;
                            ct = 0;
                            break;
                        }
                    }

                }
            }
            if (i >= arr.length) {
                System.out.println("wtf");
                return result;
            }

            if (!killed[i]) ct++;
            if (ct == k) {
                killed[i] = true;
                alive--;
                result[idx++] = arr[i];
                ct = 0;
            }
            i++;
        }
        return result;
    }


}
