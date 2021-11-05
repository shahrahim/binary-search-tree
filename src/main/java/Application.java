package main.java;

public class Application {

    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.doInsert(17);
        bTree.doInsert(12);
        bTree.doInsert(25);
        bTree.doInsert(7);
        bTree.doInsert(15);
        bTree.doInsert(20);
        bTree.doInsert(3);
        bTree.doInsert(9);
        bTree.doInsert(14);
        bTree.inOrderTraversal();
        System.out.println(bTree.height(bTree.getRoot()));
    }

    static void doComputeMedian(BinarySearchTree bTree) {
        Integer i = bTree.getSet().size() / 2;
        Float median = (float)(bTree.getSet().get(i-1) + bTree.getSet().get(i)) / 2;
        System.out.println(median);
    }
    
}
