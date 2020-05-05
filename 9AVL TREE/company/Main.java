package com.company;

public class Main {

    public static void main(String[] args) {
        AVL<Integer > avl = new AVL<>();

        avl.insert(9);
        avl.insert(1);
        avl.insert(8);
        avl.insert(2);
        avl.insert(7);
        avl.insert(3);
//        avl.delete(6);
//        avl.delete(4);
//        avl.delete(5);

        avl.printLevelOrder();
    }
}
