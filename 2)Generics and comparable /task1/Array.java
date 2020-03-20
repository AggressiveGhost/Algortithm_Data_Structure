package com.company.task1;


public  class Array<T extends Comparable<T>> {
    private int size = 0;
    private int DEFAULTSIZE = 10;
    private T[] array;

    Array(){ array = (T[])new Comparable[DEFAULTSIZE]; }

    public T get(int i){ return array[i]; }

    //Resizing
    private void increaseArray(){
        this.DEFAULTSIZE *= 2;
        T[] newArray = (T[])new Comparable[DEFAULTSIZE];
        for (int i = 0 ; i < size; i++)
            newArray[i] = array[i];
        this.array = newArray;
    }
    private void dicreaseArray(){
        this.DEFAULTSIZE  -= (DEFAULTSIZE/3);
        T[] newArray = (T[])new Comparable[DEFAULTSIZE];
        for (int i = 0 ; i < size; i++)
            newArray[i] = array[i];
        this.array = newArray;
    }


    public void add(T t){
        if(size>=DEFAULTSIZE)
            increaseArray();

        array[size] = t;
        size++;
    }

    public void remove(int n){

        if(DEFAULTSIZE / size >= 3) dicreaseArray();

        for(int i = n; i < array.length - 1; ++i) {
            this.array[i] = array[i + 1];
        }
        size--;
    }

    public int size(){return size;}

    public void sort(){ QuickSort(0, size-1); }

    // Sorting
    private int partition(int low, int high){
        @SuppressWarnings("unchecked")
        T pivot = (T) array[high];
        int j   = low -1;

        for (int i= low; i<high; i++){
            @SuppressWarnings("unchecked")
            T a             = (T) array[i];
            if(a.compareTo(pivot) < 0){
                j++;
                T temp   = (T)array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }

        T temp = array[j+1];
        array[j+1]  = array[high];
        array[high] = temp;

        return j+1;
    }



    private void QuickSort(int low, int high){
        if(low < high) {
            int pi = partition(low, high);
            QuickSort(low, pi - 1);
            QuickSort(pi + 1, high);
        }
    }

    @Override
    public String toString() {
        String string = "";
        for (int i=0; i<size; i++)
            string += array[i] + "\n";
        return string;
    }
}