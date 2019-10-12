public class Dominos {
    public static void main(String[] args) {

    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            throw new IllegalArgumentException();
        }

        // check if A[0] can be first compoenents
        int res = swapCount(A, B);

        // check if B[0] can be first compoenents
        res = res == -1 ? swapCount(B, A) : res;
        return res;
    }

    public int swapCount(int[] A, int[] B) {

        // check if either A[i] or B[i] is one of A[0]
        for(int i = 0, a = 0, b = 0; i < A.length && (A[i] == A[0] || B[i] == A[0]); i++) {
            // swap to array A
            if (A[i] != A[0]) a ++;
            // swap to array B
            if (B[i] != A[0]) b ++;
            // last comparison
            if ( i == A.length - 1) return Math.min(a, b);
        }

        return -1;
    }
}
