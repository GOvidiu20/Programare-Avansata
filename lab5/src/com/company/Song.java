package com.company;

public class Song extends Item {
    public Song(String id, String name, String location, int stars) {
        this.setId(id);
        this.setName(name);
        this.setPath(location);
        this.setStars(stars);
    }
}
