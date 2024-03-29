import java.util.Arrays;


public class Main {

    public static void main(String[] args) {

        int[] arr = {23, 4, 5, 23, 65, 765, 1232, 1};

        System.out.println(String.valueOf(Arrays.toString(arr)));
        merge(arr);
        System.out.println(String.valueOf(Arrays.toString(arr)));

    }

    public static void merge(int[] numbers) {
        if (numbers.length <= 1)
            return;
        
        //Dividing and filling the Array
        int[] left = new int[numbers.length / 2];
        int[] right = new int[numbers.length - left.length];
        for (int i = 0; i < left.length; i++)
            left[i] = numbers[i];

        for (int i = 0; i < right.length; i++)
            right[i] = numbers[left.length + i];

        merge(left);
        merge(right);
        mergeSort(left, right, numbers);

    }

    public static void mergeSort(int[] leftArray, int[] rightArray, int[] numbers) {
        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                numbers[i] = leftArray[leftIndex];
                i++;
                leftIndex++;
            } else {
                numbers[i] = rightArray[rightIndex];
                i++;
                rightIndex++;
            }
        }

        while (leftIndex < leftArray.length) {
            numbers[i] = leftArray[leftIndex];
            i++;
            leftIndex++;
        }

        while (rightIndex < rightArray.length) {
            numbers[i] = rightArray[rightIndex];
            i++;
            rightIndex++;
        }


    }
}
