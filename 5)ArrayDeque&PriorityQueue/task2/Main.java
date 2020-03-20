package com.company.task2;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<String> string = new PriorityQueue<>();
        string.insert("d");
        string.insert("e");
        string.insert("a");
        string.insert("b");
        string.insert("f");
        string.insert("g");
        string.insert("c");



        System.out.println(string.peek());
        System.out.println(string.remove());
        System.out.println(string.peek());



    }
}
