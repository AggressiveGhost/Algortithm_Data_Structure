package com.company.task3;

public class Student implements Comparable<Student> {
    private String name;
    private int year;
    private double gpa;

    public Student() {
    }

    public Student(String name, int year, double gpa) {
        this.name = name;
        this.year = year;
        this.gpa = gpa;
    }

    public Student(Student s){
        this.name = s.getName();
        this.year = s.getYear();
        this.gpa = s.getGpa();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        if (gpa>o.getGpa())
            return 1;
        else if(gpa < o.getGpa())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", gpa=" + gpa +
                '}';
    }
}
