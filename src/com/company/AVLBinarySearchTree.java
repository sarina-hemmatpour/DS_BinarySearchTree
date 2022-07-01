package com.company;

public class AVLBinarySearchTree<E> extends BinarySearchTree {
    public AVLBinarySearchTree(E value, int key) {
        super(value, key);
    }

    public int difference(Node<E> first , Node<E> sec)
    {
        return findHeight(first)-findHeight(sec);
    }

    public Node<E> findeTheFirstUnbalancedNode(Node<E> node)
    {
        if (difference(node.getLeft(),node.getRight())>1 || difference(node.getLeft(),node.getRight())<-1)
        {
            return node;
        }
        else
        {
            if (node==root())
            {
                return null;
            }
            else
            {
                return findeTheFirstUnbalancedNode(node.getParent());
            }
        }

    }

    //methods
    public Node<E> rightRotate(Node<E> z)
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

    public Node<E> insert(E value , int key)
    {
        Node<E> insertedNode=put(value,key);

        Node<E> theFirstUn=findeTheFirstUnbalancedNode(insertedNode);
        if (theFirstUn!=null)//it is unbalenced
        {
            int balance=difference(theFirstUn.getLeft(),theFirstUn.getRight());

            //1.left left case
            if (balance>1 && key<theFirstUn.getLeft().getKey())
            {
                return rightRotate(theFirstUn);
            }

            //2.right right case
            if (balance<-1 && key>theFirstUn.getRight().getKey())
            {
                return leftRotate(theFirstUn);
            }

            //3.left right case
            if (balance>1 && key>theFirstUn.getLeft().getKey())
            {
                return rightRotate(leftRotate(theFirstUn.getLeft()));
            }

            //4.right left case
            if (balance<-1 && key<theFirstUn.getLeft().getKey())
            {
                return leftRotate(rightRotate(theFirstUn.getRight()));
            }


        }

        return insertedNode;
    }


    public Node<E> delete(int key)
    {
        Node<E> removedNode=remove(key);

        Node<E> theFirstUn=findeTheFirstUnbalancedNode(removedNode.getParent());

        if (theFirstUn!=null)//its unbalanced
        {
            int balance=difference(theFirstUn.getLeft(),theFirstUn.getRight());
            if (balance>1)
            {
                int cbalance=difference(theFirstUn.getLeft().getLeft(),theFirstUn.getLeft().getRight());

                //1.left left case
                if (cbalance>=0)
                {
                    return rightRotate(theFirstUn);

                }

                //2.left right case
                else
                {
                    return rightRotate(leftRotate(theFirstUn.getLeft()));
                }
            }
            else if (balance<-1)
            {
                int cbalance=difference(theFirstUn.getRight().getLeft(),theFirstUn.getRight().getRight());

                //3.right left case
                if (cbalance>=0)
                {
                    return leftRotate(rightRotate(theFirstUn.getRight()));
                }

                //4.right right case
                else
                {
                    return leftRotate(theFirstUn);
                }
            }


        }
        return removedNode;


    }



}
