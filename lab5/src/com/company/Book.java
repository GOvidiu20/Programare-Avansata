package com.company;

public class Book extends Item{
    public Book(String id,String name,String location,int stars) {
        this.setId(id);
        this.setName(name);
        this.setPath(location);
        this.setStars(stars);
    }

}
