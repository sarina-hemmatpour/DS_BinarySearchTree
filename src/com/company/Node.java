package com.company;

public class Node<E> {

    private E value;
    private int key;
    private Node<E> parent;
    private Node<E> left;
    private Node<E> right;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node<E> getParent() {
        return parent;
    }

    public void setParent(Node<E> parent) {
        this.parent = parent;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public Node(E value , int key) {
        this.value = value;
        this.left=null;
        this.right=null;
        this.parent=null;
        this.key=key;
    }

    public Node()
    {
        this.left=null;
        this.right=null;
        this.parent=null;
    }

}
