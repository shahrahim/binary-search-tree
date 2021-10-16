package main.java;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;

    private List<Integer> set;

    public BinarySearchTree() {}

    public List<Integer> getSet() {
        return this.set;
    }

    public Node getRoot() {
        return this.root;
    }

    public Node getBySearch(Integer data) {
        return doTraverseAndSearch(root, data);        
    }

    public void doInsert(Integer data) {
        Node node = new Node(data);
        
        if(root == null) {
            this.root = node;
        } else {
            doTraverseAndInsert(root, node);
        }
    }

    public void inOrderTraversal() {
        this.set = new ArrayList<>();
        doTraverse(root);
        System.out.println();
    }

    public Node doDelete(Node root, Integer data) {
        if(root == null) {
            return root;
        }
        else if(root.getData() < data) {
            root.setRight(doDelete(root.getRight(), data));
        }
        else if(root.getData() > data) {
            root.setLeft(doDelete(root.getLeft(), data));

        } else {
            // Case 1: two childs
            if(root.getLeft() != null && root.getRight() != null) {
                Node temp = root;
                Node minNodeOnRight = getMinNode(temp.getRight());
                root.setData(minNodeOnRight.getData());
                root.right = (doDelete(root.getRight(), minNodeOnRight.getData()));
            } 
            // Case 2: one child
            else if(root.getRight() != null) {
                root = (root.getRight());
            } else if(root.getLeft() != null) {
                root = (root.getLeft());
            } 
            // Case 3: no child
            else {
                root = null;
            }
        }
        return root;
    }

    private Node getMinNode(Node root) {
        if(root.getLeft() == null) {
            return root;
        } else {
            return getMinNode(root.getLeft());
        }

    }

    private void doTraverse(Node root) {
        if(root == null) {
            return;
        }
        doTraverse(root.getLeft());
        set.add(root.getData());
        System.out.println(root.getData());
        doTraverse(root.getRight());
    }

    private void doTraverseAndInsert(Node root, Node node) {
        if(root.getData() > node.getData()) {
            if(root.getLeft() != null) {
                doTraverseAndInsert(root.getLeft(), node);
            } else {
                root.setLeft(node);
            }
        } else {
            if(root.getRight() != null) {
                doTraverseAndInsert(root.getRight(), node);
            } else {
                root.setRight(node);
            }
        }
    }

    private Node doTraverseAndSearch(Node root, Integer data) {
        if(root == null) {
            return null;
        }
        if(root.getData().equals(data)) {
            return root;
        } 
        if(root.getData() > data) {
            return doTraverseAndSearch(root.getLeft(), data);
        }   
        return doTraverseAndSearch(root.getRight(), data);
    }    
}
