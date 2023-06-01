import java.util.*;

public class Node<T> {

    public T item;
    public Node<T> right;
    public Node<T> left;

    public Node(){}
    public Node(T item){
        this.item = item;
    }
    public Node(T item, Node<T> right, Node<T> left){
        this(item);
        this.right = right;
        this.left = left;
    }

    public static void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.item);
        inOrder(node.right);
    }

    public static void preOrder(Node node){
        if(node == null)
            return;
        System.out.println(node.item);
        inOrder(node.left);
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.item);
    }

    public static boolean isFullBinaryTree(Node node){
        if (node == null)
            return true;

        if(node.left == null && node.right == null)
            return true;

        if(node.left != null && node.right != null)
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);


        return false;
    }

    public static int depth(Node node){
        if(node == null)
            return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        return 1 + Math.max(left, right);
    }
    public static boolean isBalanced(Node node){
        if(node == null)
            return true;

        int leftHeight = depth(node.left);
        int rightHeight = depth(node.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right);

    }


    public static boolean isPerfect(Node node, int d, int level){
        if(node == null)
            return true;

        if(node.left == null && node.right == null)
            return (level+1) == d;

        if(node.left == null || node.right == null)
            return false;

        return isPerfect(node.left, d, level + 1) && isPerfect(node.right, d, level+1);



    }
    public static int coutNodes(Node node){
        if(node == null)
            return 0;
        return 1 + coutNodes(node.left) + coutNodes(node.right);
    }

    public static boolean isComplete(Node node, int index, int numberOfNodes){
        if(node == null)
            return true;

        if(index >= numberOfNodes)
            return false;

        return isComplete(node.left, index * 2 + 1, numberOfNodes) && isComplete(node.right, index * 2 + 2, numberOfNodes);
    }




}


