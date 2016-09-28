/**
 * Best Case:               Omega(nlogn)
 * Average Case:            Sigma(nlogn)
 * Worst Case:              O(nlogn)
 * Memory Efficiency:       Sigma(n)
 * Stability:               Stable
 */
public class MergeSort {
    public static void run(Integer[] A) {
        mergeSort(A);
    }

    public static void mergeSort(Integer[] A) {
        if (A.length > 1) {
            int ls = A.length / 2;
            int rs = A.length - ls;

            Integer[] left = new Integer[ls];
            Integer[] right = new Integer[rs];
            System.arraycopy(A, 0, left, 0, ls);
            System.arraycopy(A, ls, right, 0, rs);

            mergeSort(left);
            mergeSort(right);
            merge(A, left, right);
        }
    }

    static void merge(Integer[] result, Integer[] left, Integer[] right) {
        int l = 0;
        int r = 0;

        for (int i = 0; i < result.length; i++) {
            if (r >= right.length || (l< left.length && left[l] <= right[r])) {
                result[i] = left[l];
                l++;
            } else {
                result[i] = right[r];
                r++;
            }
        }

    }
}
