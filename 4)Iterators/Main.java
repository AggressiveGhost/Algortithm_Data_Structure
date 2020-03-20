package com.company;

import com.company.classes.Student;

import java.util.Iterator;

public class Main {

    public static void main(String[] h) {



	   DoubleLinkedList<Student> students = new DoubleLinkedList<>();
	   students.add(new Student("aa", 19, 4.0));
	   students.add(new Student("bb", 14, 3.1));
	   students.add(new Student("vv", 15, 3.0));
	   students.add(new Student("dd", 17, 2.0));
	   students.add(new Student("qq", 14, 3.5));

	   Iterator<Student> it = students.iterator();
//
//	   ListIterator<Student> l = new ListIterator<>(students, true);
//	   while (l.hasNext()){
//		   System.out.println(l.next());
//	   }

//
//		while (it.hasNext()){
//			System.out.println(it.next());
//		}


		for (Student s : students){
			System.out.println(s);
		}


    }
}
