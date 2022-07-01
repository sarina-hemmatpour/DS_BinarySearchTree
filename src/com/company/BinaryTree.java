package com.company;

import java.util.ArrayList;

public class BinaryTree <E> {


    private Node<E> root;

    public BinaryTree() {
//        this.root=new Node<>();
    }
    public BinaryTree(E value , int key)
    {
        this.root=new Node<>(value , key);
    }

    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }


    //methodes

    public Node<E> addRoot(E value , int key) throws Exception {
        if (isEmpty())
        {
            this.root=new Node<>(value , key);

            return root;
        }
        Exception exception=new Exception("this tree has already a root.");
        throw exception;
    }

    public Node<E> addLeft(Node<E> node , E value , int key) throws Exception {
        if (leftChild(node)==null)
        {
            Node<E> newNode=new Node<>(value , key);

            node.setLeft(newNode);
            node.getLeft().setParent(node);

            return newNode;
        }
        Exception exception=new Exception("this node has already a left child.");
        throw exception;

    }

    public Node<E> addRight(Node<E> node , E value , int key) throws Exception {
        if (rightChild(node)==null)
        {
            Node<E> newNode=new Node<>(value , key);

            node.setRight(newNode);
            node.getRight().setParent(node);

            return newNode;
        }
        Exception exception=new Exception("this node has already a right child.");
        throw exception;

    }

    public E set(Node<E> node , E value )throws IllegalArgumentException
    {
        node.setValue(value);

        return value;
    }

    public Node<E> root()
    {
        return this.root;
    }

    public boolean isRoot(Node<E> node)
    {
        if(node==root)
        {
            return true;
        }
        return false;
    }

//    public Node<E> parent(Node<E> node) throws IllegalArgumentException
//    {
//        if (isRoot(node))
//        {
//            return null;
//        }
//        return node.getParent();
//    }

    public Node<E> leftChild(Node<E> node) throws IllegalArgumentException
    {
        return node.getLeft();

    }


    public Node<E> rightChild(Node<E> node)throws IllegalArgumentException
    {
        return node.getRight();
    }

    public ArrayList<Node<E>> children(Node<E> node) throws IllegalArgumentException
    {
        ArrayList<Node<E>> children=new ArrayList<>();

        if (leftChild(node)!=null)
        {
            children.add(leftChild(node));
        }

        if (rightChild(node)!=null)
        {
            children.add(rightChild(node));
        }


        return children;

    }

    public boolean isEmpty(){
        if (root()==null )
        {
            return true;
        }
        return false;
    }

    public int numChildren(Node<E> node) throws IllegalArgumentException
    {
        if (leftChild(node)==null && rightChild(node)==null)
        {
            return 0;
        }

        if (leftChild(node)!=null && rightChild(node)!=null)
        {
            return 2;
        }

        return 1;
    }

    public boolean isInternal(Node<E> node)throws IllegalArgumentException
    {
        if (leftChild(node)==null && rightChild(node)==null)
        {
            return false;
        }

        return true;
    }
    public boolean isExternal(Node<E> node)throws IllegalArgumentException
    {
        if (isInternal(node))
        {
            return false;
        }
        return true;
    }

    public Node<E> sibling(Node<E> node)throws IllegalArgumentException
    {
        if (numChildren(node.getParent())==2)
        {
            if (node==rightChild(node.getParent()))
            {
                return leftChild(node.getParent());
            }

            return rightChild(node.getParent());
        }

        return null;
    }

    //traverse

    public void traversePreOrder(Node<E> node)
    {
        System.out.print(node.getValue() + " ");

        if (leftChild(node)!=null)
        {
            traversePreOrder(leftChild(node));
        }

        if (rightChild(node)!= null)
        {
            traversePreOrder(rightChild(node));
        }
    }


    public void traversePostOrder(Node<E> node)
    {
        if (leftChild(node)!=null)
        {
            traversePostOrder(leftChild(node));
        }

        if (rightChild(node)!= null)
        {
            traversePostOrder(rightChild(node));
        }

        System.out.print(node.getValue() + " ");


    }

    public void traverseInOrder(Node<E> node)
    {
        if (leftChild(node)!=null)
        {
            traverseInOrder(leftChild(node));
        }

        System.out.print(node.getValue() + " ");

        if (rightChild(node)!= null)
        {
            traverseInOrder(rightChild(node));
        }
    }


    public boolean hasRight(Node<E> node )
    {
        if (numChildren(node)!=0 && node.getRight()!=null)
        {
            return true;
        }
        return false;
    }

    public boolean hasLeft(Node<E> node)
    {
        if (numChildren(node)!=0 && node.getLeft()!=null)
        {
            return true;
        }
        return false;
    }

    public boolean isLeft(Node<E> node)
    {
        if (node.getParent().getLeft().getKey()==node.getKey())
        {
            return true;
        }

        return false;
    }
    public boolean isRight(Node<E> node)
    {
        if (node.getParent().getRight().getKey()==node.getKey())
        {
            return true;
        }
        return false;
    }

}
