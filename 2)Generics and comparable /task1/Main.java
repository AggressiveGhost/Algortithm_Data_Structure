package com.company.task1;

public class Main {

    public static void main(String[] args) {
       Array<Student> studentArray = new Array<>();
       studentArray.add(new Student("aaa", 19, 3.3));
       studentArray.add(new Student("bbb", 18, 3.1));
       studentArray.add(new Student("ccc", 17, 2.2));
       studentArray.add(new Student("jjj", 17, 2.0));
       studentArray.add(new Student("jjj", 17, 2.0));
       studentArray.add(new Student("mmm", 17, 4.0));
       studentArray.remove(5);
//       studentArray.sort();
       System.out.println(studentArray);

//        Array<Employee> employeeArray = new Array<>();
//
//        employeeArray.add(new Employee("eee", 5555));
//        employeeArray.add(new Employee("bbb", 2222));
//        employeeArray.add(new Employee("ccc", 3333));
//        employeeArray.add(new Employee("aaa", 1111));
//        employeeArray.add(new Employee("ddd", 4444));
//        employeeArray.sort();
//        System.out.println(employeeArray);


    }
}
