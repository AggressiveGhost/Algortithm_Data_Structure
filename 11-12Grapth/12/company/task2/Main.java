package com.company.task2;

import com.company.Graph;
import com.company.classes.City;

public class Main {
    public static void main(String[] args) {
        City aktau      = new City("Aktau",     76);
        City atyrau     = new City("Atyrau",    55);
        City aktobe     = new City("Aktobe",    87);
        City qyzylorda  = new City("Qyzylorda", 105);
        City turkistan  = new City("Turkistan", 45);
        City shymkent   = new City("Shymkent",  50);
        City karagandy  = new City("Karagandy", 98);
        City nursultan  = new City("Nursultan", 220);
        City shu        = new City("Shu",       20);
        City almaty     = new City("Almaty",    120);
        City semey      = new City("Semey",     35);
        City oskemen    = new City("Oskemen",   68);

        Graph<City> list = new Graph<>(false);
        list.put(aktau,         atyrau,     6);
        list.put(aktau,         qyzylorda,  6);
        list.put(atyrau,        qyzylorda,  8);
        list.put(atyrau,        aktobe,     4);
        list.put(aktobe,        qyzylorda,  14);
        list.put(qyzylorda,     turkistan,  3);
        list.put(turkistan,     shymkent,   5);
        list.put(shymkent,      karagandy,  13);
        list.put(qyzylorda,     karagandy,  12);
        list.put(aktobe,        nursultan,  9);
        list.put(nursultan,     karagandy,  4);
        list.put(shymkent,      almaty,     10);
        list.put(almaty,        karagandy,  16);
        list.put(almaty,        shu,        4);
        list.put(almaty,        oskemen,    19);
        list.put(oskemen,       karagandy,  16);
        list.put(oskemen,       semey,      6);
        list.put(almaty,        semey,      17);
        list.put(semey,         nursultan,  6);

        list.ambulance(shymkent, 17);

    }
}
