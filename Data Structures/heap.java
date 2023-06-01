import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap {

    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentID) {
        return 2 * parentID + 1;
    }

    private int getRightChildIndex(int parentID) {
        return 2 * parentID + 2;
    }

    private int getParentIndex(int childID) {
        return (childID - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;

    }

    private void isFull() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int element) {
        isFull();
        items[size] = element;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallest = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) smallest = getRightChildIndex(index);
            if (items[index] < items[smallest]) break;
            else swap(index, smallest);
            index = smallest;
        }
    }

    public void printHeap() {
        if (size == 0) {
            System.out.println("Empty heap");
            return;
        }

        int itemsInLevel = 1;
        int itemsInNextLevel = 0;
        int i = 0;

        while (i < size) {
            // Print all items in the current level
            for (int j = 0; j < itemsInLevel && i < size; j++, i++) {
                System.out.print(items[i] + " ");
                // Each item in the current level contributes 2 items to the next level
                itemsInNextLevel += 2;
            }

            // Move to the next level
            System.out.println();
            itemsInLevel = itemsInNextLevel;
            itemsInNextLevel = 0;
        }
    }


}
