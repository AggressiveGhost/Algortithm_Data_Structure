package com.company.task2;



public class Money implements Comparable<Money> {
    private int number;
    private int amount;
    private Banknote banknote;

    public Money() { }

    public Money(int number, Banknote banknote, int amount) {
        this.number = number;
        this.amount = amount;
        this.banknote = banknote;
    }

    public double toTenge(){ return (amount * number * banknote.getInTenge());}

    @Override
    public String toString() {
        return number + "" + banknote.getSymbol() + " -> " + number * amount + " "
                + banknote + " - "
                + toTenge() + "₸";
    }

    @Override
    public int compareTo(Money o) {
        if(this.toTenge() < o.toTenge())
            return 1;
        else if(this.toTenge() > o.toTenge())
            return -1;
        return 0;
    }
}
