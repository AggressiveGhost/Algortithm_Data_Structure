package com.company.task1;


import com.company.task1.LinkedList;
import com.company.task3.Student;

public class Main {


    public static void main(String[] args) {
//        ArrayList
	// write your code here
//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add("1");
//        linkedList.add("2");
//        linkedList.add("3");
//        linkedList.add("4");
//        linkedList.add("5");
////        System.out.println(linkedList.indexOf("3"));
//
//        LinkedList<String> linkedList1 = new LinkedList<>();
//        linkedList1.add("pp");
//        linkedList1.add("aa");
//        linkedList1.add("qq");
//        System.out.println(linkedList1.get(0));
//
//        LinkedList<String> l2 = linkedList1.clone();
//        System.out.println(l2.get(0).toUpperCase());

//        System.out.println(linkedList1.get(0));


//        System.out.println(linkedList.getFirst());
//        System.out.println(linkedList.getLast());

//        System.out.println(linkedList);
//        linkedList.clear();
//        linkedList.remove();
//        linkedList.remove(4);
//        linkedList.remove("3");
//        linkedList.set(4,"ff");
//        linkedList.addFirst("0");
//        System.out.println(linkedList.indexOf("4"));
//        System.out.println(linkedList.get(4));
//        linkedList.addAll(linkedList1);
//        linkedList.add(2, "tt");
//        System.out.println(linkedList);
//        System.out.println(linkedList.clone());

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(new Student("a", 15, 4.4));
        studentLinkedList.add(new Student("b", 15, 4.5));
        studentLinkedList.add(new Student("c", 15, 4.6));
        studentLinkedList.add(new Student("d", 15, 4.7));


        LinkedList<Student> n = studentLinkedList.clone();
        studentLinkedList.get(0).setName("123");
        System.out.println(studentLinkedList);

        System.out.println("\n\n");
        System.out.println(n);



    }
}
