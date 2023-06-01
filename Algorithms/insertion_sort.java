import java.util.Arrays;

public class Main{

    public static void main(String[] args){

        int[] arr = {23, 4,5,23,65,765,1232,1};

        System.out.println(String.valueOf(Arrays.toString(arr)));
        arr = Main.insertion(arr);
        System.out.println(String.valueOf(Arrays.toString(arr)));

    }
    public static int[] insertion(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            int next = numbers[i];
            int j = i;
            while(j > 0 && numbers[j-1] > next){
                numbers[j] = numbers[j-1];
                j--;
            }
            numbers[j] = next;
        }
        return numbers;
    }
}