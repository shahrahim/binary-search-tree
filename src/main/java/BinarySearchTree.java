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

    public Integer height(Node root) {
        if(root == null || isLeaf(root)) {
            return 0;
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
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

    public Integer getNumNodes(Node root) {
        if(root == null) {
            return 0;
        } else {
            return 1 + (getNumNodes(root.getLeft()) + getNumNodes(root.getRight()));
        }
    }

    public Integer leaf(Node root) {
        if(root == null) {
            return 0;
        }

        if(isLeaf(root)) {
            return 1;
        }
        return (leaf(root.getLeft()) + leaf(root.getRight()));
    }

    public Integer internal(Node root) {
        if(root == null || isLeaf(root)) {
            return 0;
        } else {
            return 1 + (internal(root.getLeft())) + (internal(root.getRight()));            
        }
    }

    private Boolean isLeaf(Node root) {
        if(root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        return false;
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
        if(root.data < data) {
            root.right = doDelete(root.right, data);
        } else if(root.data > data) {
            root.left = doDelete(root.left, data);
        } else {
            if(root.right != null && root.left != null) {
                root.data = getMinNode(root.right).data;
                root.right = doDelete(root.right, root.data);
            } else if(root.right != null) {
                root = root.right;
            } else if(root.left != null) {
                root = root.left;
            } else {
                root = null;
            }
        }
        return root;
    }

    private Node getMinNode(Node root) {
        if(root.left == null) {
            return root;
        } else {
          return getMinNode(root.left);  
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
