package main.java;

public class Application {

    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.doInsert(9);
        bTree.doInsert(6);
        bTree.doInsert(12);
        bTree.doInsert(5);
        bTree.doInsert(7);
        bTree.doInsert(8);
        bTree.doInsert(17);
        bTree.doInsert(21);
        bTree.inOrderTraversal();
    
        bTree.doDelete(bTree.getRoot(), 12);

        bTree.inOrderTraversal();
    }

    static void doComputeMedian(BinarySearchTree bTree) {
        Integer i = bTree.getSet().size() / 2;
        Float median = (float)(bTree.getSet().get(i-1) + bTree.getSet().get(i)) / 2;
        System.out.println(median);
    }
    
}
