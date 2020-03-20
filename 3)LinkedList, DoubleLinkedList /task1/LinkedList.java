package com.company.task1;


import com.company.Node;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head = null;
    private int size = 0;

    LinkedList(){}

    public void add(T item){
        if (head == null){
            head = new Node<>(item);
        }else{
            Node<T> tail  = head;
            while (tail.getNext() != null)
                tail = tail.getNext();
            Node newNode = new Node<>(item);
            tail.setNext(newNode);
//            newNode.setPrev(tail);
        }
        size++;
    }

    public void add(Node node){
        T item = (T) node.getItem();
        if (head == null){
            head = new Node<>(item);
        }else{
            Node<T> tail  = head;
            while (tail.getNext() != null)
                tail = tail.getNext();
            Node newNode = new Node<>(item);
            tail.setNext(newNode);
//            newNode.setPrev(tail);
        }
        size++;
    }



    public void add(int n, T item){
        if (n==0)
            addFirst(item);
        Node<T> current = head;
        for (int i=0; i<n-1; i++)
            current = current.getNext();
        Node newNode = new Node<>(item);
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        size++;
    }
    public void addAll(LinkedList<T> linkedList){
        for (int i =0 ; i < linkedList.size; i++){
            add(linkedList.get(i));
        }
        size += linkedList.size;
    }
    public void addFirst(T item){
        Node<T> newHead = new Node<>(item);
        newHead.setNext(head);
        head = newHead;
        size++;
    }
    public void set(int n, T item){
        Node<T> newNode = new Node<>(item);
        if (n == 0) {
            newNode.setNext(head.getNext());
            head = newNode;
        }
        Node<T> current = head;
        for (int i = 0; i < n - 1; i++) {
            current = current.getNext();
        }
        newNode.setNext(current.getNext().getNext());
        current.setNext(newNode);
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
    public void remove(T item){
        if (head.getNext().equals(item))
            remove();
        else {
            Node<T> current = head;
            while (current.getNext() != null){
                if (current.getNext().getItem().equals(item)){
                    current.setNext(current.getNext().getNext());
                    size--;
                    break;
                }current = current.getNext();
            }
        }size--;
    }
    public void clear(){ head = null; size =0; }

    public T getFirst(){ return head.getItem(); }
    public T getLast(){
        Node<T> tail = head;
        while (tail.getNext() != null){
            tail = tail.getNext();
        }
       return tail.getItem();
    }
    public int indexOf(T item){
        int n = 0;
        Node<T> current = head;
        while (current != null){
            if (current.getItem().equals(item)){
                return n;
            }n++;
            current = current.getNext();
        }
        return -1;
    }
    public T get(int n){
        if(n<0 || n>=size)
            return null;
        Node<T> current = head;
        for (int i=0; i<n;i++){
            current = current.getNext();
        }
        return current.getItem();
    }
    public LinkedList<T> clone(){
        LinkedList<T> linkedList = new LinkedList<>();
        Node<T> copy = head;

        while (copy != null){

            linkedList.add(new Node(copy.getItem()));

            copy = copy.getNext();

        }

        return linkedList;
    }



    public boolean isCenter(int index){
        Node<T> current = head;
        for (int i=0; i<index;i++){
            current = current.getNext();
        }
        int c = 0;
        Node<T> cd = head;
        while (cd != null){
            if (cd.getItem().compareTo(current.getItem()) > 0)
                c++;
            cd = cd.getNext();
        }

        return c == (size / 2);
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
}
