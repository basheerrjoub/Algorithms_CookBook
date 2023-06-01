public class BinarySearchTree<T> {

    Node<T> root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int item) {
        root = insertRec(root, item);
    }

    Node insertRec(Node root, int item) {
        if (root == null) {
            root = new Node(item);
            return root;
        }
        if (item < root.key)
            root.left = insertRec(root.left, item);
        else if (item > root.key)
            root.right = insertRec(root.right, item);

        return root;

    }
    void delete(int key){
        root = deleteRec(root, key);
    }
    Node deleteRec(Node root, int key){
        if(root == null)
            return root;
        if(key < root.key)
            root.left = deleteRec(root.left, key);
        else if(key > root.key)
            root.right = deleteRec(root.right, key);
        else{
            //It is a leaf Node
            if(root.left == null && root.right == null)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                //Internal Node with left and right
                int minValue = minValue(root.right);
                root.key = minValue;
                root.right = deleteRec(root.right, minValue);
            }
        }
        return root;
    }

    int minValue(Node root){
        int minV = root.key;
        while(root.left != null){
            minV = root.left.key;
            root = root.left;
        }

        return minV;
    }

    void inorder(){
        inorderRec(root);
    }

    void inorderRec(Node root){
        if(root != null){
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }





    String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph BST {\n");
        sb.append("node [fontname=\"Arial\"];\n");
        if (root == null)
            sb.append("\n");
        else
            toDotRec(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void toDotRec(Node n, StringBuilder sb) {
        if (n.left != null) {
            sb.append(n.key + " -> " + n.left.key + ";\n");
            toDotRec(n.left, sb);
        }
        if (n.right != null) {
            sb.append(n.key + " -> " + n.right.key + ";\n");
            toDotRec(n.right, sb);
        }
        if (n.left == null && n.right == null)
            sb.append(n.key + ";\n");
    }

}
