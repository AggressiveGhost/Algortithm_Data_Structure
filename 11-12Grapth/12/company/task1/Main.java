package com.company.task1;

import com.company.Graph;
import com.company.classes.User;

public class Main {

    public static void main(String[] args) {
        User a = new User("A", 1);
        User b = new User("B", 3);
        User c = new User("C", 7);
        User d = new User("D", 9);
        User e = new User("E", 5);
        User f = new User("F", 6);
        User g = new User("G", 2);
        User h = new User("H", 4);
        User i = new User("I", 8);
        Graph<User> list = new Graph<>(true);
        list.put(a,h);

        list.put(g,a);
        list.put(g,b);
        list.put(g,e);//

        list.put(b,e);//

        list.put(f,d);

        list.put(d,e);//
        list.put(d,i);

        list.put(i,c);
        list.put(i,h);
        list.put(i,f);

        list.put(c,e);//

        list.put(e,a);
        list.put(e,h);
        list.put(e,f);

        System.out.println(list.coverage(e));
    }
}