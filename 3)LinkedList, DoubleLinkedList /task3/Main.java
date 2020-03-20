package com.company.task3;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new List<>();
        studentList.addSorted(new Student("aa", 18, 2.0));
        studentList.addSorted(new Student("aa", 18, 3.2));
        studentList.addSorted(new Student("aa", 18, 3.3));
        studentList.addSorted(new Student("aa", 18, 3.8));
        studentList.addSorted(new Student("aa", 18, 3.0));
        studentList.addSorted(new Student("aa", 18, 4.8));
        studentList.addSorted(new Student("aa", 18, 3.9));
        studentList.addSorted(new Student("aa", 18, 3.6));
        studentList.addSorted(new Student("aa", 18, 3.1));
        studentList.addSorted(new Student("aa", 18, 2.8));


        System.out.println(studentList);
    }
}
