public class MergeSort {
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n > 1) {
            // Find the mid index
            int mid = n / 2;

            // Create two subarrays
            int[] leftArray = new int[mid];
            int[] rightArray = new int[n - mid];

            /*Copy data to temp arrays*/
            System.arraycopy(arr, 0, leftArray, 0, mid);
            System.arraycopy(arr, mid, rightArray, 0, n - mid);

            // Recursively sort both halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(arr, leftArray, rightArray, mid, n - mid);
        }
    }

    public static void merge(int[] arr, int[] leftArray, int[] rightArray, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy the remaining elements of left[], if there are any
        while (i < left)
            arr[k++] = leftArray[i++];

        // Copy the remaining elements of right[], if there are any
        while (j < right)
            arr[k++] = rightArray[j++];
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        mergeSort(arr);

        System.out.println("Sorted array");
        printArray(arr);
    }
}