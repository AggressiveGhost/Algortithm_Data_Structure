package com.company.task1;

public class Employee implements Comparable<Employee> {

    private String name;
    private int salary;

    public Employee() { }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if(salary > o.salary)
            return 1;
        else if(salary<o.salary)
            return -1;
        return 0;
    }
}
