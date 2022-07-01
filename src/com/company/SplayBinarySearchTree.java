package com.company;

public class SplayBinarySearchTree <E> extends BinarySearchTree<E> {


    public SplayBinarySearchTree(E value, int key) {
        super(value, key);
    }

    //methods
    public  Node<E> rightRotate(Node<E> z)
    {
        Node<E> y= z.getLeft();
        Node<E> T2=y.getRight();
        Node<E> T4=z.getParent();
        //1 : parent of y
        if (z!=root())
        {
            //z is left child
            if (isLeft(z))
            {
                T4.setLeft(y);
            }
            else
            {
                T4.setRight(y);
            }
            y.setParent(T4);
        }
        else
        {
            //z is root
            setRoot(y);
        }
        //2
        z.setLeft(T2);
        if (T2!=null)
        {
            T2.setParent(z);
        }


        //2
        z.setParent(y);
        y.setRight(z);

        //hight*****************************

        return y;

    }

    public Node<E> leftRotate(Node<E> z)
    {
        Node<E> y=z.getRight();
        Node<E> T4=z.getParent();
        Node<E> T1=y.getLeft();
        //1 parent T4
        if (z!=root())
        {
            if (isLeft(z))
            {
                T4.setLeft(y);
            }
            else
            {
                T4.setRight(y);
            }
            y.setParent(T4);
        }
        else
        {
            //z is root
            setRoot(y);
        }

        //2
        z.setRight(T1);
        if (T1!=null)
        {
            T1.setParent(z);
        }


        //3

        z.setParent(y);
        y.setLeft(z);

        //height*********************

        return y;

    }

    public Node<E> splay(Node<E> root , int key)
    {

        //the node is the root or the root is null
        if (root.getKey()==key || root==null)
        {
            return root;
        }

        //

        if (root.getKey() > key)
        {
            if (root.getLeft() == null) return root;

            // ZigZig /Left Left
            if (root.getLeft().getKey()> key)
            {
                root.getLeft().setLeft(splay(root.getLeft().getLeft(), key));

                root = rightRotate(root);
            }
            else if (root.getLeft().getKey() < key) // ZigZag /Left Right
            {
                root.getLeft().setRight(splay(root.getLeft().getRight(), key));

                if (root.getLeft().getRight() != null)
                    root.setLeft(leftRotate(root.getLeft()));
            }

            return (root.getLeft() == null) ?
                    root : rightRotate(root);
        }

        else //is in right
        {
            if (root.getRight() == null) return root;

            // ZagZig /Right Left
            if (root.getRight().getKey() > key)
            {
                root.getRight().setLeft(splay(root.getRight().getLeft(), key));

                if (root.getRight().getLeft()!= null)
                    root.setRight(rightRotate(root.getRight()));
            }
            else if (root.getRight().getKey() < key)// Zag Zag /Right Right
            {
                root.getRight().setRight(splay(root.getRight().getRight(), key));
                root = leftRotate(root);
            }

            return (root.getRight() == null) ?
                    root : leftRotate(root);
        }


    }

    public Node<E> find(int key){
        Node<E> newNode=splay(root(),key);
        setRoot(newNode);
        root().setParent(null);
        return newNode;
    }

    public Node<E> insert(E value,int key)
    {
        Node<E> newNode=put(value,key);
        splay(root(),key);
        setRoot(newNode);
        root().setParent(null);

        return newNode;
    }

    public Node<E> delete(int key)
    {
        Node<E> newNode=remove(key);
        if (newNode!=null)
        {
            Node<E> newNode1=splay(root(),newNode.getKey());
            setRoot(newNode1);
            root().setParent(null);
        }
        return newNode;
    }



}
