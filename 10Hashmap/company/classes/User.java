package com.company.classes;

public class User implements Comparable<User> {

    private String login;
    private int age;
    private String password;


    public User(String login, int age, String password) {
        this.login = login;
        this.age = age;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        if (login.compareTo(o.login) > 0)
            return 1;
        else if(login.compareTo(o.login) < 0)
            return -1;
        return 0;
    }
}
