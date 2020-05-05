package com.company.classes;

public class User implements Comparable<User>{
    private String name;
    private int subs;

    public User(String name, int subs) {
        this.name = name;
        this.subs = subs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubs() {
        return subs;
    }

    public void setSubs(int subs) {
        this.subs = subs;
    }

    @Override
    public int compareTo(User o) {
        if (name.equals(o.name))
            return 0;
        return -1;
    }
}
