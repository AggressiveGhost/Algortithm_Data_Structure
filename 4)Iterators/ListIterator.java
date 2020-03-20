package com.company;

import java.util.Iterator;



public class ListIterator<T extends Comparable<T>> implements Iterator<T>{

    private Node<T> current;
    private boolean ishead;


    public ListIterator(DoubleLinkedList<T> doubleLinkedList, boolean ishead){

        if (ishead)
            current = doubleLinkedList.getHead();
        else
            current = doubleLinkedList.getTail();

        this.ishead = ishead;
    }

    public boolean hasNext(){
        return current != null;
    }

    public T next(){
        if (hasNext()){
            T item = current.getItem();

            if (ishead)
                current = current.getNext();
            else
                current = current.getPrev();

            return item;
        }
        return null;
    }
}
