package com.company;

public class Main {

    public static void main(String[] args) throws Exception {


//        BinaryTree<Integer> binaryTree =new BinaryTree<>(3);
//
//        binaryTree.addLeft(binaryTree.root(),5);
//        binaryTree.addRight(binaryTree.root().getLeft(), 6);
//
//        binaryTree.addRight(binaryTree.root(),8);
//
//        binaryTree.addRight(binaryTree.root().getRight(),10);
//        binaryTree.addLeft(binaryTree.root().getLeft() , 7);
//
//        binaryTree.addRight(binaryTree.root().getLeft().getRight(),11);
//        binaryTree.addLeft(binaryTree.root().getLeft().getRight(),12);
//
//        binaryTree.traverseInOrder(binaryTree.root());

//        BinarySearchTree<Integer> binarySearchTree=new BinarySearchTree<>(2 , 50);
//        binarySearchTree.put(6 , 39);
//        binarySearchTree.put(7,55);
//        binarySearchTree.put(9,40);
//        binarySearchTree.put(8,20);
//        binarySearchTree.put(5,54);
//        binarySearchTree.put(4,58);
//        binarySearchTree.put(11,53);
//        binarySearchTree.put(17,60);
//        binarySearchTree.put(1,19);
//        binarySearchTree.put(12,25);
//
//        binarySearchTree.remove(39);
//
//        binarySearchTree.traverseInOrder(binarySearchTree.root());


//        AVLBinarySearchTree<Integer> tree=new AVLBinarySearchTree<>(10,10);
//        tree.insert(20,20);
//        tree.insert(30,30);
//        tree.insert(40,40);
//        tree.insert(50,50);
//        tree.insert(25,25);
//
//        tree.traverseInOrder(tree.root());
//        tree.delete(40);
//        tree.traverseInOrder(tree.root());

//        AVLBinarySearchTree<Integer> tree=new AVLBinarySearchTree<>(9,9);
//        tree.insert(5,5);
//        tree.insert(10,10);
//        tree.insert(6,6);
//        tree.insert(11,11);
//        tree.insert(-1,-1);
//        tree.insert(1,1);
//        tree.insert(2,2);
//
//
//        tree.traverseInOrder(tree.root());
//        System.out.println();
//
//        tree.delete(10);
//        tree.traverseInOrder(tree.root());

        SplayBinarySearchTree<Integer> tree=new SplayBinarySearchTree<>(30,30);
        tree.insert(40,40);
        tree.insert(50,50);
        tree.insert(200,200);
        tree.insert(100,100);
        tree.insert(20,20);

        System.out.println(tree.find(50).getValue());

        tree.traverseInOrder(tree.root());



    }
}
