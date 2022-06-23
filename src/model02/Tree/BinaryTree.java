package model02.Tree;

public class BinaryTree {

    private class Node{
        private int value;

        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //Time complexity O(logN)
    public void insert(int item){
        if (root == null){
            root = new Node(item);
            return;
        }

        Node current = root;
        while (true){
            if (item > current.value){
                if (current.right == null){
                    current.right = new Node(item);
                    break;
                }
                current = current.right;
            }else{
                if (current.left == null){
                    current.left = new Node(item);
                    break;
                }
                current = current.left;
            }
        }
    }

    //Time complexity O(N)
    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.value + " ");
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    //Time complexity O(N)
    public void traverseInOrder(){
        traverseInOrder(root);
        System.out.println("\n");
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;
        traverseInOrder(root.left);
        System.out.print(root.value + " ");
        traverseInOrder(root.right);
    }

    //Time complexity O(N).
    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.print(root.value + " ");
    }

    public int height(){
        return height(root);
    }

    private int height(Node root) {
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        if (lheight > rheight) return lheight + 1;
        else return rheight + 1;

    }

    public void traverseLevelOrder(){
        int h = height();

        for (int i = 0; i < h; i++) {
            printLevelOrder(root, i);
        }
    }

    private void printLevelOrder(Node root, int level) {
        if (root == null) return;
        if (level == 1){
            System.out.println(root.value);
        }else {
            printLevelOrder(root.left, level -1 );
            printLevelOrder(root.right, level -1 );
        }
    }

    //Time complexity : O(logN)
    public boolean find(int item){
        Node current = root;
        while (current != null){
            if (item < current.value) current = current.left;
            else if (item > current.value) current = current.right;
            else return true;
        }
        return false;
    }

    public void printAllLeaves(){

    }

    public int min(){

        return -1;
    }

    public int max(){

        return -1;
    }

    public boolean isBinarySearchTree(){

        return false;
    }

    public void printNodesAtKthLevel(int k_level){

    }
}
