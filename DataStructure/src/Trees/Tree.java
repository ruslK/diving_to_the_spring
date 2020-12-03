package Trees;

public class Tree {
    /**
     * Nested Node Class
     */
    private class Node {
        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    /**
     * Insert Method
     */
    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = node;
        } else {
            Node current = root;
            while (true) {
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;
                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }
    }

    /**
     * Implement Pre-Order
     * Root-Left-Right
     */
    public void traversPreOrder() {
        traversPreOrder(root);
    }

    private void traversPreOrder(Node root) {
        if (root == null) return;

        System.out.print(root.value + ", ");
        traversPreOrder(root.leftChild);
        traversPreOrder(root.rightChild);
    }

    /**
     * Implement In-Order
     * Left-Root-Right
     */
    public void traversInOrder() {
        traversInOrder(root);
    }

    private void traversInOrder(Node root) {
        if (root == null) return;

        traversInOrder(root.leftChild);
        System.out.print(root.value + ", ");
        traversInOrder(root.rightChild);
    }

    /**
     * Implement Post-Order
     * Left-Right-Root
     */
    public void traversPostOrder() {
        traversPostOrder(root);
    }

    private void traversPostOrder(Node root) {
        if (root == null) return;

        traversPostOrder(root.leftChild);
        traversPostOrder(root.rightChild);
        System.out.print(root.value + ", ");
    }

    public static void main(String[] args) {
        Tree myTree = new Tree();
        int[] arr = new int[]{10, 6, 8, 20, 4, 9, 5, 17, 42, 47, 29};
        for (int j : arr) {
            myTree.insert(j);
        }
        System.out.println("Pre Order Traversal Tree");
        myTree.traversPreOrder();
        System.out.println();
        System.out.println("In Order Traversal Tree");
        myTree.traversInOrder();
        System.out.println();
        System.out.println("Post Order Traversal Tree");
        myTree.traversPostOrder();
    }
}
