import java.util.Arrays;

public class Plants {
    public static void main(String[] args) {



        int[] flower1 = new int[]{2, 4, 5, 1, 2};//17p

        int[] flower2 = {1,1,1,1,1};
        int[] flower3 = {6,6,6,6};
        //int[] flower3 = {2, 4, 5, 1, 2, };

//        System.out.println();
//        System.out.println(CountSteps(flower1, 6));
//        System.out.println(CountSteps(flower2, 6));
//        System.out.println(CountSteps(flower3, 6));
        //System.out.println(CountSteps(flower3, 6));
        String s = "id=14&amount=800&currency=USD";
        String[] ok = s.split("&");
        Arrays.sort(ok);
        for (String n : ok) {
            System.out.println(n);
        }
    }

    public static int CountSteps(int[] flowers, int cap) {
        if (flowers == null || flowers.length == 0) {
            return 0;
        }
        // defines the amount of water in initial bucket
        int bucket = cap;
        int step = 0;
        for (int i = 0; i < flowers.length; i++) {
            int water = flowers[i];
            // when plants could not be watered by requirement so invalid input
            if (water > cap) {
                return -1;
            }
            // determines when need to refill
            if (water > bucket) {
                step += 2 * i;
                bucket = cap;
            }
            bucket -= water;
            step++;
        }
        return step;
    }


}
