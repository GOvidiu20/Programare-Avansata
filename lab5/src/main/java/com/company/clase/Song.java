package com.company.clase;

public class Song extends Item {
    public Song(){}
    public Song(String name, String location, int stars) {
        this.setName(name);
        this.setPath(location);
        this.setStars(stars);
    }
}
