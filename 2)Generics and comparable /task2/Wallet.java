package com.company.task2;

public class Wallet implements Comparable<Wallet> {
    private int size = 0;
    private int DEFAULTSIZE = 10;
    private Money[] monies;

    public Wallet() {this.monies = new Money[DEFAULTSIZE];}
    public Wallet(int n){
        this.monies = new Money[n];
        this.DEFAULTSIZE = n;
    }

    private void increaseWallet(){
        this.DEFAULTSIZE *= 2;
        Money[] newMonies = new Money[DEFAULTSIZE];
        for (int i=0; i<size; i++)
            newMonies[i] = monies[i];
        this.monies = newMonies;
    }

    public Money get(int i){return monies[i];}
    public void add(Money m){
        if(size>=DEFAULTSIZE)
            increaseWallet();

        monies[size] = m;
        size++;
    }
    public int size(){return size;}

    public void sort(){
        QuickSort(0, size-1);
    }

    private int partition(int low, int high) {
        Money pivot = monies[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (pivot.compareTo(monies[j])<0) {
                i++;
                Money temp = monies[i];
                monies[i] = monies[j];
                monies[j] = temp;
            }
        }

        Money temp = monies[i + 1];
        this.monies[i + 1] = monies[high];
        this.monies[high] = temp;
        return i + 1;
    }
    public void QuickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            QuickSort(low, pi - 1);
            QuickSort(pi + 1, high);
        }
    }

    @Override
    public String toString() {
        String string = "";
        for (int i=0; i<size; i++) {
            string += monies[i] + "\n";
        }
        return string;
    }

    @Override
    public int compareTo(Wallet o) {
        double thisWallet   = 0.0;
        double oWallet      = 0.0;

       for (int i=0; i<this.size; i++)
            thisWallet      += this.monies[i].toTenge();

        for (int i=0; i<o.size; i++)
            oWallet         += o.monies[i].toTenge();



        if(thisWallet > oWallet)
            return 1;
        else if(thisWallet < oWallet)
            return -1;
        return 0;
    }
}
