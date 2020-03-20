package com.company.task2;

public class PriorityQueue<T extends Comparable<T>> {
    private T[] data;
    private int head;
    private int tail;
    private int size;
    private int count;

    public PriorityQueue(){
        data = (T[]) new Comparable[16];
        head = 0;
        tail = 0;
        size = 16;
        count = 0;
    }
    public void insert(T t){
        if (count == 0 || first().compareTo(t) > 0)
            addFirst(t);
        else if(last().compareTo(t) < 0)
            addLast(t);
        else{
            int h = head;
            while (!isEmpty()){
                T element = first(h);
                if (element.compareTo(t) >= 0){
                    move(h);
                    break;
                }
                h = (h - 1) % size;
            }
            count++;
        }
    }
    public boolean isEmpty(){return count == 0;}

    private T first(int n){
        if (isEmpty())
            return null;
        int first = n - 1;
        if (first < 0)
            first += size;
        return data[first % size];
    }
    private T first(){
        if (isEmpty())
            return null;
        int first = head - 1;
        if (first < 0)
            first += size;
        return data[first % size];
    }
    private T last(){
        return isEmpty() ? null : data[(tail + size) % size];
    }
    private void addFirst(T t){
        if (count == size -1)
            doubleCapacity();

        data[head] = t;
        head = (head + 1) % size;
        count ++;
    }
    private void addLast(T t){
        if (count == size -1)
            doubleCapacity();

        tail = ((tail - 1) % size);
        data[tail + size] = t;
        count ++;
    }
    private void doubleCapacity(){
    }
    private int indexArray(int n){
        int index = n - 1;
        if (index < 0)
            index += size;
        return index;
    }
    private void move(int current){
        for (int i = tail;i < current; i++){
            data[indexArray(i)] = data[indexArray(i+1)];
        }
    }
    public T remove(){
        T element = first();
        head = (head - 1) % size;
        count--;
        return element;
    }
    public T peek(){
        return first();
    }

    @Override
    public String toString() {
        String s = "";
        while (!isEmpty()){

        }
        return "PriorityQueue{}";
    }
}
