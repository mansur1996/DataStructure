package model02.Tree;

public class Lesson7 {
    public static void main(String[] args) {
        //Pre-order  : 20 15 10 4 12 22 18 24 50 35 31 44 70 66 90
        //In-order   : 4 10 12 15 18 22 24 25 31 35 44 50 66 70 90
        //Post-order : 4 12 10 18 24 22 15 31 44 35 66 90 70 50 25

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(20);
        binaryTree.insert(5);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(15);
        binaryTree.insert(25);

        binaryTree.traversePreOrder();
//        binaryTree.traverseInOrder();
//        binaryTree.traversePostOrder();

    }
}
