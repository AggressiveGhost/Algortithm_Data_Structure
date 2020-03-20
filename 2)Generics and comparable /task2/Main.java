package com.company.task2;

import java.util.ArrayList;

public class Main extends Currency{
    public static void main(String[] args) {
//        ArrayList<Money> array = new ArrayList<>();
//        array.add(new Money(100, Currency.ruble, 3));
//        array.add(new Money(300, Currency.euro, 4));
//        array.add(new Money(200, Currency.dollar, 5));
//        array.add(new Money(500, Currency.tenge, 7));
//        System.out.println(array);

        Wallet wallet = new Wallet();
        wallet.add(new Money(50, Currency.dollar, 8));
        wallet.add(new Money(130, Currency.euro, 3));
        wallet.add(new Money(500, Currency.euro, 2));
        wallet.add(new Money(1000, Currency.tenge, 50));
        wallet.add(new Money(1300, Currency.ruble, 8));
        wallet.add(new Money(5000, Currency.ruble, 5));
        wallet.add(new Money(400, Currency.ruble, 4));
        wallet.sort();
        System.out.println(wallet);
        System.out.println();

        Wallet wallet1 = new Wallet();
        wallet1.add(new Money(1300, Currency.ruble, 7));
        wallet1.add(new Money(50, Currency.dollar, 7));
        wallet1.add(new Money(500, Currency.euro, 1));
        wallet1.add(new Money(1000, Currency.tenge, 3));
        wallet1.add(new Money(5000, Currency.ruble, 4));
        wallet1.add(new Money(300, Currency.dollar, 6));
        wallet1.sort();
        System.out.println(wallet1);



        System.out.println(wallet.compareTo(wallet1));
    }
}
