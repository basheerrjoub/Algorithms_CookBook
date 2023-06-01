import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main  {



    public static void main(String[] args) {

        Node<String> root = new Node<>("Basheer");
        root.left = new Node<>("Essa");
        root.right = new Node<>("Ahmad");
        root.right.left = new Node<>("Mahmoud");
        root.right.right = new Node<>("Mamoun");
        root.left.right = new Node<>("Hassan");
        root.left.left = new Node<>("Hamza");
        root.left.left.right = new Node<>("Osta");
//        root.left.left.right.left = new Node<>("Ali");
//        printDot(root);
        System.out.println(Node.isBalanced(root));
    }

    static void printDot(Node node) {
        System.out.println("digraph G {");
        printDotHelper(node);
        System.out.println("}");
    }

    static void printDotHelper(Node node) {
        if (node != null) {
            String nodeName = "\"" + node.item.toString() + "\"";
            if (node.left != null) {
                String leftName = "\"" + node.left.item.toString() + "\"";
                System.out.println(nodeName + " -> " + leftName + ";");
                printDotHelper(node.left);
            }
            if (node.right != null) {
                String rightName = "\"" + node.right.item.toString() + "\"";
                System.out.println(nodeName + " -> " + rightName + ";");
                printDotHelper(node.right);
            }
        }
    }

}
