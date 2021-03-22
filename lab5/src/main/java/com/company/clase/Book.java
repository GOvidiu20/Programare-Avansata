package com.company.clase;

public class Book extends Item{
    public Book(){}
    public Book(String name,String location,int stars) {
        this.setName(name);
        this.setPath(location);
        this.setStars(stars);
    }

}