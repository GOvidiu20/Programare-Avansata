package com.company;
import com.github.javafaker.Faker;
public class School {
    private String name;
    private int capacity;
    public School(Faker name,int capacity) {
        this.name = name.university().name();
        this.capacity=capacity;
    }
    public String getName() {
        return this.name;
    }
    public void setName(Faker name) {
        this.name =name.university().name();
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
