package com.company.task1;

public class ArrayDeque<T> {
    private T[] data;
    private int head;
    private int tail;
    private int size;
    private int count;

    public ArrayDeque(){
        data = (T[]) new Comparable[16];
        count = 0;
        head = 0;
        tail = 0;
        size = 16;
    }

    public ArrayDeque(int n){
        data = (T[]) new Comparable[n];
        size = n;
        head = 0;
        tail = 0;
        count = 0;
    }



    public boolean isEmpty(){
        return count == 0;
    }
    public int size(){return count;}

    public void addFirst(T t){
        if (count == size -1)
            doubleCapacity();

        data[head] = t;
        head = (head + 1) % size;
        count ++;
    }

    public void addLast(T t){
        if (count == size -1)
            doubleCapacity();

        tail = ((tail - 1) % size);
        data[tail + size] = t;
        count ++;
    }

    public T removeFirst(){
        if (isEmpty())
            return null;
        T element = first();
        head = (head - 1) % size;
        count--;
        return element;
    }

    public T removeLast(){
        if (isEmpty())
            return null;
        T element = last();
        tail = (tail + 1) % size;
        count --;
        return element;
    }

    public T first(){
        if (isEmpty())
            return null;
        int first = head - 1;
        if (first < 0)
            first += size;
        return data[first % size];
    }

    public T last(){
        return isEmpty() ? null : data[(tail + size) % size];
    }

    private void doubleCapacity(){
        this.size *= 2;
        T[] newData = (T[]) new Comparable[size];
        int i = 0;
        while (!isEmpty()){
            newData[i] = removeFirst();
            i++;
        }
        this.count = newData.length;
        data = newData;
        head = 0;
        tail = count - 1;
    }

    @Override
    public String toString() {
        String string = "";
        while (!isEmpty()){
            string += removeFirst() + "\n";
        }
        return string;
    }
}
