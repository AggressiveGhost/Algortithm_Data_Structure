package com.company.task1;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double gpa;

    public Student() { }

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gpa=" + gpa +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(gpa>o.gpa)
            return 1;
        else if(gpa<o.gpa)
            return -1;
        return 0;
    }
}
