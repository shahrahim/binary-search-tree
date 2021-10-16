package main.java;
public class Node {
    
    protected Integer data;

    protected Node left;

    protected Node right;

    public Node(Integer data) {
        this.data = data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Integer getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }

}