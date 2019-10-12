public class cse331hw21 {

    public static int max(int[]items) {
        // precondition : {items.size() > 0}
        int max = items[0];
        int k = 0;
        // inv : {max = largest in items[0...k]}
        while(k + 1 !=  items.length) {
            // inv holds
            if (items[k+1] > max) {
                max = items[k+1]; // break inv temporarily
            }
            // max holds largest value in items[0..k]
            k = k + 1; // inv holds again
        }
        // post-condition: { k == items.length() - 1
        // & max = largest value in items[0...items.length() - 1]}
        return max;
    }

    public static void rearrage(int[] A) {
        // precondition : A.length() > 0
        int back = A.length - 1;
        int i = 1;
        // inv : {A[1...(i-1)] <= A[0] & A[0] < A[back + 1...A.length - 1]}
        while(i < back) {
            // inv holds
            if (A[i] > A[0]) swap(A[i], A[back--]);
            //since back come down from A.length - 1 then {A[0] < A[back + 1...A.length - 1]} holds
            // back is decreasing and i doesn't change then {A[1...(i-1)] <= A[0]} holds
            else i++;
            // since i increase from 1 then {A[1...(i-1)] <= A[0]} holds
            // back doesn't change then {A[back + 1...A.length - 1]} also holds

        }
        // {i = back & A[1...(i-1)] <= A[0] & A[0] < A[back + 1...A.length - 1]}
        // but we don't know A[i] is greater or lesser than A[0]
        if (A[i] > A[0]) swap(A[0], A[i]);
        else swap(A[0], A[i-1]);
        // post-condition1: {i = back & A[1...(i-1)] <= A[0] & A[0] < A[back ...A.length - 1]} or
        // post-condition2: {i = back & A[1...(i)] <= A[0] & A[0] < A[back+1 ...A.length - 1]}
    }

    private static void swap(int a, int b) {
    }

    public static void selectSort(int[] a) {
        // precondition: a.length() >  0
        int i = 0;
        // inv outer loop : {i > 0 & a[0...i-1] sorted in the ascending order}
        while (i < a.length - 1) {
            //outer inv hold
            int min = a[i];
            int j = i + 1;
            // inner loop inv: {j > i & min = min(A[i+1... j - 1])}
            while (j < a.length) {
                // inner inv holds
                min = Math.min(min, a[j++]);
                // j increases
            }
            // inner post-condition { j = a.length & min = min(A[i... j - 1])} a
            swap(min, a[i++]);
            // swap will end up a[i] being smallest element in [i...a.length - 1]
            // and i increases
        }
        //outer post-condition:
        // {i == a.length & i > 0 & a[0...i-1] sorted in the ascending order}
    }

}
