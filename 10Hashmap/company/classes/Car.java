package com.company.classes;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private int ID;
    private String name;
    private int year;
    private int maxSpeed;

    public Car(int ID, String name, int year, int maxSpeed) {
        this.ID = ID;
        this.name = name;
        this.year = year;
        this.maxSpeed = maxSpeed;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return ID == car.ID &&
                year == car.year &&
                maxSpeed == car.maxSpeed &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, year, maxSpeed);
    }

    @Override
    public String toString() {
        String string = "[" +Math.abs(name.hashCode() % 10) + "," + name + "," + year + "," + maxSpeed+"]";
        return string;
    }

    @Override
    public int compareTo(Car o) {

        if (name.compareTo(o.name) > 0)
            return 1;
        else if (name.compareTo(o.name) < 0)
            return -1;
        return 0;
    }
}
