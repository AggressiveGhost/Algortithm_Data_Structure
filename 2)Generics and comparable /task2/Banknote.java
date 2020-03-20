package com.company.task2;

public class Banknote {
    private String name;
    private double inTenge;
    private String symbol;

    public Banknote(String name, double inTenge, String symbol) {
        this.name    = name;
        this.inTenge = inTenge;
        this.symbol  = symbol;
    }

    public String getName() {
        return name;
    }

    public double getInTenge() {
        return inTenge;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return name;
    }
}
