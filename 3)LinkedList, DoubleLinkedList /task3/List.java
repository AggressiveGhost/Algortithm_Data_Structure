package com.company.task3;

import com.company.Node;

public class List<T extends Comparable<T>> {
    private Node<T> head = null;
    private int size = 0;

    public List(){}

    public void addSorted(T item){
        Node<T> newNode = new Node<>(item);
        Node<T> current = head;
        if (size == 0){
            head = newNode;
        }else if (current.getItem().compareTo(newNode.getItem()) > 0){
            newNode.setNext(head);
            head = newNode;
        }else{
            while (current.getNext() != null) {
                if (current.getNext().getItem().compareTo(newNode.getItem()) > 0) {
                    newNode.setNext(current.getNext());
                    current.setNext(newNode);
                    break;
                }
                current = current.getNext();
            }
            if (current.getNext() == null)
                current.setNext(new Node<>(item));
        }
        size++;
    }

    @Override
    public String toString() {
        String string = "";
        Node<T> current = head;
        while (current != null){
            string += current.getItem() + "\n";
            current = current.getNext();
        }
        return string;
    }

    public T getLast(){
        Node<T> tail = head;
        while (tail.getNext() != null){
            tail = tail.getNext();
        }

        return tail.getItem();
    }

    public void remove(){
        try {
            head = head.getNext();
        }catch (Exception e){
            e.printStackTrace();
        }size--;
    }
    public void remove(int n){
        if (n == 0)
            remove();
        else if(n>0) {
            Node<T> current = head;
            for (int i = 0; i < n - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
        }
    }
}
