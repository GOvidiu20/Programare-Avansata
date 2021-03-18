package com.company;

import com.github.javafaker.Faker;

public class Student{
    private String name;
    private double score;
    public Student(){};
    public Student(Faker name,double x) {
        this.name = name.name().fullName();
        this.score=x;
    }
    public String getName() {
        return this.name;
    }
    public void setName(Faker name) {
        this.name = name.name().fullName();
    }
    public double getScore() {
        return score;
    }
    public void setScore(double score) {
        this.score = score;
    }

}
