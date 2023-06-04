import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        int[] arr = {8, 81, 48, 53, 46, 70, 98, 42, 27, 76, 33, 24, 2, 76, 62, 89, 90, 5, 13, 21};

        System.out.println(String.valueOf(Arrays.toString(arr)));
        quickSort(arr, 0, arr.length - 1);
        System.out.println(String.valueOf(Arrays.toString(arr)));

    }

    private static void quickSort(int[] array, int start, int end) {

        if (end <= start) return; //base case

        int pivot = partition(array, start, end);
        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j <= end; j++)
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }

        i++;
        swap(array, i, end);

        return i;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}