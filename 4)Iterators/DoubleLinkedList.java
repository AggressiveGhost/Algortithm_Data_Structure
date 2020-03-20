package com.company;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoubleLinkedList<T extends Comparable<T>> implements Iterable<T>{
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;
    public DoubleLinkedList(){}

    //--------------------------
    private boolean getPosition(int n){
        if (size/2 > n)
            return true; // --left
        return false; // --right
    }
    private Node<T> getNode(int n){
        if (getPosition(n)){
            Node<T> h = head;
            for (int i = 0; i<n-1; i++){
                h = h.getNext();
            }
            return h;
        }else if (!getPosition(n)){
            Node<T> t = tail;
            for (int i = size -1 ; i >= n; i--){
                t = t.getPrev();
            }
            return t;
        }
        return null;
    }
    //--------------------------

    public void add(T item){
        if (size == 0){
            head = new Node<>(item);
            tail = head;
        }else if(size == 1){
            tail = new Node<>(item);
            head.setNext(tail);
            tail.setPrev(head);
        }else{
            Node<T> newNode = new Node<>(item);
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }
    private void addFront(T item){
        Node<T> newNode = new Node<>(item);
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }
    public void add(T item, Boolean bool){
        if (bool)
            addFront(item);
        else
            add(item);
    }
    public void add(int n, T item){
        if (n==0)
            addFront(item);
        else if(n == size)
            add(item);
        else {
            Node<T> current = getNode(n);
            Node<T> newNode = new Node<>(item);
            newNode.setNext(current.getNext());
            current.getNext().setPrev(newNode);
            current.setNext(newNode);
            current.setPrev(current);
        }
        size++;
    }
    public void set(int n , T item){
        Node<T> newNode = new Node<>(item);
        if (n == 0){
            newNode.setNext(head.getNext());
            head = newNode;
        }else if(n == size - 1){
            newNode.setPrev(tail.getPrev());
            tail.getPrev().setNext(newNode);
            tail = newNode;
        }else {
            Node<T> current = getNode(n);
            newNode.setNext(current.getNext().getNext());
            current.getNext().getNext().setPrev(newNode);
            newNode.setPrev(current);
            current.setNext(newNode);
        }
    }

    public T getFirst(){return head.getItem();}
    public T getLast(){return tail.getItem();}
    public T get(int n){
        if (n == 0)
            return getFirst();
        else if (n == size - 1)
            return getLast();
        return getNode(n).getNext().getItem();
    }
    public Node<T> getHead(){return head;}
    public Node<T> getTail(){return tail;}

    public void remove(Boolean bool){
        if (bool)
            removeHead();
        else
            removeTail();
        size--;
    }
    public void remove(int n){
        if (n == 0)
            removeHead();
        else if(n==size-1)
            removeTail();
        else {
            Node<T> current = getNode(n);
            current.getNext().getNext().setPrev(current);
            current.setNext(current.getNext().getNext());
        }
        size--;
    }
    private void removeHead(){
        head.getNext().setPrev(null);
        head = head.getNext();
    }
    private void removeTail(){
        tail.getPrev().setNext(null);
        tail = tail.getPrev();
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
    public int size(){return size;}

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this, true);
    }

    public Iterator<T> backwardIterator() {
        return new ListIterator<>(this, false);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
