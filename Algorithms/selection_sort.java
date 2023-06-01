import java.util.Arrays;

public class Main{

    public static void main(String[] args){

        int[] arr = {23, 4,5,23,65,765,1232,1};

        System.out.println(String.valueOf(Arrays.toString(arr)));
        arr = Main.selection(arr);
        System.out.println(String.valueOf(Arrays.toString(arr)));

    }

    public static int[] selection(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            int min = numbers[i];
            int min_index = i;
            for(int j = i+1; j<numbers.length; j++){
                if(numbers[j] < min){
                    min = numbers[j];
                    min_index = j;

                }
            }
            // Swap
            int temp = numbers[i];
            numbers[i] = numbers[min_index];
            numbers[min_index] = temp;
        }
        return numbers;
    }
}