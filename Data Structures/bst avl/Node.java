public class Node<T> {
    int key;
    int height;
    Node<T> left, right;

    public Node(int item) {
        key = item;
        height = 1;
        left = right = null;
    }
}