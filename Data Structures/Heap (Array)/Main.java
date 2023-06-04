import java.util.Random;

public class Main{


    public static void main(String[] args){
        MinHeap minHeap = new MinHeap();
        Random r = new Random();
        for(int i = 0; i< 10; i++)
            minHeap.addElement(r.nextInt(50));
        for(int i = 0; i < 10; i++)
            System.out.println(minHeap.pop());
    }

}