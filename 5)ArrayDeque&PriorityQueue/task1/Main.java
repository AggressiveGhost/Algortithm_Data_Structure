package com.company.task1;

public class Main {

    public static void main(String[] args) {
        ArrayDeque<String> a = new ArrayDeque<>();
        a.addFirst("1");
        a.addFirst("2");
        a.addFirst("3");
        a.addFirst("4");
        a.addFirst("5");
        a.addFirst("6");
        a.addFirst("7"); // head

        a.addLast("8");
        a.addLast("9");
        a.addLast("10");
        a.addLast("11");
        a.addLast("12");
        a.addLast("13");
        a.addLast("14");
        a.addLast("15");
//        System.out.println(a.removeFirst() + " ---- ");
//        System.out.println(a.removeFirst() + " --- -");
//        a.addLast("16");
//        a.addLast("17");
//        a.addLast("18"); // tail


//        a.last();
//        System.out.println(a.removeLast() + "wq");

//        System.out.println(a);

        while (!a.isEmpty()){
////            System.out.println(a.size() + "-----");
//            System.out.println(a.removeFirst() + "head");
            System.out.println(a.removeFirst());
//            System.out.println(a.size() + "size");
//            System.out.println();
        }
    }
}
