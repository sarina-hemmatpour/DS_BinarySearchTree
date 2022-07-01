package com.company;

public class BinarySearchTree<E> extends BinaryTree {


    public BinarySearchTree(E value, int key) {
        super(value, key);
    }

//    @Override
//    public boolean isInternal(Node node) throws IllegalArgumentException {
//
//        if (node!=null)
//        {
//            if (isRoot(node))
//            {
//                return true;
//            }
//            if (rightChild(node)==null && leftChild(node)==null && node.getParent()!=null)
//            {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean isExternal(Node node) throws IllegalArgumentException {
//        return !isInternal(node);
//    }


    int findMax(int a, int b){
        if(a >= b)
            return a;
        else
            return b;
    }

    int findHeight(Node<E> root){
        // Base case:
        if(root == null)
            return 0;

        return findMax(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
    }


    //methodes

    public Node<E> get(Node<E> node ,int key)
    {

        if (isExternal(node))
        {
            if (key==node.getKey())
            {
                return node;
            }
            Node<E> newNode=new Node<>();
            newNode.setParent(node);
            return newNode;
        }

        if (node.getKey()==key)
        {
            return node;
        }

        if (node.getKey()>key)
        {
            if (leftChild(node)!=null)
            {
                return get(node.getLeft(),key);
            }

            Node<E> newNode=new Node<>();
            newNode.setParent(node);
            return newNode;
        }
        else if (node.getKey()<key)
        {
            if (rightChild(node)!=null)
            {
                return get(node.getRight() , key);
            }

            Node<E> newNode=new Node<>();
            newNode.setParent(node);
            return newNode;
        }

        return null;
    }

    public Node<E> put(E value , int key)
    {


        Node<E> foundNode=get(root(),key);

        if (key==foundNode.getKey())
        {
            foundNode.setValue(value);
            return foundNode;

        }
        else
        {

            foundNode.setKey(key);
            foundNode.setValue(value);

            if (foundNode.getParent().getKey()> foundNode.getKey())
            {
                foundNode.getParent().setLeft(foundNode);
            }
            else
            {
                foundNode.getParent().setRight(foundNode);
            }
            return foundNode;
        }


    }

    public Node<E> remove(int key)
    {
        Node<E> nodeToRemove=get(root(),key);

        if (!isRoot(nodeToRemove))
        {
            if (isExternal(nodeToRemove.getParent()))
            {
                return null;
            }
        }


        //has no child
        if (isExternal(nodeToRemove))
        {
            if (isRoot(nodeToRemove))
            {
                setRoot(null);
            }

            if (isLeft(nodeToRemove))
            {
                nodeToRemove.getParent().setLeft(null);
//                nodeToRemove.setParent(null);
                return nodeToRemove;
            }
            else
            {
                nodeToRemove.getParent().setRight(null);
//                nodeToRemove.setParent(null);
                return nodeToRemove;
            }
        }


        //has 1 child
        if (numChildren(nodeToRemove)==1)
        {
            if (isRoot(nodeToRemove))
            {
                if (hasLeft(root()))
                {
                    //has a left child

                    this.setRoot(root().getLeft());
//                    nodeToRemove.setLeft(null);
                    return nodeToRemove;
                }
                else
                {
                    this.setRoot(root().getRight());
//                    nodeToRemove.setRight(null);
                    return nodeToRemove;
                }

            }

            else //not root
            {
                if (isLeft(nodeToRemove))
                {
                    if (hasLeft(nodeToRemove))
                    {
                        nodeToRemove.getParent().setLeft(nodeToRemove.getLeft());
                        nodeToRemove.getLeft().setParent(nodeToRemove.getParent());
//                        nodeToRemove.setParent(null);
//                        nodeToRemove.setLeft(null);
                        return nodeToRemove;
                    }
                    else
                    {
                        //has right child
                        nodeToRemove.getParent().setLeft(nodeToRemove.getRight());
                        nodeToRemove.getRight().setParent(nodeToRemove.getParent());
//                        nodeToRemove.setParent(null);
//                        nodeToRemove.setRight(null);
                        return nodeToRemove;

                    }
                }

                else
                {
                    //is right
                    if (hasLeft(nodeToRemove))
                    {
                        nodeToRemove.getParent().setRight(nodeToRemove.getLeft());
                        nodeToRemove.getLeft().setParent(nodeToRemove.getParent());
//                        nodeToRemove.setParent(null);
//                        nodeToRemove.setLeft(null);
                        return nodeToRemove;
                    }
                    else
                    {
                        //has right
                        nodeToRemove.getParent().setRight(nodeToRemove.getRight());
                        nodeToRemove.getRight().setParent(nodeToRemove.getParent());
//                        nodeToRemove.setParent(null);
//                        nodeToRemove.setRight(null);
                        return nodeToRemove;
                    }
                }
            }

        }


        //has 2 children
        //samte right tarin farzande left

        if (!hasRight(nodeToRemove.getLeft()))
        {
            //is root
            if (isRoot(nodeToRemove))
            {
                Node<E> newNode=new Node<>(nodeToRemove.getLeft().getValue(),nodeToRemove.getLeft().getKey());
                newNode.setRight(nodeToRemove.getRight());
                if (hasLeft(nodeToRemove.getLeft()))
                {
                    newNode.setLeft(nodeToRemove.getLeft().getLeft());
                }

                nodeToRemove.getRight().setParent(newNode);

                setRoot(newNode);

//                nodeToRemove.setRight(null);
//                nodeToRemove.setLeft(null);
                return nodeToRemove;

            }
            else //is not root
            {
                if (isRight(nodeToRemove))
                {
                    //new node
                    Node<E> newNode=new Node<>(nodeToRemove.getLeft().getValue(),nodeToRemove.getLeft().getKey());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setParent(nodeToRemove.getParent());
                    if (hasLeft(nodeToRemove.getLeft()))
                    {
                        newNode.setLeft(nodeToRemove.getLeft().getLeft());
                    }

                    //parent
                    nodeToRemove.getParent().setRight(newNode);

                    //children
                    nodeToRemove.getRight().setParent(newNode);

                    //to remove
//                    nodeToRemove.setParent(null);
//                    nodeToRemove.setRight(null);
//                    nodeToRemove.setLeft(null);
                    return nodeToRemove;

                }
                else //is left
                {
                    //new node
                    Node<E> newNode=new Node<>(nodeToRemove.getLeft().getValue(),nodeToRemove.getLeft().getKey());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setParent(nodeToRemove.getParent());
                    if (hasLeft(nodeToRemove.getLeft()))
                    {
                        newNode.setLeft(nodeToRemove.getLeft().getLeft());
                    }

                    //parent
                    nodeToRemove.getParent().setLeft(newNode);

                    //children
                    nodeToRemove.getRight().setParent(newNode);

                    //to remove
//                    nodeToRemove.setParent(null);
//                    nodeToRemove.setRight(null);
//                    nodeToRemove.setLeft(null);
                    return nodeToRemove;

                }
            }
        }
        else //is not external
        {
            //is root
            if (isRoot(nodeToRemove))
            {
                Node<E> travelNode=travelToRight(nodeToRemove.getLeft());

                //new node
                Node<E> newNode=new Node<>(travelNode.getValue() , travelNode.getKey());
                newNode.setRight(nodeToRemove.getRight());
                newNode.setLeft(nodeToRemove.getLeft());
                setRoot(newNode);

                //children
                nodeToRemove.getRight().setParent(newNode);
                nodeToRemove.getLeft().setParent(newNode);

                //new nodes parent
                travelNode.getParent().setRight(null);

                //to remove
//                nodeToRemove.setRight(null);
//                nodeToRemove.setLeft(null);
                return nodeToRemove;
            }
            else //is not root
            {
                //is right
                if (isRight(nodeToRemove))
                {
                    Node<E> travelNode=travelToRight(nodeToRemove.getLeft());

                    //new node
                    Node<E> newNode=new Node<>(travelNode.getValue() , travelNode.getKey());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setParent(nodeToRemove.getParent());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setLeft(nodeToRemove.getLeft());

                    //parent
                    nodeToRemove.getParent().setRight(newNode);

                    //children
                    nodeToRemove.getRight().setParent(newNode);
                    nodeToRemove.getLeft().setParent(newNode);

                    //new nodes parent
                    travelNode.getParent().setRight(null);

                    //to remove
                    //to remove
//                    nodeToRemove.setParent(null);
//                    nodeToRemove.setRight(null);
//                    nodeToRemove.setLeft(null);
                    return nodeToRemove;
                }
                else //is left
                {
                    Node<E> travelNode=travelToRight(nodeToRemove.getLeft());

                    //new node
                    Node<E> newNode=new Node<>(travelNode.getValue() , travelNode.getKey());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setParent(nodeToRemove.getParent());
                    newNode.setRight(nodeToRemove.getRight());
                    newNode.setLeft(nodeToRemove.getLeft());

                    //parent
                    nodeToRemove.getParent().setLeft(newNode);

                    //children
                    //children
                    nodeToRemove.getRight().setParent(newNode);
                    nodeToRemove.getLeft().setParent(newNode);

                    //new nodes parent
                    travelNode.getParent().setRight(null);

                    //to remove
//                    nodeToRemove.setParent(null);
//                    nodeToRemove.setRight(null);
//                    nodeToRemove.setLeft(null);
                    return nodeToRemove;
                }

            }
        }



    }


    private Node<E> travelToRight(Node<E> node)
    {
        if (isExternal(node))
        {
            return node;
        }

        return travelToRight(node.getRight());
    }
}
