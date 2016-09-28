/**
 * Best Case:               Omega(1)
 * Average Case:            Sigma(logn)
 * Worst Case:              O(logn)
 * Memory Efficiency:       Sigma(1)
 */
public class BinarySearch {
    /**
     * @param A Sorted Array of Integers
     * @param x Value for which index in array is found
     */
    public static int run(Integer[] A, Integer x) {
        return binarySearch(A, x);
    }

    private static int binarySearch(Integer[] A, Integer x) {
        int high = A.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(x < A[mid]) high = mid - 1;
            else if(x > A[mid]) low = mid + 1;
            else return mid;
        }

        return -1;
    }
}
