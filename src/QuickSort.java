/**
 * Best Case:               Omega(n)
 * Average Case:            Sigma(nlogn)
 * Worst Case:              O(n^2)
 * Memory Efficiency:       Sigma(logn), O(n)
 * Stability:               Not stable (typical in-place methods)
 */
public class QuickSort {
    public static void run(Integer[] A) {
        quickSort(A, 0, A.length - 1);
        randomizedQuickSort(A, 0, A.length - 1);
    }

    /**
     * Typical quick sort algorithm, worst case occurs when array is already sorted
     */
    public static void quickSort(Integer[] A, int p, int r) {
        if (p < r) {
            int z = partition(A, p, r);
            quickSort(A, p, z - 1);
            quickSort(A, z + 1, r);
        }
    }

    /**
     * Reduces occurrence of worst case scenario (already sorted array)
     */
    public static void randomizedQuickSort(Integer[] A, int p, int r) {
        if (p < r) {
            int x = p + (int)(Math.random() * (r - p));
            swap(A, x, r);
            int z = partition(A, p, r);
            quickSort(A, p, z - 1);
            quickSort(A, z + 1, r);
        }
    }

    /**
     * Sigma(n)
     * @return index of partition element
     */
    static int partition(Integer[] A, int p, int r) {
        int i = p - 1;
        int j = p - 1;
        do {
            j++;
            if (A[j] <= A[r]) {
                i++;
                swap(A, i, j);
            }

        } while (j < r - 1);

        swap(A, i + 1, r);
        return i + 1;
    }

    static void swap(Integer[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
