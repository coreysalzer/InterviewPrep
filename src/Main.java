public class Main {
    public static void main(String[] args) {
        Integer[] arr = {11, 4, 9, 7, 3, 10, 2, 6, 8};

        QuickSort.run(arr);
//        MergeSort.run(arr);

//        for (Integer a : arr) {
//            System.out.print(a + " "); // 2 3 4 6 7 8 9 10 11
//        }

        System.out.println(BinarySearch.run(arr, 11)); // 8
        System.out.println(BinarySearch.run(arr, 5)); // -1


    }
}