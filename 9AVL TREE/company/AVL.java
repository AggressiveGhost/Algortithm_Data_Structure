package com.company;

public class AVL<T extends Comparable<T>> {
    private Node<T> root;

    public AVL() {}
    public void insert(T data){
        root = insert(root,data);
//        printLevelOrder();
//        System.out.println();
    }
    public void printLevelOrder() {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }
    public void delete(T data){ root =  delete(root, data); }

    private void printGivenLevel (Node root ,int level) {
        if (root == null){ System.out.printf("# ");return;}
        if (level == 1)
            System.out.printf(root.getData() + " ");
        else if (level > 1)
        {
            printGivenLevel(root.getLeft(), level-1);
            printGivenLevel(root.getRight(), level-1);
        }
    }
    private int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node parent) {

        Node head = parent.getLeft();
        Node left = head.getRight();


        head.setRight(parent);
        parent.setLeft(left);

        parent.setHeight(
                max(height(parent.getLeft()), height(parent.getRight())) + 1
        );
        head.setHeight(
                max(height(head.getLeft()), height(head.getRight())) + 1
        );
        return head;
    }
    private Node leftRotate(Node parent) { // parent

        Node head = parent.getRight();

        Node left = head.getLeft();

        head.setLeft(parent);

        parent.setRight(left);

        parent.setHeight(
                max(height(parent.getLeft()), height(parent.getRight())) + 1
        );

        head.setHeight(max(height(head.getLeft()), height(head.getRight())) + 1
        );
        return head;
    }
    private int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.getLeft()) - height(N.getRight());
    }
    private Node insert(Node node, T data) {
        if (node == null)
            return (new Node(data));

        if (data.compareTo((T) node.getData()) < 0)
            node.setLeft(
                    insert(node.getLeft(), data)
            );
        else if (data.compareTo((T) node.getData()) > 0)
            node.setRight(
                    insert(node.getRight(), data)
            );


        node.setHeight(
                1 + max(
                        height(node.getLeft()),

                        height(node.getRight())
                )
        );

        int balance = getBalance(node); // 2  data == 8

        if (balance > 1 && data.compareTo((T) node.getLeft().getData())<0) // data < node.data
            return rightRotate(node);

        if (balance < -1 && data.compareTo((T) node.getRight().getData()) > 0) // L
            return leftRotate(node);


        if (balance > 1 && data.compareTo((T) node.getLeft().getData()) > 0) {//lr // data > node.data // LR
            node.setLeft(
                    leftRotate(node.getLeft())
            );
            return rightRotate(node);
        }


        if (balance < -1 && data.compareTo((T) node.getRight().getData())<0) {
            node.setRight(
                    rightRotate(node.getRight())
            );
            return leftRotate(node);
        }

        return node;
    }
    private Node delete(Node node, T data){
        if (node != null) {
            if (node.getData().compareTo(data) < 0)
                node.setRight(
                        delete(node.getRight(), data)
                );
            else if (node.getData().compareTo(data) > 0)
                node.setLeft(
                        delete(node.getLeft(), data)
                );
            else {
                if (node.getLeft() == null)
                    return node.getRight();
                else if(node.getRight() == null)
                    return node.getLeft();

                node.setData(
                        minV(node)
                );

                node.setRight(
                        delete(node.getRight(), (T) node.getData())
                );
            }
        }

        int balance = getBalance(node);

        if (balance > 1 && data.compareTo((T) node.getLeft().getData())<0)
            return rightRotate(node);

        if (balance < -1 && data.compareTo((T) node.getRight().getData()) > 0)
            return leftRotate(node);

        if (balance > 1 && data.compareTo((T) node.getLeft().getData()) > 0) {
            node.setLeft(
                    leftRotate(node.getLeft())
            );
            return rightRotate(node);
        }

        if (balance < -1 && data.compareTo((T) node.getRight().getData())<0) {
            node.setRight(
                    rightRotate(node.getRight())
            );
            return leftRotate(node);
        }



        return node;
    }
    private T minV(Node root){
        T minv = (T) root.getData();
        while (root.getLeft() != null){
            minv = (T) root.getLeft().getData();
            root = root.getLeft();
        }
        return minv;
    }
}
